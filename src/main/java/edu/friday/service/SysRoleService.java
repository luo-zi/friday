package edu.friday.service;

import edu.friday.model.SysRole;

import java.util.List;

public interface SysRoleService {
    List<SysRole> selectRoleAll();

    List<Long> selectRoleByUserId(Long userId);
}
