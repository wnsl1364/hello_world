package com.yedam.inheritance;
//Friend 클래스를 상속받는 클래스
//extends 부모클래스
//Friend 부모 UnivFriend 자식
public class UnivFriend extends Friend{
	//필드
	private String univName;
	private String major;
	
	//기본 생성자
	public UnivFriend() {
//		super(); //자식클래스이기때문에 기본적으로 super();가 적용되어있음
	}
	public UnivFriend(String name, String tel, String univName, String major) {
		super(name, tel); //부모 생성자
		this.univName = univName;
		this.major = major;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + ", 학교는 " + getUnivName() + ", 학과는 " + getMajor();
	}
	//재정의 : 부모의 메소드를 자식이 재정의(overriding)
	@Override
	public String getName() {
		return super.getName();//super는 부모를 가르킴
	}
	
//	@Override
//	public void setname(String name) {
//		//부모 클래스의 final메소드는 overriding이 안됨.
//	}
	
	@Override
	public String getTel() {
		return super.getTel();
	}

	//getter setter
	public String getUnivName() {
		return univName;
	}

	public void setUnivName(String univName) {
		this.univName = univName;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	};
}
