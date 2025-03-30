package com.xrh.onlineshoppingsystem.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xrh.onlineshoppingsystem.generator.entity.LoginGet;
import com.xrh.onlineshoppingsystem.generator.entity.Users;
import com.xrh.onlineshoppingsystem.generator.entity.signInPost;
import com.xrh.onlineshoppingsystem.generator.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    @Autowired
    UsersService usersService;

    @PostMapping("/login")
    public String login(@RequestBody LoginGet loginGet) {
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account", loginGet.getAccount()).eq("password", loginGet.getPassword());
        Users users = usersService.getOne(queryWrapper);
        if(users != null) {
            return users.getName();
        }
        else
            return "null";
    }

    @PostMapping("/signIn")
    public String signIn(@RequestBody signInPost signIN) {
        Users users = new Users();
        users.setAccount(signIN.getAccount());
        users.setPassword(signIN.getPassword());
        users.setName(signIN.getName());
        try {
            usersService.save(users);
        } catch (Exception e) {
            return "301";
        }
        return "success";
    }

    public Integer getIdByAccount(String account) {
        QueryWrapper<Users> queryWrapper = new QueryWrapper<Users>()
                .eq("account",account);
        return usersService.getOne(queryWrapper).getId();
    }
}
