package com.yedam.classes;

public class MethodExe5 {
	public static void main(String[] args) {
		//상수선언
		int num1 = 10;
		num1 = 20;
		
		final int num2 = 20;
//		num2 = 30; //상수는 변경불가
		
		final Product p1 = new Product();
		p1.setProductCode("A001");		
		p1.setProductCode("B001"); //객체 내부의 필드는 변경할 수 있다.
		
//		p1 = new Product(); //새로운 값을 담을 수 없은 상수
	}
}
