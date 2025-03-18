package com.yedam.api;

import java.util.ArrayList;
import java.util.List;

public class WrapperExe {
    public static void main(String[] args) {
        // int 배열 생성. 기본 데이터 타입인 int를 사용
        int[] intAry = {10, 20};        
        
        // Integer 타입을 사용한 List 생성 (Wrapper 클래스인 Integer 사용)
        List<Integer> list = new ArrayList<Integer>();
        
        // int 값 10을 list에 추가
        // 기본 타입 int -> Wrapper 클래스인 Integer로 '박싱' (boxing)
        list.add(10); // int -> Integer 박싱
        // list에서 Integer 값을 꺼낼 때 자동으로 int로 '언박싱' (unboxing)되어 처리됨
        
        
        // 기본 타입 int 변수 선언
        int num1 = 10; 
        
        // Integer 객체 생성 (기본 타입 int를 감싸는 Wrapper 클래스)
        Integer num2 = new Integer(20); // Integer 객체 생성 (기존에는 deprecated되었지만 여전히 사용 가능)

        // num1 == num2.intValue()의 비교
        // num2는 Integer 객체이므로 .intValue() 메서드를 통해 내부 값을 꺼내서 비교
        // num1은 기본 타입 int이고, num2.intValue()는 num2 객체 내부의 값을 꺼내는 메서드입니다.
        // == 연산자는 기본형(int, char 등)끼리 비교할 때 값을 비교합니다.
        // num1 == num2.intValue()는 10 == 20이므로 결과는 false입니다.
        System.out.println(num1 == num2.intValue()); // false 출력
    }
}