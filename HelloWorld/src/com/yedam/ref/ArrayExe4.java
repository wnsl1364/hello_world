package com.yedam.ref;

public class ArrayExe4 {
	public static void main(String[] args) {
		int[] intAry = { 8, 7, 6, 5, 4 };

		// 위치변경
		int temp = intAry[0];
		intAry[0] = intAry[1];
		intAry[1] = temp;

		for (int j = 0; j < intAry.length - 1; j++) {
			for (int i = 0; i < intAry.length - 1; i++) {
				// System.out.println(intAry[i]);
				// i, i+1번째의 값이 내림차순이면 올림차순으로 변경
				if (intAry[i] > intAry[i + 1]) {
					temp = intAry[i];
					intAry[i] = intAry[i + 1];
					intAry[i + 1] = temp;
				}

				// i, i+1번째의 값이 올림차순이면 내림차순으로 변경
//				if(intAry[i] < intAry[i+1]) {
//					temp = intAry[i];
//					intAry[i] = intAry[i+1];
//					intAry[i+1] = temp;
//				}
			}
		}

		for (int i = 0; i < intAry.length; i++) {
			System.out.println(intAry[i]);
		}
	}
}
