package edu.friday.service.impl;

import edu.friday.model.SysUser;
import edu.friday.repository.SysUserRepository;
import edu.friday.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    SysUserRepository sysUserRepository;
    @Override
    public List<SysUser> selectUserList() {
        return sysUserRepository.findAll();
    }
}
