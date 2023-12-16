package com.andyron.wms.controller;


import com.andyron.wms.common.Result;
import com.andyron.wms.entity.Menu;
import com.andyron.wms.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author andyron
 * @since 2023-11-05
 */
@Api(tags = {"菜单管理"})
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @ApiOperation("根据权限获取菜单")
    @GetMapping("/list")
    public Result list(@RequestParam String roleId) {
        List<Menu> list = menuService.lambdaQuery().like(Menu::getMenuRight, roleId).list();
        return Result.suc(list);
    }
}
