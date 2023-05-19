package edu.friday.controller;

import edu.friday.common.constant.UserConstants;
import edu.friday.common.result.RestResult;
import edu.friday.common.result.TableDataInfo;
import edu.friday.model.vo.SysUserVO;
import edu.friday.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import edu.friday.common.base.BaseController;
@RestController
@RequestMapping("/system/user")
public class SysUserController  extends BaseController{
    @Autowired
    SysUserService userService;
    @GetMapping("/list")
    public TableDataInfo list(SysUserVO user, Pageable page){
        int pageNum=page.getPageNumber()-1;
        pageNum= Math.max(pageNum, 0);
        page= PageRequest.of(pageNum,page.getPageSize());
        return userService.selectUserList(user,page);
    }
    @PostMapping
    public RestResult add(@RequestBody SysUserVO user){
        if(UserConstants.NOT_UNIQUE.equals(userService.checkUserNameUnique(user.getUserName()))){
            return RestResult.error("新增用户"+user.getUserName()+"失败,登录账号已存在");
        } else if (UserConstants.NOT_UNIQUE.equals(userService.checkPhoneNumberUnique(user))) {
            return RestResult.error("新增用户"+user.getUserName()+"失败,手机号码已存在");
        } else if (UserConstants.NOT_UNIQUE.equals(userService.checkEmailUnique(user))) {
            return RestResult.error("新增用户"+user.getUserName()+"失败,邮箱地址已存在");
        }
        user.setCreateBy("system");
        boolean flag=userService.insertUser(user);

        return toAjax(flag?1:0);
    }
}
