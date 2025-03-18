package com.yedam.api;

class Member {
	String name;
	int age;

	@Override
	public boolean equals(Object obj) {
		// 비교대상 (매개값)이 Member 타입인지 확인.
		if (obj instanceof Member) {
			Member target = (Member) obj;
			return this.name.equals(target.name) && this.age == target.age;
		}
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		//반환되는 값이 int이기 때문에 age로...??
		return age;
	}

	Member() {
	}

	Member(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "이름은 " + name + ", 나이는 " + age;
	}

}

public class ObjectExe1 {
	public static void main(String[] args) {
		Object obj1 = new Object();
		Object obj2 = new Object();

		// 비교
		System.out.println(obj1 == obj2); // 물리적(실제)인 주석값 비교

		// 논리적 비교
		System.out.println(obj1.equals(obj2));

		Member m1 = new Member();
		Member m2 = new Member();

		m1.name = "홍길동";
		m1.age = 20;
		m2.name = "홍길동";
		m2.age = 19;

		System.out.println(m1 == m2);
		System.out.println(m1.equals(m2));
	}
}//