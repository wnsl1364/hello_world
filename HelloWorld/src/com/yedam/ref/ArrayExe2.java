package com.yedam.ref;

import com.yedam.variable.Member;

public class ArrayExe2 {
	public static void main(String[] args) {
		String[] strAry = {"Hello", "World", "20", "23.4"};
		//확장 for
		for(String str : strAry) {
			System.out.println(str);
		}
		
		//크기지정
		strAry = new String[10]; //{null, null, null, ..., null}
		strAry[0] = new String("Nice");
		for(String str : strAry) {
			System.out.println(str);
		}
		
		//Member 클래스.
		Member[] memAry = new Member[10]; //{null, null, null, ..., null}
		memAry[0] = new Member(); //인스턴스 생성(객체)
		memAry[0].setMember("홍길동", 80); //80 -> 90
		memAry[0].setScore(90);
		memAry[0].showInfo();
		
		memAry[1] = new Member();
		memAry[1].setMember("한주연", 100); //100 -> 95
		memAry[1].setScore(95);
		memAry[1].showInfo();
		
		memAry[2] = new Member("주만성" , 100);
		memAry[2].setScore(95);
		memAry[2].showInfo();
		
		for(int i=0; i<memAry.length; i++) {
			if(memAry[i] != null) {
//				memAry[i].showInfo();
			}
		}
	}
}
