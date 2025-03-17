package com.yedam.interfaces;

/*
 * Data Access Object (Dao)
 * 인터페이스 내의 메소드는 추상메소드
 * Mysql을 이용해서 1차 프로젝트를 진행하구 Oracle을 활용해서 2차 프로젝트를 함
 * 인터페이스를 활용해서 자식클래스를 선언하면 규칙이 정해짐 --> implements사용
 */
public interface Dao {
	void insert(); //abstract 안붙여도 추상메소드로 인식
	void update();
	void delete();	
}
