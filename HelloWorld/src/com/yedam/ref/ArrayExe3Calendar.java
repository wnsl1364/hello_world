package com.yedam.ref;

public class ArrayExe3Calendar {
	// 2025년 기준으로 월 정보 => 1일의 위치를 반환
	public static int getFirstDay(int month) {
		// 각 월에 대해 1일의 시작 요일을 반환하는 switch문
		switch(month) {
		case 1 :
			return 3; // 1월의 첫날은 수요일 (0=일, 1=월, 2=화, 3=수, ...)
		case 2 :
			return 6; // 2월의 첫날은 토요일
		case 3 :
			return 6; // 3월의 첫날은 토요일
		case 4 :
			return 2; // 4월의 첫날은 화요일
		default:
			return 1; // 그 외의 경우는 월요일
		}
	}
	
	// 2025년 기준으로 각 월의 마지막 날짜를 반환
	public static int getLastDate(int month) {
		// 각 월에 대해 마지막 날짜를 반환하는 switch문
		switch(month) {
		case 2 :
			return 28; // 2월은 28일까지 (2025년은 윤년이 아님)
		case 4 :
		case 6 :
		case 9 :
		case 11 :
			return 30; // 4, 6, 9, 11월은 30일까지
		default:
			return 31; // 나머지 월은 31일까지
		}
	}
	
	public static void main(String[] args) {
		// 주요일 배열 선언 (요일 순서: 일, 월, 화, 수, 목, 금, 토)
		String[] days = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
		// 각 요일을 출력
		for (String day : days) {
			System.out.print(" " + day);
		}
		System.out.println(); // 요일 출력 후 줄바꿈
		
		// 3월을 기준으로
		int month = 3;
		// 첫날의 위치를 반환 (3월의 첫날은 토요일, 즉 6번 인덱스)
		int space = getFirstDay(month);
		// 3월의 마지막 날은 31일
		int lastDate = getLastDate(month);
		// 특정 날짜에 "평가"를 출력할 변수
		int testDay = 21;
		
		// 첫날 이전의 공백 출력
		for (int i = 0; i < space; i++) {
			System.out.print("    "); // 공백 출력
		}
		
		// 1일부터 마지막 날까지 출력
		for (int i = 1; i <= lastDate; i++) {
			// 숫자를 문자열로 변환하여 길이를 체크
			if (String.valueOf(i).length() == 1) {
				// 한 자리 숫자일 경우, 앞에 공백을 추가하여 정렬
				System.out.print("   " + i);
			} else if (String.valueOf(i).length() == 2) {
				// 두 자리 숫자일 경우, 특정 날짜에 "평가" 출력
				if(i == testDay) {
					System.out.print(" 평가");
				}else {
					System.out.print("  " + i);
				}
			}
			
			// 7일마다 줄바꿈 (주 단위로 출력)
			if ((space + i) % 7 == 0) {
				System.out.println();
			}
		}
	}
}