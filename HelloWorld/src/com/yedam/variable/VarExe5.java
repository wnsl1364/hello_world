package com.yedam.variable;

import java.util.Scanner;

//예금, 출금, 잔고 확인기능.
public class VarExe5 {
	public static void main(String[] args) {
		boolean run = true; //프로그램 실행여부를 결정하는 변수
		int balance = 0; //사용자의 계좌 잔고을 저장하는 변수.
		// 한번에 입금 10만원 최대, 잔액이 0보다는 크도록
		Scanner scn = new Scanner(System.in); //ctrl + shift + o 누르면 import 해줌 
		while(run) {//run이 true인 동안 계속 실행
			System.out.println("1.예금 2.출금 3.잔고 4.종료");
			int menu = scn.nextInt();//nextInt() 정수 입력을 받음, nextLine()한 줄 전체를 입력받음
			int money = 0;
			switch(menu) {
			 case 1://예금
				 System.out.print("예금액을 입력 >>");
				 money = scn.nextInt();
				 if(money > 100000) {
					 System.out.print("10만원 이상 입금 할 수 없습니다.");
				 }else {
					 balance = balance + money; //값 누적
				 };		 
				 break; // case1 종료.
			 case 2://출금
				 System.out.print("출금액을 입력 >>");
				 money = scn.nextInt();
				 if(money > balance) {
					 System.out.print("잔고보다 출금액이 많습니다.");
				 }else{
					 balance = balance - money;
				 };				 
				 break;
			 case 3://잔고조회
				 System.out.print("잔고는" + balance + "입니다.");
				 break;
			 case 4://종료
				 run = false;
			}
		}
		System.out.println("end of prog.");
		
		scn.close();
	} //end of main().
}
