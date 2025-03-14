package com.yedam.inheritance;
//친구 1 : 이름, 연락처
//상속 시킬고임
//Friend 부모 UnivFriend, CompanyFriend 자식
public class Friend extends Object{
	//필드 선언
	private String name;
	private String tel;
	
	//생성자
	public Friend() {}
	public Friend(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}

	//tos 치고 ctrl + space눌러보셈
	@Override
	public String toString() {
		// TODO Auto-generated method stub
//		return super.toString();
		return "이름은 " + getName() + ", 연락처는 " + getTel();
	}
	
	//getter,setter
	public String getName() {
		return name;
	}

	public /*final*/ void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
}
