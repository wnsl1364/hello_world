package com.yedam.variable;

import java.util.Scanner;

public class VarExe6 {
	public static void test() {
		//임의의 정수 1 ~ 50 임의의 값.
		//for(int i=1; i<=5; i++) {
			//System.out.println((int) (Math.random() * 50) + 1); // 1 <= x < 51
		//}
		
		//학생의 점수 (30~100사이의 점수)
		//정수 (int) -> 5개 저장.		
		int[] scores = new int[5];
		
		for(int i=0; i<scores.length; i++) {
			scores[i] = ((int) (Math.random() * 71) + 30);
		}
		
		//홀수의 값 출력
		for(int i=0; i<scores.length; i++) {
			if(scores[i] % 2 == 1) {
				System.out.println(scores[i]);
			}
		}
	}//end of test().
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		Member m1 = new Member(); //인스턴스 생성
		m1.setName("홍길동"); // setter.(값을 지정하는 메소드)
//		System.out.println(m1.getScore());
		
		Member m2 = new Member(); //인스턴스 생성
		m2.setName("한주연");
		Member m3 = new Member(); //인스턴스 생성
		m3.setName("한동원");
		Member m4 = new Member(); //인스턴스 생성
		m4.setName("한찬우");
		
		//배열.
		Member[] members = {m1, m2, m3, m4};
		
		//70 ~ 100 사이의 임의의 값으로 점수 지정.
		for(int i=0; i<members.length; i++) {
//			members[i].score = ((int) (Math.random() * 31) + 70);
			members[i].setScore((int) (Math.random() * 31) + 70);
		}
		
		//조회이름을 입력 -> 접수출력.
		System.out.println("조회할 이름 입력 >> ");
		String search = scn.nextLine();
		
		for(int i=0; i<members.length; i++) {
			if(members[i].getName().equals(search)) {
				System.out.println(members[i].getScore());
			}//equals 찾아보셈
		};
		
		// 점수가 가장 높은 사람의 이름.
		int max = members[0].getScore();
		String name = members[0].getName();
		for(int i=0; i<members.length; i++) {
			if(max < members[i].getScore()) {
				max = members[i].getScore();
				name = members[i].getName();
			}
		}

		
		System.out.println("최고점수는 " + max + ", 이름은 " + name);
		scn.close();
	}// end of main().
}
