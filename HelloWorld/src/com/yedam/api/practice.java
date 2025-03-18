package com.yedam.api;

public class practice {
	public static void main(String[] args) {
		//바이트배열을 문자열로 변환
		byte[] bytes = {72, 101, 108, 108, 111, 32, 74, 97, 118, 97};
		
		String str1 = new String(bytes);
		System.out.println(str1);
		
		String str2 = new String(bytes, 6, 4);
		System.out.println(str2);
		
		//문자추출 : charAt
		String subject = "자바 프로그래밍";
		char charValue = subject.charAt(3);
		System.out.println(charValue);
		
		//문자추출 예제
		String ssn = "010624-1230123";
		char sex = ssn.charAt(7);
		switch(sex) {
			case '1' :
			case '3' :
				System.out.println("남자입니다.");
				break;
			case '2' :
			case '4' :
				System.out.println("여자입니다");
				break;
		}
		
		//문자열 비교 : equals
		String strVar1 = new String("한주연");
		String strVar2 = "한주연";
		
		if(strVar1 == strVar2) {
			System.out.println("같은 String 객체를 참조");
		}else {
			System.out.println("다른 String 객체를 참조");
		}
		
		if(strVar1.equals(strVar2)) {
			System.out.println("같은 문자열을 가짐");
		}else {
			System.out.println("다른 문자열을 가짐");
		}
		
		//바이트 배열로 변환 : getBytes(문자열을 암호화하거나, 네트워크로 문자열을 전송할때 사용)
		
		//문자열 찾기
		
	}
}
