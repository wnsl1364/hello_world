package com.yedam.classes;

public class MethodMain {
	public static void main(String[] args) {
		MethodExe3 m3 = new MethodExe3();
//		System.out.println(m3.gugudan(3, 4));
		m3.printStar(5, "*");
//		m3.printCard();
	}
	
	void method2() {
		//상품코드 : M01, 상품명 : 만년필, 가격 : 10000
		MethodExe2 m2 = new MethodExe2();
		if(m2.add(new Product("M01", "만년필", 10000))) {
			System.out.println("등록이 완료되었습니다.");
		}
		
		//상품코드, 상품명, 가격 modify(Product prod)
		Product prod = new Product("A001", "지우개2", 800);
		if(m2.modify(prod)) {
			System.out.println("수정이 완료되었습니다.");
		}
		
		if(m2.remove("C001")) {
			System.out.println("삭제가 완료되었습니다.");
		}
		
		Product search = new Product();
		search.setProductName("지우개");
		search.setPrice(700);
		
		Product[] list = m2.productList(search);		
		for(int i=0; i<list.length; i++) {
			if(list[i] != null) {
				System.out.println(list[i].showList());
			}
		}
	}
}
