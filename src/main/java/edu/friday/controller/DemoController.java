package edu.friday.controller;

import edu.friday.common.base.BaseController;
import edu.friday.common.result.RestResult;
import edu.friday.common.result.TableDataInfo;
import edu.friday.model.SysUser;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/demo")
public class DemoController extends BaseController {
    @PostMapping
    public RestResult add(){
        boolean flag=true;
        return toAjax(flag?1:0);
    }
    @PutMapping
    public RestResult edit(){
        boolean flag=true;
        return toAjax(flag?1:0);
    }
    @DeleteMapping
    public RestResult remove(){
        boolean flag=true;
        return toAjax(flag?1:0);
    }
    @GetMapping(value = {"/","/{userId}"})
    public RestResult getInfo(@PathVariable(value="userId",required = false) Long userId){
        RestResult ajax=RestResult.success();
        ajax.put("user",new SysUser());
        return ajax;
    }
    @GetMapping("/list")
    public TableDataInfo list(){
        return TableDataInfo.success(new ArrayList<>(),100);
    }
}
