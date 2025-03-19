package com.yedam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// DAO (Data Access Object) 클래스
// - 데이터베이스와 연동하여 데이터를 조회하는 역할을 수행
// - 데이터베이스 접근, SQL 실행, 결과 처리의 흐름을 확인할 수 있음

public class DaoExe {
    public static void main(String[] args) {
        // 1. 데이터베이스 연결을 위한 기본 정보 (Oracle 기준)
        String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 오라클 DB 접속 URL
        String userId = "scott"; // 데이터베이스 사용자 계정
        String userPw = "tiger"; // 데이터베이스 사용자 비밀번호

        // 2. 실행할 SQL 문 (사원 정보를 조회)
        String sql = "SELECT empno, ename, job, mgr, hiredate, sal FROM emp ORDER BY empno DESC";

        // 3. 데이터베이스 연결 및 SQL 실행
        try {
            // 3-1. 데이터베이스 연결(Connection 객체 생성)
            Connection conn = DriverManager.getConnection(url, userId, userPw);
            System.out.println("데이터베이스 연결 성공!");

            // 3-2. SQL 실행을 위한 Statement 객체 생성
            conn.setAutoCommit(false); // 트랜잭션을 수동으로 처리하기 위해 자동 커밋 비활성화
            Statement stmt = conn.createStatement();
            
            // 3-3. DELETE 실행 (empno가 9999인 사원 삭제)
            // executeUpdate() 메서드는 데이터 변경을 수행하는 SQL (INSERT, UPDATE, DELETE)에 사용됨
            int r = stmt.executeUpdate("DELETE FROM emp WHERE empno = 9999");

            // 삭제 결과 확인
            if (r > 0) { 
                System.out.println("삭제 성공");
                conn.commit(); // 삭제가 성공하면 변경 사항을 커밋(저장)
            }

            // 3-4. SELECT 실행 (조회 결과를 ResultSet 객체로 반환)
            ResultSet rs = stmt.executeQuery(sql);            

            // 4. 조회된 데이터 처리 (결과 출력)
            while (rs.next()) { 
                // rs.next(): 한 행(row)씩 이동하면서 데이터가 존재하면 true 반환

                // 컬럼 값을 가져와서 변수에 저장
                int empNo = rs.getInt("empno"); // 사원 번호
                String eName = rs.getString("ename"); // 사원 이름
                String job = rs.getString("job"); // 직무
                String sal = rs.getString("sal"); // 급여

                // 조회된 데이터 출력
                System.out.println(empNo + ", " + eName + ", " + job + ", " + sal);
            }

            System.out.println("End of data!!"); // 데이터 출력 완료 메시지

            // 5. 사용한 자원 해제 (연결 닫기)
            rs.close();  // ResultSet 닫기 (조회 결과 해제)
            stmt.close(); // Statement 닫기 (SQL 실행 객체 해제)
            conn.close(); // Connection 닫기 (DB 연결 종료)
        } catch (SQLException e) {
            // 예외 발생 시 오류 메시지 출력
            e.printStackTrace();
        }
    }
}