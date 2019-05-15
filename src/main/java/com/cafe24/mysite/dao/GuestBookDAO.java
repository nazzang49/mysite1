package com.cafe24.mysite.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.mysite.vo.GuestBookVO;

public class GuestBookDAO {

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
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:mariadb://192.168.1.45:3307/webdb";
		String user = "webdb";
		String pw = "webdb";
		try {
			conn = DriverManager.getConnection(url, user, pw);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public List<GuestBookVO> getListBook(){
		List<GuestBookVO> list = new ArrayList<>();
		try {
			conn = getConnection();

			//SQL
			sql = "select * from guestbook";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				GuestBookVO vo = new GuestBookVO();
				vo.setNo(rs.getLong(1));
				vo.setName(rs.getString(2));
				vo.setPassword(rs.getString(3));
				vo.setContents(rs.getString(4));
				vo.setReg_date(rs.getDate(5));
				
				list.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("[에러 발생]");
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
	public GuestBookVO get(Long no){
		GuestBookVO vo = new GuestBookVO();
		try {
			conn = getConnection();

			//방명록 내용만 변경 가능
			sql = "select name, contents from guestbook where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setName(rs.getString(1));
				vo.setContents(rs.getString(2));
			}
		} catch (SQLException e) {
			System.out.println("[에러 발생]");
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}
	
	public boolean insert(GuestBookVO vo) {
		int flag = 0;
		try {
			conn = getConnection();

			sql = "insert into guestbook values(7,?,?,?,now())";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,vo.getName());
			pstmt.setString(2,vo.getPassword());
			pstmt.setString(3,vo.getContents());
			
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
	
	public boolean delete(GuestBookVO vo) {
		int flag = 0;
		try {
			conn = getConnection();

			sql = "delete guestbook where no=? and password=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1,vo.getNo());
			pstmt.setString(2,vo.getPassword());
			
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
	
	public boolean update(Long no, String contents) {
		int flag = 0;
		try {
			conn = getConnection();

			sql = "update guestbook set contents=? where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,contents);
			pstmt.setLong(2,no);
			
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
}
