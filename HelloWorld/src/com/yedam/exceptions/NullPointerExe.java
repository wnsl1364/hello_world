package com.yedam.exceptions;

public class NullPointerExe {
	public static void main(String[] args) {
		String str = "Hello";
		int[] intAry = { 10, 20 }; // [0], [1] 범위

		// 예외 처리 (try ~ catch 문 사용)
		try {
			System.out.println(str.toString());
			intAry[2] = 30;
		} catch (NullPointerException e) {
			// 예외의 대체 기능넣어주기
			System.out.println("Null값을 참조합니다.");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열의 값을 확인하세요.");
		}
		System.out.println("End of program");
	}
}
