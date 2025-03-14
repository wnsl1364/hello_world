package com.yedam.bookApp;
/*실행클래스(main 메소드)*/
public class BookApp {
	public static void main(String[] args) {
		BookMain mainApp1 = BookMain.getInstance();
//		mainApp.main(args);
		BookMain mainApp2 = BookMain.getInstance();
		
		mainApp1.add();//1번에 등록
		mainApp1.list();
		
		mainApp2.list();//2번 목록
		//서로 다른 객체를 바라보기때문에 다른 값을 가짐
		
	}
}
