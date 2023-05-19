package edu.friday.controller;

import edu.friday.model.SysUserRole;
import edu.friday.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/system/role")
public class SysUserRoleController {
    @Autowired
    SysUserRoleService  sysUserRoleService;
    @GetMapping("/list")
    public List<SysUserRole> list(){
        return sysUserRoleService.selectUserRoleList();
    }
}
