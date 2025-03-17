package com.yedam.api;

class Member {
	String name;
	int age;

	@Override
	public boolean equals(Object obj) {
		//비교대상(매개값) Member타입
		if(obj instanceof Member) {
			Member target = (Member) obj;
			return this.name.equals(target.name);
		}
		return false;
	}
}

public class ObjectExe1 {
	public static void main(String[] args) {
		Object obj1 = new Object();
		Object obj2 = new Object();

		// 비교
		System.out.println(obj1 == obj2); // 물리적인 주소값을 비교

		// 논리적 비교(객체비교)
		System.out.println(obj1.equals(obj2));

		//
		Member m1 = new Member();
		Member m2 = new Member();
		m1.name = "홍길동";
		m1.age = 20;
		m2.name = "홍길동";
		m2.age = 19;
		System.out.println(m1 == m2);
		System.out.println(m1.equals(m2));
	}
}
