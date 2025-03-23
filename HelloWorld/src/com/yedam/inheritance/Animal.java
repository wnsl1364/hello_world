package com.yedam.inheritance;

// 추상 클래스: 공통 기능을 정의하지만 직접 객체를 만들 수 없음.
// 클래스에서 기본적인 틀을 정의하지만, 완전한 구현은 자식 클래스에서 해야 할 때 사용
public abstract class Animal {

	// 추상 메서드: 선언만 하고, 구현은 하위 클래스에서 정의해야 함.
	// 자식클래스에 규칙을 지정하고싶을때
	abstract void sound();

	// 일반 메서드: 모든 동물이 공통적으로 가지는 동작을 정의함.
	void eat() {
		System.out.println("먹는다.");
	}
}