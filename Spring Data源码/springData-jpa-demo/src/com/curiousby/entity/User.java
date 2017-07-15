package com.curiousby.entity;
  
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Table(name="T_USER")
@Entity
public class User {
	 
	private int userid;
	private String username;
	private String password;
	private String tel;
	private String sex;
	private String description;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
	public int getUserid() {
		return userid;
	} 
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getTel() {
		return tel;
	}
	public String getSex() {
		return sex;
	}
	public String getDescription() {
		return description;
	} 
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	 
	 
}