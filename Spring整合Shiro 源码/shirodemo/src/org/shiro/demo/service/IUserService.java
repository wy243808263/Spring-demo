package org.shiro.demo.service;

import org.shiro.demo.entity.User;

public interface IUserService extends IBaseService{
	
	public User getByAccount(String account);

	public boolean register(User user);
}
