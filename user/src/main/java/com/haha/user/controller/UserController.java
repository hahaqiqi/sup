package com.haha.user.controller;

import com.haha.user.emums.ResultEnum;
import com.haha.user.entity.Result;
import com.haha.user.entity.User;
import com.haha.user.exception.UserException;
import com.haha.user.service.UserService;
import com.haha.user.util.ResultUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
//@RestController(value = "/user")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login.html",method = RequestMethod.GET)
	public String tologin(HttpServletRequest request){
		request.setAttribute("error","");
		System.out.print("tologin");
		return "login";
	}

	@RequestMapping(value = "/login.html",method = RequestMethod.POST)
	public String login(@RequestParam(value = "userCode",required = true) String userCode
			, @RequestParam(value = "userPassword",required = true) String userPassword
			, HttpServletRequest request
			, HttpSession session){
		Subject subject=SecurityUtils.getSubject();
		UsernamePasswordToken token =new UsernamePasswordToken(userCode,userPassword);
		token.setRememberMe(true);
		try{
			subject.login(token);
		}catch (UserException ue){
			//return ResultUtil.error(ue.getCode(),ue.getMessage());
			request.setAttribute("error",ue.getMessage());
			return "login";
		}catch (Exception ex){
			//return ResultUtil.error(-1,"未知错误");
			request.setAttribute("error","未知错误-1");
			return "login";
		}
		session.setAttribute("usersession",userService.login(userCode,userPassword));
		//return ResultUtil.success(userService.login(userCode,userPassword));
		return "redirect:/user/farme.html";
	}

	@RequestMapping(value = "/farme.html",method = RequestMethod.GET)
	public String toFrame(){
		return "farme";
	}

	@RequestMapping(value = "/getlistuser",method = RequestMethod.GET)
	@ResponseBody
	public List<User> getlistUser(){
		List<User> listUser= userService.getUserList("",0,1,10);
		return listUser;
	}
}
