package com.yedam.inheritance;
//Friend 클래스를 상속받는 클래스
//extends 부모클래스
//Friend 부모 UnivFriend 자식
public class UnivFriend extends Friend{
	// 필드: 학교 이름과 학과
	private String univName;
	private String major;
	
	//기본 생성자
	public UnivFriend() {
//		super(); //자식클래스이기때문에 기본적으로 super();가 적용되어있음
	}
	
	public UnivFriend(String name, String tel, String univName, String major) {
		super(name, tel); // 부모 클래스의 생성자 호출
		this.univName = univName;
		this.major = major;
	}
	
	// toString() 메서드 오버라이딩: UnivFriend의 정보를 출력
	@Override
	public String toString() {
		return super.toString() + ", 학교는 " + getUnivName() + ", 학과는 " + getMajor();
	}

	@Override
	public String getName() {
		return super.getName();//super는 부모를 가르킴
	}
	
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
