package com.yedam.variable;

public class VarExe8 {
    public static void main(String[] args) {
    	//정수 연산 시 byte, short 타입은 자동으로 int로 변환됨
    	//큰 자료형에서 작은 자료형으로 변환할 때는 반드시 강제 형 변환(casting) 필요
    	//byte(8비트)의 범위를 초과하면 오버플로우 발생
    	//반복문에서 증가 연산(++)을 하면 byte의 값이 순환됨
    	
    	
    	
        int n1 = 10;    // 정수형 변수 n1 선언 및 초기화 (int 타입)
        byte b1 = 20;   // 정수형 변수 b1 선언 및 초기화 (byte 타입)
        byte b2 = 120;  // 정수형 변수 b2 선언 및 초기화 (byte 타입)

        // byte 타입의 변수와 정수를 더할 경우, 결과는 기본적으로 int 타입이 됨
        // byte result = b1 + 30; // 오류 발생 (b1 + 30은 int 타입이므로 byte에 저장 불가)
        // 해결 방법: (byte)로 강제 형 변환 (casting) 필요
        byte result = (byte) (b1 + 30);
        System.out.println("더한 결과 : " + result); // 출력: 더한 결과 : 50

        // 오버플로우(overflow) 예제
        byte result2 = (byte) (b2 + 130);
        System.out.println("더한 결과 : " + result2); 
        // 예상 결과: -106 (byte 범위를 넘어가므로 오버플로우 발생)
        
        // b2 + 130의 실제 계산 과정:
        // 120 + 130 = 250
        // byte의 범위: -128 ~ 127
        // 250에서 127을 넘어서는 부분을 계산 (250 - 256 = -6)
        // 따라서 result2 값은 -6이 아닌 -106 (음수로 변환됨)

        // byte → int 자동 형 변환 (promotion)
        n1 = b2;  // byte 타입 변수 b2의 값을 int 타입 변수 n1에 저장 (자동 형 변환)
        System.out.println(b1); // 출력: 20

        // int → byte 강제 형 변환 (casting)
        n1 = 200; // int 범위 내에서 저장
        b2 = (byte) n1; // int → byte로 변환 (오버플로우 발생 가능)

        // byte 오버플로우 확인을 위한 반복문
        for(int i = 1; i < 15; i++) {
            System.out.println(b2++); 
            // b2가 계속 증가하면서 byte 범위를 넘어가면 다시 -128부터 시작됨
        }
    }
}