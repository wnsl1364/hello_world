package com.yedam.collections;

import java.util.ArrayList;
import java.util.List;

import com.yedam.bookApp.Book;

public class ListExe {
	public static void main(String[] args) {
		// 배열을 활용해서 값을 추가할 경우
		// 새로운 배열을 선언해서 기존의 값을 복사한 후 추가.
		// 배열의 크기가 정해져있기때문에 귀찮은 일이 생김
		int[] intAry1 = { 10, 20 };
		int[] intAry2 = new int[5];
		for (int i = 0; i < intAry1.length; i++) {
			intAry2[i] = intAry1[i];
		}
		intAry2[2] = 30;

		// List 컬렉션 : 크기 무한정
		List<Integer> list = new ArrayList<Integer>();
		list.add(10);// 추가
		list.add(14);
		list.add(17);
		list.add(20);

		Integer it1 = list.get(0); // 조회

		list.remove(0); // 삭제

		list.set(0, 30); // 수정

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		// List - ArrayList
		List<String> list2 = new ArrayList<String>();
		list2.add("Hello");
//		list2.add(200);
//		list2.add(new Book());

		for (int i = 0; i < list2.size(); i++) {
			String result = (String) list2.get(i); // Object -> Casting String, Integer
		}

		List<Book> list3 = new ArrayList<Book>();
		list3.add(new Book());
	}
}
