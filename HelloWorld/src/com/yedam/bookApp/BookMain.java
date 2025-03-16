package com.yedam.bookApp;

import java.util.Scanner;
//break문
//가장 가까운 하나의 반복문을 벗어나기 위해 사용

//return문
//쓰여진 해당 함수에서의 탈출 / 반복문을 포함하는 메서드 자체를 종료시킴
//메서드의 리턴자료형이 void인 경우에는 return문이 필요없다

//continue 문
//반복문을 완전히 빠져나가지 않고 반복문 내의 작업문을 건너뛸때 사용

// 도서 등록, 수정, 삭제, 목록 관리
public class BookMain {

	private User[] users = new User[3];

	// 싱글톤
	// 1.생성자 private 선언
	// String userId, String userName, String password
	private BookMain() {
		users[0] = new User("user1", "한주연", "1235");
		users[1] = new User("user2", "주만성", "9806");
		users[2] = new User("user3", "고깜디", "1274");
	}

	// 2.정적 필드를 선언, 값 할당
	private static BookMain instance = new BookMain();

	// 3.getInstance() 제공
	public static BookMain getInstance() {
		return instance;
	}

	// 로그인
	public boolean login(String userId, String password) {
		for (User user : users) {
			if (user != null && user.getUserId().equals(userId) && user.getPassword().equals(password)) {
				System.out.println("로그인에 성공했습니다");
				return true;
			}
		}
		System.out.println("로그인에 실패했습니다");
		return false;
	}

	// 저장공간 (최대 100권)
	// 클래스 변수로 사용하기 위해서 static을 붙여줌
	// static이 없으면 인스턴스 변수가 되어서 BookMain 객체를 만들때마다 bookStore배열이 새로 생성됨
	// bookStore는 공통으로 사용하기때문에 static을 붙여서 모든 메서드에서 사용할 수 있게 만들어줌

	Book[] bookStore = new Book[100]; // 객체 배열을 선언하고 메모리를 할당
	Scanner scn = new Scanner(System.in);
	boolean check = false;

	// 순번 생성 (가장 큰 orderNo + 1 반환)
	// 현재 저장된 책들 중에서 가장 큰 orderNum에 1을 더해 새로운 순번을 반환하게
	public int getSequenceNo() {
		int max = 0; // 현재 가장 큰 orderNum 저장용
		// 향상된 for문(인덱스 사용 x)
		// for(Type element : array){}
		for (Book book : bookStore) {
			if (book != null && book.getOrderNo() > max) {
				max = book.getOrderNo();
			}
		}
		return max + 1;
	}

	// 책 등록 (중복 제목 등록 불가)
	public void add() {
		System.out.print("책 제목을 입력하세요>> ");
		String title = scn.nextLine();

		for (Book book : bookStore) {
			if (book != null && book.getTitle().equals(title)) {
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
				System.out.println("도서가 등록되었습니다.");
				break;
			}
		}
	}

	// 책 수정 (제목으로 검색하여 가격 수정)
	public void edit() {
		System.out.print("책 제목을 입력해주세요>> ");
		String title = scn.nextLine();
		if (title.isBlank()) {
			System.out.println("책 제목을 반드시 입력해주세요.");
			return;
		}

		check = false;
		for (Book book : bookStore) {
			if (book != null && book.getTitle().equals(title)) {
				System.out.print("책의 금액을 수정해주세요>> ");
				int rePrice = Integer.parseInt(scn.nextLine());
				book.setPrice(rePrice);

				System.out.println("수정이 완료되었습니다.");
				check = true;
				break;
			}
		}

		if (!check) {
			System.out.println("책이 존재하지 않습니다.");
		}
	}

	// 책 삭제 (제목으로 검색하여 삭제)
	public void del() {
		String title;
		while (true) {
			System.out.print("책 제목을 입력해주세요>> ");
			title = scn.nextLine();
			if (!title.isBlank())
				break;
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

		if (!check) {
			System.out.println("해당 책이 존재하지 않습니다.");
		}
	}

	// 책 목록 조회 (순번 기준 정렬)
	public void list() {
		boolean noList = false;
		for (Book book : bookStore) {
			if (book != null) {
				noList = true;
				break;
			}
		}

		if (!noList) {
			System.out.println("도서가 없습니다.");
			return;
		}

		// 순번 정렬
		Book temp;
		for (int i = 0; i < bookStore.length - 1; i++) {
			for (int j = 0; j < bookStore.length - 1; j++) {
				if (bookStore[j + 1] == null)
					continue;
				if (bookStore[j] == null || bookStore[j].getOrderNo() > bookStore[j + 1].getOrderNo()) {
					temp = bookStore[j];
					bookStore[j] = bookStore[j + 1];
					bookStore[j + 1] = temp;
				}
			}
		}

		// 목록 출력
		System.out.println("순번 | 제목            | 저자      | 가격");
		System.out.println("========================================");
		Book[] list = searchList(null);
		for (Book book : list) {
			if (book != null) {
				System.out.println(book.getOrderNo() + " | " + book.showList());
			}
		}
	}

	// 책 상세 조회 (제목으로 검색하여 정보 출력)
	public void detail() {
		String title;
		while (true) {
			System.out.print("책 제목을 입력해주세요>> ");
			title = scn.nextLine();
			if (!title.isBlank())
				break;
			System.out.println("책 제목을 반드시 입력해주세요.");
		}

		check = false;
		for (Book book : bookStore) {
			if (book != null && book.getTitle().equals(title)) {
				System.out.println(book.showBookInfo());
				check = true;
				break;
			}
		}

		if (!check) {
			System.out.println("조회 결과가 없습니다.");
		}
	}

	// list와 publisher에서 활용할 공통 메소드
	public Book[] searchList(String keyword) {
		Book[] list = new Book[100];
		int idx = 0;
		for (int i = 0; i < bookStore.length; i++) {
			if (bookStore[i] != null) {
				if (keyword == null || bookStore[i].getCompany().equals(keyword)) {
					list[idx++] = bookStore[i];
				}
			}
		}
		return list;
	}

	// 목록 조회(출판사)
	public void publisher() {
		String company;
		while (true) {
			System.out.println("출판사를 입력해주세요>> ");
			company = scn.nextLine();
			if (!company.isBlank()) {
				break;
			}
			System.out.println("출판사를 반드시 입력해주세요.");
		}

		check = false;
		Book[] list = searchList(company);
		for (Book book : list) {
			if (book != null && book.getCompany().equals(company)) {
				System.out.println(book.getOrderNo() + " " + book.showList());
				check = true;
			}
		}

		if (!check) {
			System.out.println("해당 출판사의 책이 없습니다.");
		}
	}

	// 초기 데이터 설정
	public void init() {
		bookStore[0] = new Book("이것이 자바다", "신용권", "한빛출", 20000, 1);
		bookStore[1] = new Book("스크립트기초", "박기초", "우리출", 26000, 2);
		bookStore[2] = new Book("HTML,CSS", "김하늘", "가람출", 25000, 3);
		bookStore[3] = new Book("이것이 자바다2", "신용권", "한빛출", 20000, 4);
		bookStore[4] = new Book("스크립트기초", "박기초", "우리출", 26000, 5);
		bookStore[5] = new Book("HTML,CSS", "김하늘", "가람출", 25000, 6);
		bookStore[6] = new Book("이것이 자바다2", "신용권", "한빛출", 20000, 7);
	}

	// 메인 실행
	public void main(String[] args) {
		init(); // 초기 데이터 설정

		Scanner scn = new Scanner(System.in);
		System.out.println("로그인 정보를 입력하세요.");
		System.out.print("아이디: ");
		String userId = scn.nextLine();
		System.out.print("비밀번호: ");
		String password = scn.nextLine();

		if (login(userId, password)) {
			boolean run = true;
			while (run) {
				System.out.println("\n1.도서등록  2.도서수정  3.도서삭제  4.도서목록  5.상세조회  6.목록조회(출판사) 9.종료");
				System.out.print("선택>> ");
				int menu;
				try {
					menu = Integer.parseInt(scn.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("숫자를 입력해주세요.");
					continue;
				}

				switch (menu) {
				case 1:
					add();
					break;
				case 2:
					edit();
					break;
				case 3:
					del();
					break;
				case 4:
					list();
					break;
				case 5:
					detail();
					break;
				case 6:
					publisher();
					break;
				case 9:
					System.out.println("프로그램이 종료됩니다.");
					run = false;
					break;
				default:
					System.out.println("잘못된 입력입니다. 다시 선택하세요.");
				}
			}
			System.out.println("End of program.");
		}
		scn.close();
	}
}