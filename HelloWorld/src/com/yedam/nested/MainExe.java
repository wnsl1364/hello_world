package com.yedam.nested;

public class MainExe {
    public static void main(String[] args) {
        // Outer 클래스의 인스턴스를 생성하고 method1() 호출
        Outer outer = new Outer();
        outer.method1();

        // Outer 클래스의 내부 클래스(Inner)의 인스턴스를 생성
        Outer.Inner inner = outer.new Inner();
        inner.innerMethod(); // 내부 클래스의 메서드 호출
    }
}