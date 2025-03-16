package com.yedam.ref; // 패키지 선언


//난수 공식
//int randomValue = (int)(Math.random() * (max-min+1)) + min;
public class ArrayExe1 {
    public static void main(String[] args) {
        // 정수형 배열 intAry 선언 및 초기화
        int[] intAry = {10, 20, 30}; 
        
        // 배열 요소를 순차적으로 출력
        for(int i = 0; i < intAry.length; i++) {
            System.out.println(intAry[i]); // 배열의 i번째 요소 출력
        }
        
        // 배열 재할당 (새로운 배열을 생성하여 참조 변경)
        intAry = new int[] {40, 50, 60}; // 기존 배열을 새로운 배열로 변경
        
        // 크기가 10인 배열을 생성 (모든 요소는 기본값 0으로 초기화됨)
        intAry = new int[10]; // {0, 0, 0, 0, ..., 0}
        
        // 특정 인덱스에 값 저장
        intAry[3] = 30; // 4번째 요소에 30 할당
        intAry[9] = 90; // 10번째 요소에 90 할당

        // 배열 범위를 벗어나는 인덱스를 사용하면 오류 발생
        // intAry[10] = 100; // 오류 발생 (배열 크기는 10이므로 인덱스 10은 존재하지 않음)

        // 첫 번째 요소(0번 인덱스)에 1~100 사이의 랜덤 값 저장
        intAry[0] = (int) (Math.random() * 100) + 1;
        
        // 배열을 순회하며 값이 0인 경우 1~100 사이의 랜덤 값 할당
        for(int i = 0; i < intAry.length; i++) {
            if(intAry[i] == 0) { // 값이 0이면
                intAry[i] = (int) (Math.random() * 100) + 1; // 랜덤 값 할당
            }
        }
        
        // 배열의 홀수 값의 합을 구하기 위한 변수 선언
        int scores = 0; // 합계를 저장할 변수
        
        // 배열을 순회하며 홀수인 경우 합산
        for(int i = 0; i < intAry.length; i++) {
            if(intAry[i] % 2 == 1) { // 홀수인지 확인
                scores += intAry[i]; // 누적합 계산
            }
        }
        
        // 홀수 값의 합 출력
        System.out.println("홀수의 합은 " + scores + "입니다.");

        // 배열의 모든 요소를 출력
        for(int i = 0; i < intAry.length; i++) {
            System.out.println(i + "번째 값은 " + intAry[i]);
        }
    }
}