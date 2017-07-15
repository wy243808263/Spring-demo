package com.mongo.pojo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	String _id;
	String name;
	String Email;
	List<String> like;

	

	public String get_id() {
		return _id;
	}



	public void set_id(String _id) {
		this._id = _id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return Email;
	}



	public void setEmail(String email) {
		Email = email;
	}



	public List<String> getLike() {
		return like;
	}



	public void setLike(List<String> like) {
		this.like = like;
	}



	@Override
	public String toString() {
		return "{USER:{_id:" + this._id + ",name:" + this.name + ",Email:"
				+ this.Email + "}}";
	}

}