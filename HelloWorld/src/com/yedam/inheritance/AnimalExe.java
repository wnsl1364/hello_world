package com.yedam.inheritance;

public class AnimalExe {
	public static void main(String[] args) {
		// 부모 타입(Animal)으로 자식 객체(Bird)를 참조 (업캐스팅)
		Animal animal = new Bird();

		// 오버라이딩된 메서드가 실행됨 (다형성)
		animal.sound(); // "짹짹" 출력

		// 부모 클래스의 일반 메서드 실행
		animal.eat(); // "먹는다." 출력
	}
}