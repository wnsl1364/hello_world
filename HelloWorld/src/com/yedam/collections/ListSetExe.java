package com.yedam.collections;

import java.util.ArrayList;
import java.util.List;

public class ListSetExe {
	public static void main(String[] args) {
		//배열
		Integer[] iAry = { 10, 20, 30 };
		for(int i=0;i<iAry.length; i++) {
			System.out.println(iAry[i]);
		}

		//List 컬렉션
		List<Integer> ilist = new ArrayList<Integer>();
		ilist.add(10);
		ilist.add(20);
		ilist.add(30);
		ilist.add(40);
		for(int i=0; i<ilist.size(); i++) {
			System.out.println(ilist.get(i));
		}
		
		
	}
}
