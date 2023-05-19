package edu.friday.service;

import edu.friday.model.SysUser;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SysUserService {
    public List<SysUser> selectUserList();
}
