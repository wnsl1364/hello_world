package com.yedam.bookApp;

import java.util.Scanner;

public class BookApp {
    public static void main(String[] args) {
        // BookMain 객체 생성
        BookMain mainApp = BookMain.getInstance();  // 싱글톤으로 호출
        Scanner scn = new Scanner(System.in);

        System.out.println("로그인 정보를 입력하세요.");
        System.out.print("아이디: ");
        String userId = scn.nextLine();
        System.out.print("비밀번호: ");
        String password = scn.nextLine();

        // 로그인 검증
        if (mainApp.login(userId, password)) {
            // 로그인 성공 시 도서 관리 시스템 실행
            boolean run = true;
            while (run) {
                System.out.println("\n1.도서등록  2.도서수정  3.도서삭제  4.도서목록  5.상세조회  6.목록조회(출판사) 9.종료");
                System.out.print("선택>> ");
                int menu;
                try {
                    menu = Integer.parseInt(scn.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("숫자를 입력해주세요.");
                    continue;
                }

                switch (menu) {
                    case 1:
                        mainApp.add();
                        break;
                    case 2:
                        mainApp.edit();
                        break;
                    case 3:
                        mainApp.del();
                        break;
                    case 4:
                        mainApp.list();
                        break;
                    case 5:
                        mainApp.detail();
                        break;
                    case 6:
                        mainApp.publisher();
                        break;
                    case 9:
                        System.out.println("프로그램이 종료됩니다.");
                        run = false;
                        break;
                    default:
                        System.out.println("잘못된 입력입니다. 다시 선택하세요.");
                }
            }
            System.out.println("End of program.");
        }
        scn.close();
    }
}