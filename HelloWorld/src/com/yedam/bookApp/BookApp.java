package com.yedam.bookApp;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BookApp {
    public static void main(String[] args) {
    	
//    	MemberJdbc dao = new MemberJdbc();
//    	List<Map <String, String>> list = dao.memberList();
//    	Gson gson = new GsonBuilder().setPrettyPrinting().create();
//    	String json = gson.toJson(list);
//    	System.out.println(list);
    	
    	
        // BookMain 객체 생성
        BookMain mainApp = BookMain.getInstance();  // 싱글톤으로 호출
        mainApp.main(args);
    	
//    	Book book = new Book();
//    	book.setTitle("자바스크립트 기초");
//    	book.setAuthor("신용권");
//    	book.setCompany("한빛출판사");
//    	book.setPrice(20000);
    	
//    	BookJdbc dao = new BookJdbc();
//    	if(dao.insert(book)){
//    		System.out.println("등록성공");
//    	} else{
//    		System.out.println("등록실패");
//    	};
    	
    
//    	Book book = new Book();
//    	book.setTitle("자바");
//    	book.setAuthor("한주연");
//    	book.setCompany("예담");
//    	book.setPrice(200);
//    	book.setBookCode("12");
//    	
//    	if(dao.update(book)) {
//    		System.out.println("수정성공");
//    	}else{
//    		System.out.println("수정실패");
//    	}
//    	
//    	//목록
//    	List<Book> list = dao.list("한빛출판사");
//    	for(Book bk : list) {
//    		System.out.println(bk.showList());
//    	}
    }
}