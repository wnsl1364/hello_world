package com.yedam.bookApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberJdbc {
	// Connection 생성
	Connection getConnect() {
		// 1. 데이터베이스 연결을 위한 기본 정보 (Oracle 기준)
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 오라클 DB 접속 URL
		String userId = "scott"; // 데이터베이스 사용자 계정
		String userPw = "tiger"; // 데이터베이스 사용자 비밀번호

		// 2. 데이터베이스 연결(Connection 객체 생성)
		try {
			Connection conn = DriverManager.getConnection(url, userId, userPw);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}// End of getConnect

	// 로그인처리
	// (String id, String pw)
	public User login(String id, String pw) {
		// id, pw 조회 후 결과가 있으면 로그인 성공, 실패
		Connection conn = getConnect();
		String sql = "SELECT * FROM tbl_member WHERE user_id = ? and password = ?";

		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				User user = new User(rs.getString("user_id"), rs.getString("user_name"), rs.getString("password"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("로그인 실패");
		}
		return null;
	}

	// 회원목록을 가지고오는 메소드
	public List<Map<String, String>> memberList() {
		// [{userId : "user01"}, {password: "1111"}, {userName : "홍길동"}]
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Connection conn = getConnect();

		String sql = "Select * from tbl_member";

		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				// userId, password, userName 저장할 객체
				Map<String, String> map = new HashMap<String, String>();
				map.put("userId", rs.getString("user_id"));
				map.put("password", rs.getString("password"));
				map.put("userName", rs.getString("user_name"));
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
