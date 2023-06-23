package edu.friday.service.impl;

import edu.friday.repository.SysMenuRepository;
import edu.friday.service.SysMenuService;
import edu.friday.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class SysMenuServiceImpl implements SysMenuService {
    @Autowired
    SysMenuRepository sysMenuRepository;

    @Override
    public HashSet<String> selectMenuPermsByUserId(Long userId) {
        List<String> perms = sysMenuRepository.selectMenuPermsByUserId(userId);
        HashSet<String> permsSet = new HashSet<>();
        for (String perm : perms) {
            if (StringUtils.isNotEmpty(perm)) {
                permsSet.addAll(Arrays.asList(perm.trim().split(",")));
            }
        }
        return permsSet;
    }
}
