package com.mongo.control;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mongo.pojo.User;
import com.mongo.service.UserService;

@Controller
@RequestMapping("/user")
public class UserCtrl {

	private static Logger logger = Logger.getLogger(UserCtrl.class.getName());

	@Autowired
	UserService userService;

	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("/user/index");
		return mav;
	}

	@RequestMapping("/save")
	public ModelAndView saveUser(User user) {

		ModelAndView mav = new ModelAndView("/user/index");

		logger.info("save:" + user);

		userService.saveUser(user);

		return mav;
	}

	@RequestMapping("/find")
	public ModelAndView findUser(User user) {

		ModelAndView mav = new ModelAndView("/user/index");

		user = userService.findUserByName(user.getName());

		logger.info("find:" + user);

		return mav;
	}

}