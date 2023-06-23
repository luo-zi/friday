package edu.friday.common.sec.serv;

import edu.friday.model.vo.SysUserVO;
import edu.friday.service.SysMenuService;
import edu.friday.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class SysPermissionServ {
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysMenuService sysMenuService;

    public Set<String> getRolePermission(SysUserVO userVO) {
        Set<String> roles = new HashSet<String>();
        if (userVO.isAdmin()) {
            roles.add("admin");
        } else {
            roles.addAll(sysRoleService.selectRolePermissionByUserId(userVO.getUserId()));
        }
        return roles;
    }

    public Set<String> getMenuPermission(SysUserVO user) {
        Set<String> roles = new HashSet<String>();
        if (user.isAdmin()) {
            roles.add("*:*:*");

        } else {
            roles.addAll(sysMenuService.selectMenuPermsByUserId(user.getUserId()));
        }
        return roles;
    }
}
