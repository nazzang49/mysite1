package com.cafe24.mysite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.mysite.vo.GuestBookVO;
import com.cafe24.mysite.vo.UserVO;

public class UserDAO {

	static Connection conn = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;
	static String sql = "";
	
	//일괄 종료
	public static void close() {
		try {
			if(rs!=null&&!rs.isClosed()) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}try {
			if(pstmt!=null&&!pstmt.isClosed()) {
				pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}try {
			if(conn!=null&&!conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//DB 연결
	private Connection getConnection() {
		Connection conn = null;
		try {
			//1. JDBC Driver(PostgreSQL) 로딩 after add User Library
			Class.forName("org.postgresql.Driver");
			
			//2. 연결하기
			String url = "jdbc:postgresql://192.168.1.43:5432/webdb";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			
			System.out.println("연결 성공");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//회원추가
	public boolean insert(UserVO vo) {
		int flag = 0;
		try {
			conn = getConnection();
			
			System.out.println(conn);

			sql = "insert into member values(default,?,?,?,?,now())";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,vo.getName());
			pstmt.setString(2,vo.getEmail());
			pstmt.setString(3,vo.getPw());
			pstmt.setString(4,vo.getGender());
			
			flag = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러 발생]");
			e.printStackTrace();
		} finally {
			close();
		}
		if(flag==1) return true;
		return false;
	}
	
	//회원정보 변경
	public boolean update(Long no, UserVO vo) {
		int flag = 0;
		try {
			conn = getConnection();

			sql = "update member set name=?, email=?, pw=?, regdate=now() where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,vo.getName());
			pstmt.setString(2,vo.getEmail());
			pstmt.setString(3,vo.getPw());
			pstmt.setLong(4,no);
			
			flag = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러 발생]");
			e.printStackTrace();
		} finally {
			close();
		}
		if(flag==1) return true;
		return false;
	}
	
	public UserVO get(Long no) {
		UserVO vo = new UserVO();
		try {
			conn = getConnection();

			//SQL
			sql = "select name, email, pw from member where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setName(rs.getString(1));
				vo.setEmail(rs.getString(2));
				vo.setPw(rs.getString(3));
			}
		} catch (SQLException e) {
			System.out.println("[에러 발생]");
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}
	
	//로그인하는 사용자의 세션값 저장을 위한 정보 추출
	public UserVO get(String email, String pw){
		UserVO vo = null;
		try {
			conn = getConnection();

			//SQL
			sql = "select * from member where email=? and pw=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new UserVO();
				vo.setNo(rs.getLong(1));
				vo.setName(rs.getString(2));
			}
		} catch (SQLException e) {
			System.out.println("[에러 발생]");
			e.printStackTrace();
		} finally {
			close();
		}
		System.out.println(vo);
		return vo;
	}
}
