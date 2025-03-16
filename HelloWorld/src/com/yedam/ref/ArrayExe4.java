package com.yedam.ref;

public class ArrayExe4 {
    public static void main(String[] args) {
        int[] intAry = { 8, 7, 6, 5, 4 };  // 5개의 정수로 이루어진 배열 선언

        // 위치변경
        int temp = intAry[0];  // 첫 번째 요소를 temp에 저장
        intAry[0] = intAry[1]; // 첫 번째 요소에 두 번째 요소 값 대입
        intAry[1] = temp;      // 두 번째 요소에 temp 값(기존 첫 번째 요소)을 대입

        // 버블정렬을 통한 오름차순 정렬
        for (int j = 0; j < intAry.length - 1; j++) {  // 배열의 크기만큼 반복 (배열의 길이 - 1)
            for (int i = 0; i < intAry.length - 1; i++) { // 인덱스 0부터 배열 끝까지 비교
                // 두 인덱스의 값을 비교하여 내림차순이면 오름차순으로 변경
                if (intAry[i] > intAry[i + 1]) { 
                    // 두 인덱스의 값을 바꾸는 과정
                    temp = intAry[i];        // i번째 값을 임시 변수 temp에 저장
                    intAry[i] = intAry[i + 1];   // i번째 값을 i+1번째 값으로 교환
                    intAry[i + 1] = temp;        // i+1번째 값을 temp 값으로 교환
                }
            }
        }

        // 정렬된 배열 출력
        for (int i = 0; i < intAry.length; i++) {
            System.out.println(intAry[i]);  // 배열의 각 요소를 출력
        }
    }
}