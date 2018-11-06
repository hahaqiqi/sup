package com.haha.user.controller;

import com.haha.user.entity.User;
import com.haha.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login.html",method = RequestMethod.GET)
	public String tologin(HttpServletRequest request){
		request.setAttribute("error","");
		return "/login.html";
	}

	@RequestMapping(value = "/login.html",method = RequestMethod.POST)
	public String login(@RequestParam(value = "userCode",required = true) String userCode
			,@RequestParam(value = "userPassword",required = true) String userPassword
			,HttpServletRequest request
			,HttpSession session){
		User user= userService.login(userCode,userPassword);
		if(user==null){
			request.setAttribute("error","用户名或密码错误");
			return "/login.html";
		}
		session.setAttribute("usersession",user);
		return "/farme.html";
	}
}
