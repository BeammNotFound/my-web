package com.controller;


import com.common.api.Action;
import com.common.api.CommonResult;
import com.service.MyWebService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author BeamStark
 * @since 2021-11-30
 */
@Slf4j
@Api(tags = "接口")
@RestController
@RequestMapping("/my-web/")
public class MyWebController {

    @Autowired
    private MyWebService myWebService;

    @ApiOperation("获取喜欢量和浏览量")
    @Action(description = "获取喜欢量和浏览量")
    @GetMapping("get")
    public CommonResult getData(){
        return CommonResult.success(myWebService.getData());
    }

    @ApiOperation("更新喜欢量")
    @Action(description = "更新喜欢量")
    @GetMapping("plusOneLike")
    public CommonResult plusOneLike() {
        return CommonResult.success(myWebService.plusOneLike());
    }

    @ApiOperation("更新浏览量")
    @Action(description = "更新浏览量")
    @GetMapping("plusOnePV")
    public CommonResult plusOnePV() {
        return CommonResult.success(myWebService.plusOnePV());
    }
}

