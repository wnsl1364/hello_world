package com.yedam.inheritance;

// 부모클래스(Animal)가 가진 추상메소드(sound)를 반드시 재정의(구현)해줘야함
public class Bird extends Animal {
	// 부모 클래스의 추상 메서드를 오버라이딩(재정의)
	@Override
	void sound() {
		System.out.println("짹짹");  // 새는 "짹짹" 소리를 냅니다.
	}
}