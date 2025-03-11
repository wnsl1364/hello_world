package com.yedam.variable;

import java.util.Scanner;

// 사용자의 입력값을 읽어들이는 방식.
// Scanner 클래스(자바에서 제공해주는 라이브러리).
public class VarExe3 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in); //System.in(기본 입력 장치)
		
		System.out.print("이름을 입력하세요>"); //println과 차이점 찾아보셈
		String name = scn.nextLine(); //메소드(함수)
		
		System.out.print("점수를 입력하세요>");
		int score = scn.nextInt();
		
		System.out.print("키를 입력하세요>");
		double height = scn.nextDouble();
		
		System.out.println("입력한 값: " + name + ", 점수: " + score + ", 키: " + height);
		
		scn.close();
	}
}
