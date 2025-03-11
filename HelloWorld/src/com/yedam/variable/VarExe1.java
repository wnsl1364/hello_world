package com.yedam.variable;

// 관례 : 클래스의 이름은 대문자로 시작.
public class VarExe1 {
	// 연산은 두 변수의 유형(data type)이 동일.
	public static void main(String[] args) {
		int number1 = 70;
		int number2 = 80;
		number1 = 71;
		
		int sum = number1 + number2;		
		System.out.println("두 점수의 합은 " + sum + "입니다.");
		
		//double avg = sum / 2; //double type 소수점까지 표현가능
		double avg = (double)sum / 2.0; //하나라도 더블타입이면 자동 형변환됨
		System.out.println("두 점수의 평균은 " + avg + "입니다.");
	}
}
