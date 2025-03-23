package com.yedam.inheritance;

public class AnimalExe {
	public static void main(String[] args) {
		// 새 객체를 부모 클래스 타입으로 참조 (업캐스팅)
		Animal animal = new Bird();
		animal.sound();  // "짹짹" 출력 (Bird 클래스에서 오버라이딩된 메서드 호출)
		animal.eat();    // "먹는다." 출력 (부모 클래스에서 상속받은 메서드 호출)

		// 물고기 객체를 부모 클래스 타입으로 참조 (업캐스팅)
		animal = new Fish();
		animal.sound();  // "뻐끔뻐끔" 출력 (Fish 클래스에서 오버라이딩된 메서드 호출)
		animal.eat();    // "먹는다." 출력 (부모 클래스에서 상속받은 메서드 호출)
	}
}