package com.yedam.inheritance;

public class Fish extends Animal {
	
	@Override
	void sound() {
		System.out.println("뻐끔뻐끔");  // 물고기는 "뻐끔뻐끔" 소리를 냅니다.
	}
}