package com.yedam.classes;

public class MethodExe3 {
	//구구단 출력
	String gugudan(int num, int toNum) {
		// 2* 1 = 2
		String str = "";
		for(int n = num; n <= toNum; n++) {
			int dan = n;
			for(int i=1; i<=9; i++) {
//				System.out.println(dan + "*" + i + "=" + (dan*i));
				str += dan + "*" + i + "=" + (dan*i) + "\n";
			}			
		}
		return str;
	}
	
	//별출력
	void printStar(int cnt, String str) {
		for(int i=1; i<=cnt; i++) {
			String prstar = "";
			for(int j=1; j<=i; j++) {
				prstar += str;
			}
			System.out.println(prstar);
		}
	}
	
	//카드번호 보여주기(중복되지 않는 값을 16개 만들기)
	void printCard() {
		//배열선언
		int[] intAry = new int[16];
		//1~16까지 임의 수 할당
		for(int i=0; i<intAry.length; i++) {
			intAry[i] = (int) (Math.random() * 16) + 1;
		}
		//출력
		for(int i=0; i<intAry.length; i++) {
			System.out.printf("%3d", intAry[i]);
			if(i%4 == 3) {
				System.out.println();
			}
		}
	}
}
