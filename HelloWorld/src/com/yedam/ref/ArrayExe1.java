package com.yedam.ref;

public class ArrayExe1 {
	public static void main(String[] args) {
		int[] intAry = {10, 20, 30};
		for(int i=0; i<intAry.length; i++) {
			System.out.println(intAry[i]);
		}
		
		intAry = new int[] {40, 50, 60}; //값을 재할당 할때는 new int[]를 써줘야함
		
		intAry = new int[10]; // {0,0,....,0}
		intAry[3] = 30;
		intAry[9] = 90;
		
		//intAry[10] = 100; //오류발생 -> 배열의 길이를 넘어선 위치라서
		
		intAry[0] = (int) (Math.random() * 100) + 1;
		for(int i=0; i<intAry.length; i++) {
			if(intAry[i] == 0) {
				intAry[i] = (int) (Math.random() * 100) + 1;
			}
		}
		// 홀수값의 합
		//"홀수값의 합은 ...입니다."		
		int scores = 0; // 합을 저장할 변수는 반복문 밖에서 선언
		for(int i = 0; i < intAry.length; i++) {
		    if(intAry[i] % 2 == 1) { // 홀수인지 확인
		        scores += intAry[i]; // 누적합 계산
		    }
		}
		System.out.println("홀수의 합은 " + scores + "입니다.");

		
		for(int i=0; i<intAry.length; i++) {
			System.out.println(i + "번째 값은" + intAry[i]);
		}
	}
}
