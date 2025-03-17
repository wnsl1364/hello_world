package com.yedam.nested;

public class Outer {
    // 중첩 클래스 (Inner 클래스)
    class Inner {
        String name; // 인스턴스 변수

        // Inner 클래스의 메서드
        void innerMethod() {
            System.out.println("Inner 클래스의 메소드 호출");
        }
    }

    // Outer 클래스 내부에서 Inner 클래스 사용 가능
    void method1() {
        Inner inner = new Inner(); // Inner 클래스의 인스턴스 생성
        inner.name = "홍길동"; // Inner 클래스의 필드 값 설정
        System.out.println("내 이름은 " + inner.name);
    }
}