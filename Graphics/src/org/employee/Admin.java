package org.employee;

public class Admin {
	String userName;
	String passWord;
	
	public Admin(String userName,String passWord){
		super();
		this.userName=userName;
		this.passWord=passWord;	
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

}
