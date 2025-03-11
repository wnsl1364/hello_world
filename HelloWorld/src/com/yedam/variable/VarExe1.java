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
		
		double avg1 = sum / 2; //double type 소수점까지 표현가능
		double avg2 = (double)sum / 2.0; //하나라도 더블타입이면 자동 형변환됨
		System.out.println("두 점수의 평균은 " + avg1 + "입니다.");
		System.out.println("두 점수의 평균은 " + avg2 + "입니다.");
		
		// avg1 : sum과 2가 둘 다 정수(int)이므로, 정수 나눗셈이 수행되고 소수점 이하가 버려진다.
		// avg2 : (double)sum으로 인해 sum이 실수(double)로 변환/ 2.0도 실수이므로, 연산 결과가 정확한 실수(double)로 나온다.
	}
}
