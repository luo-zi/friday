package edu.friday.common.sec.serv;

import edu.friday.common.enums.UserStatus;
import edu.friday.common.sec.LoginUser;
import edu.friday.model.SysUser;
import edu.friday.model.vo.SysUserVO;
import edu.friday.service.SysUserService;
import edu.friday.utils.BeanUtils;
import edu.friday.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServImpl implements UserDetailsService {
    private static final Logger log = LoggerFactory.getLogger(UserDetailsServImpl.class);
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysPermissionServ permissionServ;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SysUser sysUser = sysUserService.selectUserByUserName(username);
        if (StringUtils.isNull(sysUser)) {
            log.info("登录用户{}不存在", username);
            throw new UsernameNotFoundException("用户不存在");
        } else if (UserStatus.DELETED.getCode().equals(sysUser.getDelFlag())) {
            log.info("登录用户{}已被删除", username);
            throw new UsernameNotFoundException("用户已删除");
        } else if (UserStatus.DISABLE.getCode().equals(sysUser.getStatus())) {
            log.info("登录用户{}已被停用", username);
            throw new UsernameNotFoundException("用户已停用");
        }
        return createLoginUser(sysUser);
    }

    public UserDetails createLoginUser(SysUser user) {
        SysUserVO sysUserVO = new SysUserVO();
        BeanUtils.copyProperties(user, sysUserVO);
        return new LoginUser(sysUserVO, permissionServ.getMenuPermission(sysUserVO));
    }
}
