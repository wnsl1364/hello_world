package com.yedam.inheritance;

//Friend 부모 CompanyFriend 자식
public class CompanyFriend extends Friend{
	//필드
	private String company;
	private String dept;
	
	//기본 생성자
	public CompanyFriend() {}
	public CompanyFriend(String name, String tel, String company, String dept) {
		super(name, tel);
		this.company = company;
		this.dept = dept;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
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
