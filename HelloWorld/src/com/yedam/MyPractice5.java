package com.yedam;

import java.util.Scanner;

public class MyPractice5 {
	public static void main(String[] args) {
		/*5명의 학생 점수를 입력받고, 평균 점수를 계산하는 프로그램*/
		Scanner scn = new Scanner(System.in);
		
		int[] scores = getScores(scn);
		double avg = calculateAverage(scores);
		printAvg(avg);
		
		scn.close();
	}
	
	public static int[] getScores(Scanner scn) {
		int[] scores = new int[5];
		for(int i=0; i<scores.length; i++) {
			System.out.println((i+1) + "번째 학생의 점수를 입력하세요>> ");
			scores[i] = scn.nextInt();
		}
		
		return scores;
	}
	
	public static double calculateAverage(int[] scores) {
		int sum = 0;
		for(int i=0; i<scores.length; i++) {
			sum += scores[i];
		}
		return (double) sum / scores.length;
	}
	
	public static void printAvg(double avg) {
		System.out.println("학생들의 평균점수는 " + avg + "입니다.");
	}
}
