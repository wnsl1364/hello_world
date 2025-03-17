package com.yedam.bookApp;

public class BookApp {
    public static void main(String[] args) {
        // BookMain 객체 생성
        BookMain mainApp = BookMain.getInstance();  // 싱글톤으로 호출
        mainApp.main(args);
    }
}