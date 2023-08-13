package com.spring.webApp.response;

import java.util.List;


public class UserResponse {
	private String name;
	private String desc;
	private String exp;
	private String profile;
	private List<String> techs;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public List<String> getTechs() {
		return techs;
	}
	public void setTechs(List<String> techs) {
		this.techs = techs;
	}
	
	
}
