package edu.friday.service;

import edu.friday.model.SysRole;

import java.util.List;
import java.util.Set;

public interface SysRoleService {
    List<SysRole> selectRoleAll();

    List<SysRole> selectRoleByUserId(Long userId);

    Set<String> selectRolePermissionByUserId(Long userId);
}
