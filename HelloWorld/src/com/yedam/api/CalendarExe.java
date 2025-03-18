package com.yedam.api;

import java.util.Calendar;

public class CalendarExe {
	public static void main(String[] args) {
		//Calendar 인스턴스 생성(현재 날짜와 시간 정보를 가짐)
		Calendar cal = Calendar.getInstance();
//		System.out.println(cal);
		
		//Calendar 객체의 날짜 설정(set)
		cal.set(Calendar.YEAR, 2024); // cal.set메소드를 이용해서 달력의 년도,월 등등 수정가능
		cal.set(Calendar.MONTH, 1);
		cal.set(Calendar.DATE, 10);
		cal.set(2023, 2, 5); // 2023년 3월 5일 (연도, 월, 일 한번에 설정 가능)

		//Calendar에서 설정한 날짜 정보 출력(get)
		System.out.println(cal.get(Calendar.YEAR) + "년");
		System.out.println(cal.get(Calendar.MONTH) + 1 + "월");// month는 + 1을 해줘야함
		System.out.println(cal.get(Calendar.DATE) + "일");
		System.out.println(cal.get(Calendar.DAY_OF_WEEK) + "요일");// 요일
		System.out.println(cal.getActualMaximum(Calendar.DATE) + ": 마지막날");// getActualMaximum을 이용해서 마지막날 가져오기

//		int year = cal.get(Calendar.YEAR);
//		System.out.println(year);

		// 특정 연도와 월을 입력하면 해당 월의 1일 요일과 마지막 날짜를 반환하는 메소드 호출
		getDay(2025, 7); // 7월 1일의 요일정보
		getLastDate(2025, 7); // 7월달의 마지막날
		
		System.out.println(getDay(2025, 7));
		System.out.println(getLastDate(2025, 7));
	}

	static String getDay(int year, int month) {
		Calendar today = Calendar.getInstance(); //Calendar 인스턴스 생성
		today.set(year, month - 1, 1);
		int day = today.get(Calendar.DAY_OF_WEEK);

		switch (day) {
		case 1:
			return "일요일";
		case 2:
			return "월요일";
		case 3:
			return "화요일";
		case 4:
			return "수요일";
		case 5:
			return "목요일";
		case 6:
			return "금요일";
		case 7:
			return "토요일";
		}
		return "";
	}

	// 연도와 월을 입력하면 해당 월의 마지막 날짜를 반환하는 메소드
	static int getLastDate(int year, int month) {
		Calendar lastDay = Calendar.getInstance();
		lastDay.set(Calendar.YEAR, year);
		lastDay.set(Calendar.MONTH, month);
		return lastDay.getActualMaximum(Calendar.DATE);
	}
}
