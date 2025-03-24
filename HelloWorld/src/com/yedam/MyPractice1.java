package com.yedam;

public class MyPractice1 {
	public static void main(String[] args) {	
		
		for(int i=0; i<=5; i++) {
			int num = (int) (Math.random() * 100) + 1;
			
			if(num % 3 == 0) {
				System.out.println(num + "는 3의 배수입니다.");
			}else {
				System.out.println(num + "는 3의 배수가 아닙니다.");
			}
		}
	}
}
