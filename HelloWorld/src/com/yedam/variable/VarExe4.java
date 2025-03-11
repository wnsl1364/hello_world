package com.yedam.variable;

import java.util.Scanner;

public class VarExe4 {
	public static void main(String[] args) {
		int[] scores = new int[3]; // {0, 0, 0} 배열의 크기가 3
		
		Scanner scn = new Scanner(System.in);
		
		//값입력.
		for(int i=0; i<scores.length; i++) {
			System.out.print("값을 입력해주세요 > ");
			scores[i] = scn.nextInt();
		};
		
		//입력값의 합을 콘솔에 출력
		//"합은 240입니다."
		int sum=0;
		double avg = 0.0;
		
		for (int i=0; i<scores.length; i++) {
			sum = sum + scores[i];
		};
		avg = sum * 1.0 / scores.length;
		// 정수 나눗셈을 방지하고 실수 나눗셈을 수행하기 위해 sum * 1.0을 사용
		// *1.0을 하면 sum이 double로 변환되어 실수 나눗셈이 이루어짐
		
		System.out.println("합은 " + sum + "입니다.");
		System.out.println("평균은 " + avg + "입니다.");
		
		scn.close();
	}
}
