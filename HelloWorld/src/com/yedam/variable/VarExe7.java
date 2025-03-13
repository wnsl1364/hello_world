package com.yedam.variable;

import java.util.Scanner;

// Member 값을 추가, 수정, 삭제, 출력, 평균 계산하는 프로그램

public class VarExe7 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        boolean run = true;
        
        // Member 객체를 저장할 배열 선언 (최대 100명)
        Member[] storage = new Member[100]; 
        // 초기 데이터 입력 (홍길동, 한주연, 주만성)
        storage[0] = new Member("홍길동", 83);
        storage[1] = new Member("한주연", 100);
        storage[2] = new Member("주만성", 32);

        // 프로그램 실행
        while(run) {
            // 메뉴 출력
            System.out.println("1.등록 2.수정 3.삭제 4.출력 5.평균 6.종료");
            System.out.print("선택 >> ");
            int menu = Integer.parseInt(scn.nextLine()); // 사용자 입력 받기
            
            switch(menu) {
                case 1: // 등록
                    System.out.print("이름을 입력해주세요 >> ");
                    String name = scn.nextLine();
                    System.out.print("점수를 입력해주세요 >> ");
                    int score = Integer.parseInt(scn.nextLine());
                    
                    // 새로운 Member 객체 생성 후 설정
                    Member member = new Member();
                    member.setMember(name, score);
                    
                    // 배열에 빈 공간에 새 Member 추가
                    for (int i = 0; i < storage.length; i++) {
                        if (storage[i] == null) {
                            storage[i] = member;
                            break;
                        }
                    }
                    System.out.println("등록되었습니다.");
                    break;
                    
                case 2: // 수정
                    System.out.println("이름을 입력해주세요 >> ");
                    name = scn.nextLine();
                    boolean check = false;
                    
                    // 해당 이름의 Member를 찾은 후 점수와 이름 수정
                    for (int i = 0; i < storage.length; i++) {
                        if (storage[i] != null && storage[i].getName().equals(name)) {
                            System.out.println("현재 이름은 " + storage[i].getName() + " 점수는 " + storage[i].getScore() + "점 입니다.");
                            System.out.println("변경할 이름을 입력하세요.");
                            name = scn.nextLine();
                            System.out.println("변경할 점수를 입력하세요.");
                            int reScore = Integer.parseInt(scn.nextLine());
                            
                            // 이름과 점수 수정
                            storage[i].setMember(name, reScore);
                            System.out.println("성공적으로 수정되었습니다.");
                            check = true;
                            break;
                        }
                    }
                    
                    // 수정할 학생을 찾지 못한 경우
                    if (!check) {
                        System.out.println(name + "이라는 이름의 학생은 존재하지 않습니다.");
                    }
                    break;
                    
                case 3: // 삭제
                    System.out.println("이름을 입력해주세요 >> ");
                    name = scn.nextLine();
                    
                    // 해당 이름의 Member를 찾아 삭제
                    for (int i = 0; i < storage.length; i++) {
                        if (storage[i] != null && storage[i].getName().equals(name)) {
                            storage[i] = null; // 해당 객체를 null로 설정하여 삭제
                            System.out.println("삭제되었습니다.");
                            break;
                        }
                    }
                    break;
                    
                case 4: // 출력
                    System.out.println("== 등록된 학생 목록 ==");
                    // 모든 등록된 학생 출력
                    for (int i = 0; i < storage.length; i++) {
                        if (storage[i] != null) {
                            System.out.println(storage[i].getName() + " " + storage[i].getScore());
                        }
                    }
                    break;
                    
                case 5: // 평균
                    int sum = 0;
                    int count = 0;
                    // 모든 학생의 점수를 합산하고 학생 수를 세기
                    for (int i = 0; i < storage.length; i++) {
                        if (storage[i] != null) {
                            sum += storage[i].getScore();
                            count++;
                        }
                    }
                    if (count > 0) {
                        // 평균 계산 후 출력
                        System.out.println("점수의 총점은 " + sum + "이고 평균은 " + (double)sum / count + "입니다.");
                    } else {
                        System.out.println("등록된 학생이 없습니다.");
                    }
                    break;
                    
                case 6: // 종료
                    run = false; // 프로그램 종료
                    break;
            }
        }
        System.out.println("프로그램이 종료되었습니다.");
        scn.close(); // Scanner 리소스 종료
    }
}