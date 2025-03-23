package com.yedam.nested;

public class MainExe {
	public static void main(String[] args) {
		//인스턴스 내부 클래스는 외부 클래스의 인스턴스를 통해 접근.
		//정적 내부 클래스는 외부 클래스의 인스턴스 없이도 접근 가능!
		
		// Outer 클래스의 인스턴스를 생성 (외부 클래스 객체 생성)
		Outer outer = new Outer();

		// Outer 클래스의 메서드 method1() 호출
		outer.method1(); // 외부 클래스의 메서드를 실행

		// 내부 클래스의 객체 생성
		Outer.Inner inner = outer.new Inner();

		// 내부 클래스의 메서드 호출
		inner.innerMethod();
	}
}