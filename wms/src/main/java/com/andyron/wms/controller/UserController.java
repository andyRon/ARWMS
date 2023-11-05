package com.andyron.wms.controller;


import com.andyron.wms.common.QueryPageParam;
import com.andyron.wms.common.Result;
import com.andyron.wms.entity.Menu;
import com.andyron.wms.entity.User;
import com.andyron.wms.service.MenuService;
import com.andyron.wms.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author andyron
 * @since 2023-10-30
 */
@RestController
@RequestMapping("/user")
public class UserController {

//    @Autowired
//    private UserService userService;

    private UserService userService;
    private MenuService menuService;
    public UserController(UserService userService, MenuService menuService) {
        this.userService = userService;
        this.menuService = menuService;
    }

    @GetMapping("/list")
    public List<User> list() {
        return userService.list();
    }


    @ApiOperation("新增")
    @PostMapping("/save")
    public Result save(@RequestBody User user) {
        return userService.save(user) ? Result.suc() : Result.fail();
    }
    /**
     * 修改
     */
    @PostMapping("/mod")
    public boolean mod(@RequestBody User user) {
        return userService.updateById(user);
    }
    /**
     * 新增或修改
     */
    @PostMapping("/saveOrmod")
    public boolean saveOrmod(@RequestBody User user) {
        return userService.saveOrUpdate(user);
    }

    /**
     * 删除
     */
    @GetMapping("/delete")
    public boolean delete(Integer id) {
        return userService.removeById(id);
    }

    /**
     * 查询（模糊、匹配）
     */
    @PostMapping("/listP")
    public Result listP(@RequestBody User user) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper();
        if (StringUtils.isNotBlank(user.getName())) {
            wrapper.like(User::getName, user.getName());
        }
        return Result.suc(userService.list(wrapper));
    }

    @PostMapping("/listPage2")
    public List<User> listPage2(@RequestBody QueryPageParam query) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(User::getName, (String) query.getParam().get("name"));

        Page<User> page = new Page(query.getPageNum(), query.pageSize);
        Page<User> result = userService.page(page, wrapper);

        return result.getRecords();
    }

    @PostMapping("/listPage")
    public Result listPage(@RequestBody QueryPageParam query) {
        HashMap param = query.getParam();
        String name = (String) query.getParam().get("name");
        String sex = (String) query.getParam().get("sex");

        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        Page<User> page = new Page(query.getPageNum(), query.pageSize);

        if (StringUtils.isNotBlank(name) && !"null".equals(name)) {
            wrapper.like(User::getName, name);
        }

        if (StringUtils.isNotBlank(sex)) {
            wrapper.eq(User::getSex, sex);
        }
        // TODO:  IPage Page 区别
        IPage<User> result = userService.page(page, wrapper);

        return Result.suc(result.getRecords(), result.getTotal());
    }

    @GetMapping("/findByNo")
    public Result findByNo(@RequestParam String no) {
        List<User> list = userService.lambdaQuery().eq(User::getNo, no).list();
        return list.size() > 0 ? Result.suc(list) : Result.fail();
    }

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        List<User> list = userService.lambdaQuery().eq(User::getNo, user.getNo()).
                eq(User::getPassword, user.getPassword()).list();
        if (list.size() > 0) {
            User u = (User) list.get(0);
            List<Menu> menuList = menuService.lambdaQuery().like(Menu::getMenuright, u.getRoleId()).list();
            HashMap res = new HashMap();
            res.put("user", u);
            res.put("menu", menuList);
            return Result.suc(res);
        }
        return Result.fail();
    }
}
