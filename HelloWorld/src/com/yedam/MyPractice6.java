package com.yedam;

public class MyPractice6 {
    public static void main(String[] args) {
        // 현대 자동차 만들기
        Car myCar = new Car("Hyundai");

        myCar.accelerate(); // 속도 10 증가
        myCar.accelerate(); // 속도 10 증가
        myCar.showInfo();   // 현재 속도 출력

        myCar.brake();      // 속도 10 감소
        myCar.showInfo();   // 현재 속도 출력

        myCar.brake();      // 속도 10 감소
        myCar.brake();      // 속도 10 감소 (0 이하로 내려가지 않음)
        myCar.showInfo();   // 현재 속도 출력
    }
}
