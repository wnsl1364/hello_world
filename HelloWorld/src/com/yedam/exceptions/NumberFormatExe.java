package com.yedam.exceptions;

import java.util.Scanner;

public class NumberFormatExe {
    public static void main(String[] args) {
        // 예외 처리: try-catch-finally 블록
        try {
            // exceptMethod 호출 (예외를 떠넘기는 메소드)
            exceptMethod();
        } catch (NumberFormatException e) {
            // NumberFormatException이 발생하면 이 코드가 실행됩니다.
            System.out.println("예외 떠넘기기 처리");
        } finally {
            // finally 블록은 예외 발생 여부와 관계없이 항상 실행됩니다.
            // 정상 실행이든 예외 발생이든 상관없이 반드시 실행되는 코드
            System.out.println("정상실행이건 예외발생에 상관없이 반드시 실행할 코드");
        }
        // 프로그램의 마지막 부분
        System.out.println("End of program");
    }

    // 예외 떠넘기기(throws)
    // 이 메소드는 예외를 처리하지 않고, 호출한 곳으로 예외를 떠넘깁니다.
    static void exceptMethod() throws NumberFormatException {
        Scanner scn = new Scanner(System.in);
        System.out.println("정수를 입력하세요>> ");

        String strNo = scn.nextLine(); // 문자리터럴

        int no = 1;
        // 입력받은 문자열을 정수로 변환 (Integer.parseInt는 예외를 발생시킬 수 있음)
        no = Integer.parseInt(strNo); // 만약 사용자가 숫자가 아닌 값을 입력하면 예외 발생
        System.out.println(no); // 변환된 정수를 출력
        scn.close();
    }
}