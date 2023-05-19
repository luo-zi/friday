package edu.friday.controller;

import edu.friday.model.SysUser;
import edu.friday.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/system/user")
public class SysUserController {
    @Autowired
    SysUserService userService;
    @GetMapping("/list")
    public List<SysUser> list(){
        return userService.selectUserList();
    }
}
