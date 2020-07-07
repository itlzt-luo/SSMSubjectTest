package com.ssmTest.controller;

import com.alibaba.fastjson.JSONArray;
import com.ssmTest.model.Account;
import com.ssmTest.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestBody Map accountMap,
                        HttpSession session,
                        HttpServletResponse response ) {
        Map<Object, Object> map = new HashMap<>();
        String loginName = (String) accountMap.get("loginName");
        String password = (String) accountMap.get("password");
        if ((!loginName.equals("")) || loginName != null) {
            Account account = accountService.selectByPassword(new Account(loginName, password));
            if (account != null) {
                session.setAttribute("account", account);
                Cookie cookie = new Cookie("accountId", account.getId().toString());
                cookie.setMaxAge(60 * 60 * 24 * 30 * 6);
                response.addCookie(cookie);
                map.put("messages", "success");
            } else {
                map.put("messages", "用户名或密码错误");
            }
        } else {
            map.put("messages", "用户名或密码错误");
        }
        return JSONArray.toJSONString(map);
    }
}
