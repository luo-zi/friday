package edu.friday.service.impl;

import edu.friday.model.SysRole;
import edu.friday.repository.SysRoleRepository;
import edu.friday.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    SysRoleRepository sysRoleRepository;

    @Override
    public List<SysRole> selectRoleAll() {
        return sysRoleRepository.findAll();
    }

    @Override
    public List<Long> selectRoleByUserId(Long userId) {
        return sysRoleRepository.selectRoleIdsByUserId(userId);
    }
}
