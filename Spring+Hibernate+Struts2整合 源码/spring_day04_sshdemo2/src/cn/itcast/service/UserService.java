package cn.itcast.service;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.UserDaoImpl;

@Transactional
public class UserService {

	//注入dao对象
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void add() {
		System.out.println("service........");
		userDao.add();
	}
}
