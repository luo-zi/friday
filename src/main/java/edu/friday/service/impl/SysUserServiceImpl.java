package edu.friday.service.impl;

import edu.friday.common.result.TableDataInfo;
import edu.friday.model.SysUser;
import edu.friday.model.vo.SysUserVO;
import edu.friday.repository.SysUserRepository;
import edu.friday.service.SysUserService;
import edu.friday.utils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    SysUserRepository sysUserRepository;
    @Override
    public TableDataInfo selectUserList(SysUserVO user, Pageable page) {
        SysUser sysUser=new SysUser();
        BeanUtils.copyPropertiesIgnoreEmpty(user,sysUser);
        sysUser.setDelFlag("0");
        ExampleMatcher exampleMatcher=ExampleMatcher.matching()
                .withMatcher("userName",ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("phoneNumber",ExampleMatcher.GenericPropertyMatchers.contains());
        Example<SysUser> example=Example.of(sysUser,exampleMatcher);
        Page<SysUser> rs=sysUserRepository.findAll(example,page);
        return TableDataInfo.success(rs.toList(),rs.getTotalElements());
    }
}
