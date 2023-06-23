package edu.friday.service;


import java.util.HashSet;

public interface SysMenuService {
    HashSet<String> selectMenuPermsByUserId(Long userId);
}
