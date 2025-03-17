package com.yedam.interfaces;
/*
 * 실행클래스
 */
public class ServiceApp {
	public static void main(String[] args) {
//		MysqlDao dao = new MysqlDao();
//		OracleDao dao = new OracleDao();
		
		//어떤 구현클래스이든 상관없이 dao라는 인터페이스를 가지고있기때문에 인터페이스의 변수에 구현클래스를 대입
		//인터페이스 타입 변수 = 구현객체
		Dao dao = new OracleDao(); 
		
		//등록
//		dao.insert();
//		dao.add();
		dao.insert();
		
		//수정
//		dao.modify();
		dao.update();
		
		//삭제
//		dao.remove();
		dao.delete();
	}
}
