package com.yedam.variable;

import java.util.Scanner;

//추가, 수정, 삭제, 목록 출력.

public class VarExe7 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		//Member 값을 저장
		Member[] storage = new Member[100]; // {null, null, ... null}
		storage[0] = new Member("홍길동", 83);
		storage[1] = new Member("한주연", 100);
		storage[2] = new Member("주만성", 32);
		
		while(run) {
			System.out.println("1.등록 2.수정 3.삭제 4.출력 5.평균 6.종료");
			System.out.print("선택 >> ");
			int menu = Integer.parseInt (scn.nextLine()); //1.엔터
			
			switch(menu) {
			case 1 : //등록
				System.out.print("이름을 입력해주세요 >>");
				String name = scn.nextLine();
				System.out.print("점수를 입력해주세요 >>");
				int score = Integer.parseInt (scn.nextLine());
				Member member = new Member(); //인스턴스 생성
//				member.name = name;
//				member.score = score;
				member.setMember(name, score);
				//빈공간에 값을 할당
				for(int i=0; i<storage.length; i++) {
					if(storage[i] == null) {
						storage[i] = member;
						break; //for 반복문 종료
					}
				}
				break;
			case 2 :
				System.out.println("이름을 입력해주세요 >>");
				name = scn.nextLine();
				boolean check = false;
				for(int i=0; i<storage.length; i++) {
					if(storage[i] != null && storage[i].getName().equals(name)) {
						System.out.println("현재 이름은 " + storage[i].getName() + " 점수는 " + storage[i].getScore() + "점 입니다");
						System.out.println("변경할 이름을 입력하세요.");
						name = scn.nextLine();
						System.out.println("변경하실 점수를 입력하세요.");
						int reScore = Integer.parseInt(scn.nextLine());
						
						storage[i].setMember(name, reScore);

						System.out.println("성공적으로 수정되었습니다.");
						check = true;
						break;
					}
				}
				if (!check) {
					System.out.println(name + "이라는 이름의 학생은 존재하지 않습니다.");
				}
				break;
			case 3 : //삭제. 이름입력 조회 후 => null대입
				System.out.println("이름을 입력해주세요 >>");
				name = scn.nextLine();
				for(int i=0; i<storage.length; i++) {
					if(storage[i] != null && storage[i].getName().equals(name)) {
						storage[i] = null;
						System.out.println("삭제되었습니다.");
						break;
					}
				}
				break;
			case 4 : //출력
				for(int i=0; i<storage.length; i++) {
					if(storage[i] != null) {
						System.out.println(storage[i].getName() + " " + storage[i].getScore());
					}
				}
				break;
			case 5 : //평균
				int sum = 0;
				int count = 0;
				for(int i=0; i<storage.length; i++) {
					if(storage[i] != null) {
						sum += storage[i].getScore();
						count += 1;
					}					
				}
				System.out.println("점수의 총점은 " + sum + "이고 평균은 " + (double)sum/count + "입니다.");
				break;
			case 6 : //종료
				run = false;
			}
		}
		System.out.println("end of prog");
		scn.close();
	} // end of main().
}
