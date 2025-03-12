package com.yedam.bookApp;

import java.util.Scanner;

//등록, 수정, 삭제, 목록
public class BookMain {

	// 저장공간
	static Book[] bookStore = new Book[100];// scn 쓰기위해서 static 붙여줌
	static Scanner scn = new Scanner(System.in);// scn 쓰기위해서 static 붙여줌
	static boolean check = false;

	// 순번 생성.
	public static int getSequenceNo() {
		int max = 0;
		for(int i=0; i<bookStore.length; i++) {
			if(bookStore[i] != null && bookStore[i].getOrderNo() > max) {
				max = bookStore[i].getOrderNo();
			}
		}
		return max + 1; //현재 마지막 번호 + 1
	}

	// 등록
	//1. 이미 존재하는 제목은 입력불가
	public static void add() {
		System.out.print("책 제목을 입력하세요>> ");
		String title = scn.nextLine();
		for(int i=0; i<bookStore.length; i++) {
			if(bookStore[i] != null && bookStore[i].getTitle().equals(title)) {
				System.out.println("중복된 책 제목이 있습니다.");
				return;
			}
		}
		System.out.print("책 저자를 입력하세요>> ");
		String author = scn.nextLine();
		System.out.print("출판사를 입력하세요>> ");
		String company = scn.nextLine();
		System.out.print("책의 가격을 입력하세요>> ");
		int price = Integer.parseInt(scn.nextLine());

		Book bookRegi = new Book(title, author, company, price, getSequenceNo());
		for (int i = 0; i < bookStore.length; i++) {
			if (bookStore[i] == null) {
				bookStore[i] = bookRegi;
				break;
			}
		}
	}// end of add().

	// 수정
	public static void edit() {
		System.out.println("책 제목을 입력해주세요>> ");
		String title = scn.nextLine();
		if (title.isBlank()) {
			System.out.println("책 제목을 반드시 입력해주세요.");
			return;
		}
		check = false;
		for (int i = 0; i < bookStore.length; i++) {
			if (bookStore[i] != null && bookStore[i].getTitle().equals(title)) {
				System.out.println("책의 금액을 수정해주세요.");
				int rePrice = Integer.parseInt(scn.nextLine());
				bookStore[i].setPrice(rePrice);

				System.out.println("수정이 완료되었습니다.");
				check = true;
				break;
			}
		}
		if (!check) {
			System.out.println(title + "이라는 책이 존재하지 않습니다.");
		}
	}// end of edit().

	// 삭제
	public static void del() {
		String title = "";

		// 반드시 값을 입력받도록
		while (true) {
			System.out.println("책 제목을 입력해주세요>> ");
			title = scn.nextLine();
			if (!title.isBlank()) {
				break;
			}
			System.out.println("책 제목을 반드시 입력해주세요.");
		}

		check = false;
		for (int i = 0; i < bookStore.length; i++) {
			if (bookStore[i] != null && bookStore[i].getTitle().equals(title)) {
				bookStore[i] = null;
				System.out.println("삭제가 완료되었습니다.");
				check = true;
				break;
			}
		}
	}// end of del().

	// 목록
	public static void list() {
		boolean noList = false;
		for (int i = 0; i < bookStore.length; i++) {
			if (bookStore[i] != null) {
				noList = true;
			}
		}
		if (!noList) {
			System.out.println("도서가 없습니다.");
			return;
		}
		
		//순번 정렬
		//순번 1> 순번 2, 제외 : 순번2(null), 순번1(null)
		Book temp = null;
		for(int i=0; i<bookStore.length-1; i++) {
			for(int j=0; j<bookStore.length-1; j++) {
				if(bookStore[j+1] == null) {
					continue;
				}
				if(bookStore[j] == null || bookStore[j].getOrderNo() > bookStore[j+1].getOrderNo() ) {
					temp = bookStore[j];
					bookStore[j] = bookStore[j+1];
					bookStore[j+1] = temp;
				}
			}
		}
		int seqNo = 1;
		System.out.println("순번 제목          저자     가격");
		System.out.println("============================");
		for (Book boook : bookStore) {
			if (boook != null) {
				System.out.println(seqNo++ + " " +boook.showList());
			}
		}
	}// end of list().
	
	public static void detail() {
		String title = "";
		while(true) {
			System.out.println("책 제목을 입력해주세요>> ");
			title = scn.nextLine();
			if(!title.isBlank()) {
				break;
			}
			System.out.println("책 제목을 반드시 입력해주세요.");
		}
		
		check = false;
		for(int i=0; i<bookStore.length; i++) {
			if(bookStore[i] != null && bookStore[i].getTitle().equals(title)) {
				System.out.println(bookStore[i].showBookInfo());
				check = true;
				break;
			}else {
				check = false;
			}
		}
		
		if(!check) {
			System.out.println("조회결과가 없습니다.");
			return;
		}
	} //end of detail

	public static void main(String[] args) {
		init();
		// static : 객체(인스턴스) 생성 없이 사용할 수 있다. / 메모리에 고정적으로 할당

		boolean run = true;

		while (run) {
			System.out.println("1.도서등록 2.도서수정 3.도서삭제 4.도서목록 5.상세조회 9.종료");
			System.out.println("선택>> ");
			int menu = Integer.parseInt(scn.nextLine()); // 사용자로부터 입력을 받아 정수로 변환하는 코드
			// Integer.parseInt : 문자열을 정수로 변환하는 메서드
			switch (menu) {
			case 1: // 등록
				add();
				break;
			case 2: // 수정 책제목으로 검색, 금액을 수정
				edit();
				break;
			case 3: // 삭제 책제목으로 검색 후 삭제
				del();
				break;
			case 4: // 목록
				list();
				break;
			case 5 :
				detail();
				break;
			case 9: // 종료
				System.out.println("프로그램이 종료됩니다.");
				run = false;
				break;
			default:
				System.out.println("메뉴를 다시 선택하세요.");
			}
		}
		;
		System.out.println("End of program.");
	}// end of main

	public static void init() {
		bookStore[0] = new Book("이것이 자바다", "신용권", "한빛출", 20000, 1);
		bookStore[1] = new Book("스크립트기초", "박기초", "우리출", 26000, 2);
		bookStore[2] = new Book("HTML,CSS", "김하늘", "가람출", 25000, 3);
	}
}
