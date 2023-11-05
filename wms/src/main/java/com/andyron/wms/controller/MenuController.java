package com.andyron.wms.controller;


import com.andyron.wms.common.Result;
import com.andyron.wms.entity.Menu;
import com.andyron.wms.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author andyron
 * @since 2023-11-05
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/list")
    public Result list(@RequestParam String roleId) {
        List<Menu> list = menuService.lambdaQuery().like(Menu::getMenuright, roleId).list();
        return Result.suc(list);
    }
}
