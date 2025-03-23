package com.yedam.nested;

public class Outer {
    // 내부 클래스 (Inner)
    class Inner {
        String name; // 내부 클래스의 인스턴스 변수 (문자열 변수)

        // 내부 클래스의 메서드
        void innerMethod() {
            System.out.println("Inner 클래스의 메소드 호출");
        }
    }

    // 외부 클래스(Outer) 내부에서 내부 클래스(Inner) 사용 가능
    void method1() {
        Inner inner = new Inner(); // 내부 클래스의 인스턴스 생성
        inner.name = "홍길동"; // 내부 클래스의 필드 값 설정
        System.out.println("내 이름은 " + inner.name);
    }
}