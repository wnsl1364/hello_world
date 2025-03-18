package com.yedam.api;

public class StringExe {
	public static void main(String[] args) {
		// 바이트배열을 문자열로 변환
		String str = "Hello, World";
		str = new String("Hello, World");
		byte[] bAry = str.getBytes();
		for (int i = 0; i < bAry.length; i++) {
			System.out.println(bAry[i]);
		}

		byte[] bstr = { 72, 101, 108, 108, 111, 44, 32, 87, 111, 114, 108, 100 };
		String msg = new String(bstr, 7, 5);
		System.out.println(msg);

		// charAt : 문자추출
		char result = msg.charAt(0);
		System.out.println((int) result);

		// String : "", char : ''
		if (result == 'W') {
			// 비교구문 character 타입을 비교하기 때문에 ''으로 적어쥼
		}

		// indexOf : 문자열 찾기
		int idx = msg.indexOf("o");
		if (idx != -1) {
			// 처리
		}
		String[] names = { "홍길금", "홍길은", "홍길동", "한주연", "박홍길" };
		int count = 0;
		for (int i = 0; i < names.length; i++) {
			if (names[i].indexOf("홍") == 0) {// if names[i].indexOf("길") != -1이면 이름중에 "길"이 있는 사람을 뜻한다
				count++;
			}
		}
		System.out.println("\"홍\"의 성을 갖는 이름의 갯수 : " + count);

		// substring() : 문자열 잘라내기
		System.out.println("Hello, World".substring(3, 7));
	}
}
