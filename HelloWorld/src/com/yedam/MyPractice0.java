package com.yedam;

import java.util.Scanner;

public class MyPractice0 {
	public static void main(String[] args) {
		/*사용자로부터 나이를 입력받아 성인(20세 이상)인지 판별하는 프로그램을 작성하시오.*/
		Scanner scn = new Scanner(System.in);
		
		int age = Integer.parseInt(scn.nextLine());
		if(age > 20) {
			System.out.println("성인입니다.");
		}else {
			System.out.println("성인이 아닙니다.");
		}
		scn.close();
	}
}
