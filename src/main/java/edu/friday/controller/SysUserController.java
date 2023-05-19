package edu.friday.controller;

import edu.friday.common.result.TableDataInfo;
import edu.friday.model.vo.SysUserVO;
import edu.friday.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system/user")
public class SysUserController {
    @Autowired
    SysUserService userService;
    @GetMapping("/list")
    public TableDataInfo list(SysUserVO user, Pageable page){
        int pageNum=page.getPageNumber()-1;
        pageNum= Math.max(pageNum, 0);
        page= PageRequest.of(pageNum,page.getPageSize());
        return userService.selectUserList(user,page);
    }
}
