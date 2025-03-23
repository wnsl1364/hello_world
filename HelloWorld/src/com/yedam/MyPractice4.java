package com.yedam;

import java.util.Scanner;

public class MyPractice4 {
	public static void main(String[] args) {
		/*두 개의 정수를 입력받아 곱한 값을 반환하는 메서드를 구현하시오.*/
		Scanner scn = new Scanner(System.in);
		
		System.out.println("첫번째 숫자를 입력하세요>> ");
		int num1 = Integer.parseInt(scn.nextLine());
		
		System.out.println("두번째 숫자를 입력하세요>> ");
		int num2 = Integer.parseInt(scn.nextLine());
		
		int result = multiply(num1, num2);
		
		System.out.println(num1 + "과 " + num2 + "의 곱은 " + result + "입니다.");
		
		scn.close();
	}
	
	public static int multiply (int a, int b) {
		return a * b;
	}
}
