package com.yedam.inheritance;

//Friend 부모 CompanyFriend 자식
public class CompanyFriend extends Friend{
	// 필드: 회사 이름과 부서
	private String company;
	private String dept;
	
	//기본 생성자
	public CompanyFriend() {}
	
	// 매개변수가 있는 생성자
	public CompanyFriend(String name, String tel, String company, String dept) {
		super(name, tel);
		this.company = company;
		this.dept = dept;
	}

	// toString() 메서드 오버라이딩: CompanyFriend의 정보를 출력
	@Override
	public String toString() {
		return super.toString() + ", 회사는 " + company + ", 부서는 " + dept;
	}
	
	//getter setter
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	};	
}
