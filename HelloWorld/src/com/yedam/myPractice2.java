package com.yedam;

import java.util.Scanner;

public class myPractice2 {
	public static void main(String[] args) {
		/*두 개의 정수를 입력받아 합을 출력하는 프로그램*/
		Scanner scn = new Scanner(System.in);
		
		while(true) {
			System.out.println("숫자를 입력해주세요>> ");
			int num = scn.nextInt();
			
			// 종료 조건 추가
            if (num == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
			
			if(num % 2 == 0) {
				System.out.println("짝수입니다");
			}else {
				System.out.println("홀수입니다");
			}
		}
		scn.close();
	}
}
