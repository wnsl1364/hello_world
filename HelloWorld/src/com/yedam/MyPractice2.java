package com.yedam;

import java.util.Scanner;

public class MyPractice2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        while (true) {
            int num = getUserInput(scn); // 사용자 입력 받기
            
            if (num == 0) { // 종료 조건
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            boolean isEven = isEven(num); // 짝수 판별
            printResult(num, isEven); // 결과 출력
        }

        scn.close();
    }

    // 사용자로부터 숫자를 입력받는 메서드
    public static int getUserInput(Scanner scn) {
        System.out.print("숫자를 입력해주세요>> ");
        return scn.nextInt();
    }

    // 짝수인지 판별하는 메서드
    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    // 결과를 출력하는 메서드
    public static void printResult(int num, boolean isEven) {
        if (isEven) {
            System.out.println(num + "은(는) 짝수입니다.");
        } else {
            System.out.println(num + "은(는) 홀수입니다.");
        }
    }
}