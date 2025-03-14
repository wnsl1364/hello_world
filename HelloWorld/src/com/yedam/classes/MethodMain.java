package com.yedam.classes;

import java.util.Scanner;

public class MethodMain {
	public static void main(String[] args) {
		officeApp();

	}

	static void officeApp() {
		// 목록, 추가, 수정, 삭제
		MethodExe2 m2 = new MethodExe2();// 기능 정의

		// 사용자 입력 받아서 1.목록 2.추가 3.수정 4.삭제 9.종료 구현
		// 입력메세지 구현
		Scanner scn = new Scanner(System.in);
		boolean run = true;	
		
		while (run) {
			System.out.println("1.목록 2.추가 3.수정 4.삭제 9.종료");
			int menu = Integer.parseInt(scn.nextLine());
			switch (menu) {
			case 1://목록
				Product prod = new Product();
				prod.setProductName("ALL");
				Product[] store = m2.productList(prod);
				for(int i=0; i<store.length; i++) {
					if(store[i] != null) {
						System.out.println(store[i].showList());
					}
					
				}				
				break;
			case 2://추가
				System.out.println("상품의 코드를 입력해주세요.");
				String code = scn.nextLine();
				System.out.println("상품명을 입력해주세요.");
				String name = scn.nextLine();
				System.out.println("상품의 가격을 입력해주세요.");
				int price = Integer.parseInt(scn.nextLine());
				
				prod = new Product();
				prod.setProductCode(code);
				prod.setProductName(name);
				prod.setPrice(price);
				
				if(m2.add(prod)) {
					System.out.println("상품이 추가가 되었습니다.");
				}else{
					System.out.println("상품이 추가가 되지않았습니다.");
				};		
								
				break;
			case 3://수정
				System.out.println("상품의 코드를 입력해주세요.");
				code = scn.nextLine();
				System.out.println("상품명을 입력해주세요.");
				name = scn.nextLine();
				System.out.println("상품의 가격을 입력해주세요.");
				price = Integer.parseInt(scn.nextLine());
				
				prod = new Product();
				prod.setProductCode(code);
				prod.setProductName(name);
				prod.setPrice(price);
				m2.modify(prod);
				
				if(m2.add(prod)) {
					System.out.println("상품의 정보가 수정되었습니다.");
				}else{
					System.out.println("상품의 정보수정이 되지않았습니다.");
				};				
				
				break;
			case 4://삭제
				System.out.println("삭제할 상품의 코드를 입력해주세요.");
				code = scn.nextLine();
				
				prod = new Product();
				prod.setProductCode(code);
				m2.remove(code);
				
				if(m2.add(prod)) {
					System.out.println("상품이 삭제되었습니다.");
				}else{
					System.out.println("상품이 삭제되지않았습니다.");
				};
				break;
			default:
				run = false;
				break;
			}
		}
		System.out.println("프로그램이 종료되었습니다.");
		scn.close();

	}

	void method2() {
		// 상품코드 : M01, 상품명 : 만년필, 가격 : 10000
		MethodExe2 m2 = new MethodExe2();
		if (m2.add(new Product("M01", "만년필", 10000))) {
			System.out.println("등록이 완료되었습니다.");
		}

		// 상품코드, 상품명, 가격 modify(Product prod)
		Product prod = new Product("A001", "지우개2", 800);
		if (m2.modify(prod)) {
			System.out.println("수정이 완료되었습니다.");
		}

		if (m2.remove("C001")) {
			System.out.println("삭제가 완료되었습니다.");
		}

		Product search = new Product();
		search.setProductName("지우개");
		search.setPrice(700);

		Product[] list = m2.productList(search);
		for (int i = 0; i < list.length; i++) {
			if (list[i] != null) {
				System.out.println(list[i].showList());
			}
		}
	}

	void method3() {
		MethodExe3 m3 = new MethodExe3();
//		System.out.println(m3.gugudan(3, 4));
		m3.printStar(5, "*");
//		m3.printCard();
	}

	void method4() {
//		MethodExe4 m4 = new MethodExe4();
		MethodExe4.main();
	}
}
