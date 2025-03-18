package com.yedam.api;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassExe {
    public static void main(String[] args) {
        try {
            // Class.forName()을 사용하여 클래스 정보를 가져온다.
            // 여기서는 "com.yedam.bookApp.Book" 클래스의 정보를 로드한다.
            // 클래스가 존재하지 않으면 ClassNotFoundException 예외가 발생한다.
            Class cls = Class.forName("com.yedam.bookApp.Book");

            // 클래스의 모든 메서드 정보를 가져온다.
            Method[] methods = cls.getDeclaredMethods();
            System.out.println("클래스의 메서드 목록:");
            // 배열을 순회하면서 메서드의 이름을 출력한다.
            for (int i = 0; i < methods.length; i++) {
                System.out.println(methods[i].getName());
            }

            // 클래스의 모든 필드(멤버 변수) 정보를 가져온다.
            Field[] fary = cls.getDeclaredFields();
            System.out.println("\n클래스의 필드 목록:");
            // 배열을 순회하면서 필드의 이름을 출력한다.
            for (int i = 0; i < fary.length; i++) {
                System.out.println(fary[i].getName());
            }

            // 클래스의 모든 생성자 정보를 가져온다.
            Constructor[] fcon = cls.getDeclaredConstructors();
            System.out.println("\n클래스의 생성자 목록:");
            // 배열을 순회하면서 생성자의 이름을 출력한다.
            for (int i = 0; i < fcon.length; i++) {
                System.out.println(fcon[i].getName());
            }
        } catch (ClassNotFoundException e) {
            // 지정한 클래스가 존재하지 않을 경우 예외 처리
            e.printStackTrace();
        } // ClassNotFoundException 예외 처리
    }
}
