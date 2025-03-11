package com.yedam.variable;

public class VarExe8 {
	public static void main(String[] args) {
		int n1 = 10;
		byte b1 = 20;
		byte b2 = 120;
		//byte result = b1 + 30; //-128 ~ (+)127
		//오른쪽 결과값은 정수값(int) 왼쪽은 byte => 그래서 오류가 남
		//=> (byte) (b1+30)로 형변환을 해주면 됨 (casting)
		byte result = (byte) (b1 + 30);
		System.out.println("더한 결과 : " + result);
		byte result2 = (byte) (b2 + 130);
		System.out.println("더한 결과 : " + result2);
		//-106이 나오는 이유 => 127을 넘어서면 -128과 127사이를 뺑글뺑글 돌면서 제일 작은 값으로 변환이 됨
		
		//byte -> int (자동형변환 : promotion)
		n1 = b2;
		System.out.println(b1);
		n1 = 200;
		b2 = (byte) n1;
		
		
		for(int i=1; i<15; i++) {
			System.out.println(b2++);
		}
	}
}
