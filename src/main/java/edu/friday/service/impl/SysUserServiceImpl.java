package edu.friday.service.impl;

import edu.friday.common.constant.UserConstants;
import edu.friday.common.result.TableDataInfo;
import edu.friday.model.SysUser;
import edu.friday.model.vo.SysUserVO;
import edu.friday.repository.SysUserRepository;
import edu.friday.service.SysUserService;
import edu.friday.utils.BeanUtils;
import edu.friday.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    SysUserRepository sysUserRepository;

    @Override
    public TableDataInfo selectUserList(SysUserVO user, Pageable page) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyPropertiesIgnoreEmpty(user, sysUser);
        sysUser.setDelFlag("0");
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("userName", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("phoneNumber", ExampleMatcher.GenericPropertyMatchers.contains());
        Example<SysUser> example = Example.of(sysUser, exampleMatcher);
        Page<SysUser> rs = sysUserRepository.findAll(example, page);
        return TableDataInfo.success(rs.toList(), rs.getTotalElements());
    }

    @Override
    public boolean insert(SysUserVO user) {
        return false;
    }

    @Override
    public String checkEmailUnique(SysUserVO user) {
        SysUser user1 = new SysUser();
        BeanUtils.copyProperties(user, user1);
        return checkUnique(user1);
    }

    @Override
    public String checkPhoneNumberUnique(SysUserVO user) {
        SysUser user1 = new SysUser();
        BeanUtils.copyProperties(user, user1);
        return checkUnique(user1);
    }

    @Override
    public String checkUserNameUnique(String username) {
        SysUser sysUser = new SysUser();
        sysUser.setUserName(username);
        return count(sysUser);
    }

    @Override
    @Transactional
    public boolean insertUser(SysUserVO user) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(user, sysUser);
        sysUser.setDelFlag("0");
        sysUserRepository.save(sysUser);
        user.setUserId(sysUser.getUserId());
        insertUserRole(user);
        return null != sysUser.getUserId();
    }

    @Transactional
    public int insertUserRole(SysUserVO userVO) {
        Long[] roles = userVO.getRoleds();
        if (StringUtils.isNull(roles) || roles.length == 0) {
            return 0;
        }
        Long[] userIds = new Long[roles.length];
        Arrays.fill(userIds, userVO.getUserId());
        return sysUserRepository.batchInsertUserRole(userIds, roles);
    }

    public String count(SysUser sysUser) {
        Example<SysUser> example = Example.of(sysUser);
        long count = sysUserRepository.count(example);
        return count > 0 ? UserConstants.NOT_UNIQUE : UserConstants.UNIQUE;
    }

    public String checkUnique(SysUser sysUser) {
        Long userId = StringUtils.isNull(sysUser.getUserId()) ? -1L : sysUser.getUserId();
        Example<SysUser> example = Example.of(sysUser);
        SysUser info = findOne(example);
        if (StringUtils.isNotNull(info) && info.getUserId().longValue() != sysUser.getUserId()) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    public SysUser findOne(Example<SysUser> example) {
        List<SysUser> list = sysUserRepository.findAll(example, PageRequest.of(0, 1)).toList();
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public int deleteUserByIds(long[] userIds) {
        return sysUserRepository.deleteUserByIds(userIds);
    }

    @Override
    public boolean updateUser(SysUserVO user) {
        Long userId = user.getUserId();
        if (userId == null) {
            return false;
        }
        Optional<SysUser> op = sysUserRepository.findById(userId);

        if (!op.isPresent()) {
            return false;
        }
        sysUserRepository.deleteUserRoleByUserId(userId);
        SysUser sysUser = op.get();
        BeanUtils.copyPropertiesIgnoreNull(user, sysUser);
        sysUserRepository.save(sysUser);
        insertUserRole(user);
        return null != sysUser.getUserId();

    }

    @Override
    public SysUser selectUserById(Long userId) {
        SysUser sysUser = new SysUser();
        sysUser.setUserId(userId);
        sysUser.setDelFlag("0");
        return sysUserRepository.findOne(Example.of(sysUser)).get();
    }

    @Override
    public SysUser selectUserByUserName(String username) {
        SysUser sysUser = new SysUser();
        sysUser.setUserName(username);
        sysUser.setDelFlag("0");
        Example<SysUser> example = Example.of(sysUser);
        return findOne(example);
    }
}
