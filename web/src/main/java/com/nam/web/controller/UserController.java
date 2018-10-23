package com.nam.web.controller;

import com.nam.core.dto.UserDTO;
import com.nam.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/listUser", method = RequestMethod.GET)
    @ResponseBody
    public List<UserDTO> apiShowAllUser() {
        return userService.getAllUser();
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String showAllUser(Model model) {
        model.addAttribute("users", userService.getAllUser());
        return "home";
    }
}
