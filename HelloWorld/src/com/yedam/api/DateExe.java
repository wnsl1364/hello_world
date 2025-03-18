package com.yedam.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExe {
    public static void main(String[] args) {
        // 현재 날짜와 시간 정보를 담고 있는 Date 객체 생성
        Date today = new Date();
        // Date 객체를 toString() 메서드를 사용하여 기본적으로 출력
        System.out.println(today.toString());  // 예: Tue Mar 18 14:20:30 KST 2025

        // 출력 포맷 지정
        //하기 위해 SimpleDateFormat 객체 생성
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 현재 날짜를 지정한 포맷에 맞게 변환하여 문자열로 출력
        String formatStr = sdf.format(today);
        System.out.println(formatStr);  // 예: 2025-03-18 14:20:30

        try {
            // 문자열을 날짜 객체로 변환하는 코드 (문자열 -> Date 객체)
            Date tday = sdf.parse("2000-01-01 10:00:00");
            // 변환된 Date 객체 출력
            System.out.println(tday);  // 예: Sat Jan 01 10:00:00 KST 2000
        } catch (ParseException e) {
            // 날짜 형식이 잘못되었을 때 예외 처리
            e.printStackTrace();  // 예외 정보 출력
        }
    }
}