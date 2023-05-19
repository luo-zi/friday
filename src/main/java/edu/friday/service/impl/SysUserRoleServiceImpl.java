package edu.friday.service.impl;

import edu.friday.model.SysUserRole;
import edu.friday.repository.SysUserRoleRepository;
import edu.friday.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {
    @Autowired
    SysUserRoleRepository sysUserRoleRepository;
    @Override
    public List<SysUserRole> selectUserRoleList() {
        return sysUserRoleRepository.findAll();
    }
}
