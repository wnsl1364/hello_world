package com.yedam.exceptions;

public class NullPointerExe {
    public static void main(String[] args) {
        String str = "Hello";
        int[] intAry = { 10, 20 };

        // 예외 처리 (try ~ catch 문 사용)
        try {
            System.out.println(str.toString()); // str 객체의 toString() 메서드를 호출하여 출력 (null일 경우 예외 발생)
            intAry[2] = 30; // 배열의 2번 인덱스를 참조하려 하지만 범위를 초과하여 예외 발생
        } catch (NullPointerException e) {
            // NullPointerException이 발생하면 이 블록이 실행됨
            System.out.println("Null값을 참조합니다.");
        } catch (ArrayIndexOutOfBoundsException e) {
            // ArrayIndexOutOfBoundsException이 발생하면 이 블록이 실행됨
            System.out.println("배열의 값을 확인하세요.");
        }
        
        // 예외 발생 여부와 관계없이 "End of program"을 출력
        System.out.println("End of program");
    }
}