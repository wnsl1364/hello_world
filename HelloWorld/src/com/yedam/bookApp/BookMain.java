package com.yedam.bookApp;

import java.util.List;
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
	
	//jdbc처리
	BookJdbc dao = new BookJdbc();

	// 로그인
	private boolean login(String userId, String password) {
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

//	Book[] bookStore = new Book[100]; // 객체 배열을 선언하고 메모리를 할당
	Scanner scn = new Scanner(System.in);
	boolean check = false;

	// 순번 생성 (가장 큰 orderNo + 1 반환)
	// 현재 저장된 책들 중에서 가장 큰 orderNum에 1을 더해 새로운 순번을 반환하게
	public int getSequenceNo() {
		int max = 0; // 현재 가장 큰 orderNum 저장용
		// 향상된 for문(인덱스 사용 x)
		// for(Type element : array){}
//		for (Book book : bookStore) {
//			if (book != null && book.getOrderNo() > max) {
//				max = book.getOrderNo();
//			}
//		}
		return max + 1;
	}

	// 책 등록 (중복 제목 등록 불가)
	public void add() {
		System.out.print("책 제목을 입력하세요>> ");
		String title = scn.nextLine();

//		for (Book book : bookStore) {
//			if (book != null && book.getTitle().equals(title)) {
//				System.out.println("중복된 책 제목이 있습니다.");
//				return;
//			}
//		}

		System.out.print("책 저자를 입력하세요>> ");
		String author = scn.nextLine();
		System.out.print("출판사를 입력하세요>> ");
		String company = scn.nextLine();
		System.out.print("책의 가격을 입력하세요>> ");
		int price = Integer.parseInt(scn.nextLine());

		Book bookRegi = new Book(title, author, company, price, getSequenceNo());
		//배열에 추가 -> ojdbc변경
		if(dao.insert(bookRegi)) {
			System.out.println("정상등록");
		}else {
			System.out.println("등록예외");
		}
		
	}

	// 책 수정 (코드으로 검색하여 가격 수정)
	public void edit() {
		System.out.print("도서코드를 입력해주세요>> ");
		String bcode = scn.nextLine();
		String title = scn.nextLine();
		int price = Integer.parseInt(scn.nextLine());
		String author = scn.nextLine();
		if (bcode.isBlank()) {
			System.out.println("도서코드를 반드시 입력해주세요.");
			return;
		}

		//update(파라미터)
		Book book = new Book();
		book.setBookCode(bcode);
		book.setTitle(title);
		book.setPrice(price);
		book.setAuthor(author);
		
		if (dao.update(book)) {
			System.out.println("수정성공");
		}else {
			System.out.println("수정예외");
		}
	}

	// 책 삭제 (도서코드로 검색하여 삭제)
	public void del() {
		String bcode = scn.nextLine();
		while (true) {
			System.out.print("책 제목을 입력해주세요>> ");
			bcode = scn.nextLine();
			if (!bcode.isBlank())
				break;
			System.out.println("책 제목을 반드시 입력해주세요.");
		}

		if (dao.delete(bcode)) {
			System.out.println("삭제성공");
		}else {
			System.out.println("삭제예외");
		}
	}

	// 책 목록 조회 (순번 기준 정렬)
	public void list() {

		// 목록 출력
		System.out.println("순번 | 제목            | 저자      | 가격");
		System.out.println("========================================");
		List<Book> list = dao.list(null);
		for(Book bk : list) {
			System.out.println(bk.showList());
		}		
	}

	// 책 상세 조회 (제목으로 검색하여 정보 출력)
	public void detail() {
		String bcode = "";
		
		while (true) {
			System.out.print("도서코드를 입력해주세요>> ");
			bcode = scn.nextLine();
			if (!bcode.isBlank())
				break;
			System.out.println("도서코드를 반드시 입력해주세요.");
		}

		Book book = dao.select(bcode); 
		if(book != null) {			
			System.out.println(book.showBookInfo());
		}else {
			System.out.println("조회결과 없습니다");
		}
	}

	// list와 publisher에서 활용할 공통 메소드
//	public Book[] searchList(String keyword) {
//		Book[] list = new Book[100];
//		int idx = 0;
//		for (int i = 0; i < bookStore.length; i++) {
//			if (bookStore[i] != null) {
//				if (keyword == null || bookStore[i].getCompany().equals(keyword)) {
//					list[idx++] = bookStore[i];
//				}
//			}
//		}
//		return list;
//	}

	// 목록 조회(출판사)	
	public void publisher() {
		System.out.print("출판사를 입력해주세요>> ");
		String company = scn.nextLine();

		// 목록 출력
		System.out.println("순번 | 제목            | 저자      | 가격");
		System.out.println("========================================");
		List<Book> list = dao.list(company);
		for(Book bk : list) {
			System.out.println(bk.showList());
		}		
	}

//	// 초기 데이터 설정
//	public void init() {
//		bookStore[0] = new Book("이것이 자바다", "신용권", "한빛출", 20000, 1);
//		bookStore[1] = new Book("스크립트기초", "박기초", "우리출", 26000, 2);
//		bookStore[2] = new Book("HTML,CSS", "김하늘", "가람출", 25000, 3);
//		bookStore[3] = new Book("이것이 자바다2", "신용권", "한빛출", 20000, 4);
//		bookStore[4] = new Book("스크립트기초", "박기초", "우리출", 26000, 5);
//		bookStore[5] = new Book("HTML,CSS", "김하늘", "가람출", 25000, 6);
//		bookStore[6] = new Book("이것이 자바다2", "신용권", "한빛출", 20000, 7);
//	}
	
	private Book searchBook(String bcode) {
		return dao.select(bcode); //조회결과가 없을 경우에는 null을 반환
	}

	// 메인 실행
	public void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		//id. password 확인
		while(true) {			
			System.out.println("로그인 정보를 입력하세요.");
			System.out.print("아이디: ");
			String userId = scn.nextLine();
			System.out.print("비밀번호: ");
			String password = scn.nextLine();
			
			if(login(userId, password)) {
				System.out.println("정상");
				break;
			}
			System.out.println("아이디와 패스워드를 확인하세요.");
		}
		
		
//		init(); // 초기 데이터 설정		

		boolean run = true;
		while (run) {
			System.out.println("\n1.도서등록  2.도서수정  3.도서삭제  4.도서목록  5.상세조회  6.목록조회(출판사) 9.종료");
			System.out.print("선택>> ");
			
			int menu;
			//예외처리
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
		
		scn.close();
	}
}