package com.haha.user.controller;

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

	@RequestMapping(value = "/login.html",method = RequestMethod.GET)
	public String tologin(HttpServletRequest request){
		request.setAttribute("error","");
		return "/login.html";
	}

	@RequestMapping(value = "/login.html",method = RequestMethod.POST)
	public String login(){

		return "/login.html";
	}
}
