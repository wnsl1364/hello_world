package com.yedam;

public class MyPractice3 {
	public static void main(String[] args) {
		/*1부터 100까지의 숫자 중 5개의 난수를 생성하고, 3의 배수인지 판별하는 프로그램*/
		for(int i=0; i<5; i++) {
			int num = (int)(Math.random() * 100) + 1;
			System.out.println("생성된 난수는" + num + "이다");
			
			if(num % 3 == 0) {
				System.out.println("3의 배수입니다.");
			}else {
				System.out.println("3의 배수가 아닙니다.");
			}
		}
	}
}
