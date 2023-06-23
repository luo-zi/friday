package edu.friday.service.impl;

import edu.friday.model.SysRole;
import edu.friday.repository.SysRoleRepository;
import edu.friday.service.SysRoleService;
import edu.friday.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    SysRoleRepository sysRoleRepository;

    @Override
    public List<SysRole> selectRoleAll() {
        return sysRoleRepository.findAll();
    }

    @Override
    public List<SysRole> selectRoleByUserId(Long userId) {
        return sysRoleRepository.selectRoleIdsByUserId(userId);
    }

    @Override
    public Set<String> selectRolePermissionByUserId(Long userId) {
        List<SysRole> perms = sysRoleRepository.selectRoleIdsByUserId(userId);
        Set<String> permsSet = new HashSet<>();
        for (SysRole perm : perms) {
            if (StringUtils.isNotNull(perm)) {
                permsSet.addAll(Arrays.asList(perm.getRoleKey().trim().split(",")));
            }

        }
        return permsSet;
    }
}
