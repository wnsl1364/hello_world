package com.yedam.exceptions;

public class NullPointerExe {
    public static void main(String[] args) {
        String str = "Hello";
        int[] intAry = { 10, 20 };

        // 예외 처리 (try ~ catch 문 사용)
        try {
            System.out.println(str.toString());            
            // str이 null이면 NullPointerException 발생
            intAry[2] = 30; // 배열의 크기는 2이므로 ArrayIndexOutOfBoundsException 발생
        } catch (NullPointerException e) {
            System.out.println("Null값을 참조합니다.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("배열의 값을 확인하세요.");
        }
        
        // 예외 발생 여부와 관계없이 "End of program"을 출력
        System.out.println("End of program");
    }
}