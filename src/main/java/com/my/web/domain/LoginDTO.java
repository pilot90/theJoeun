package com.my.web.domain;

public class LoginDTO {
	private String mbrId;
	private String mbrPw;
	//private boolean rememberMe;
	
	public String getMbrId() {
		return mbrId;
	}
	public void setMbrId(String mbrId) {
		this.mbrId = mbrId;
	}
	public String getMbrPw() {
		return mbrPw;
	}
	public void setMbrPw(String mbrPw) {
		this.mbrPw = mbrPw;
	}
	
	@Override
	public String toString() {
		return "LoginDTO [mbrId=" + mbrId + ", mbrPw=" + mbrPw + "]";
	}
	
	
}
