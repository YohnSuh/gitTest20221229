package board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BoardDAO {
	// return할 형은 X, insertBoard(BoardDTO 주소값을 저장하는 변수) 메서드 정의
	// 디비연결하는 메서드 1,2단계
	public Connection getConnection() throws Exception {
		// 예외처리를 함수 호출하는 곳으로 전달
		
		//1단계 JDBC 프로그램 가져오
		Class.forName("com.mysql.cj.jdbc.Driver");
		//2단계 JDBC 프로그램 이용해서 데이터베이스 연결
		String dbUrl="jdbc:mysql://localhost:3306/jspdb2?serverTimezone=Asia/Seoul";
		String dbUser="root";
		String dbPass="1234";
		Connection con=
		    DriverManager.getConnection(dbUrl, dbUser, dbPass);
		return con;
	}
	public void insertBoard(BoardDTO dto) {
		System.out.println("BoardDAO insertBoard()");
		System.out.println("BoardDTO의 주소값: " + dto);
		System.out.println("BoardDTO의 name: " + dto.getName());
		System.out.println("BoardDTO의 subject: " + dto.getSubject());
		System.out.println("BoardDTO의 content: " + dto.getContent());
		System.out.println("BoardDTO의 readcount: " + dto.getReadcount());
		System.out.println("BoardDTO의 date: " + dto.getDate());
		try {
			// 1, 2 메서드 호출
			Connection con = getConnection();
			// 3 sql 구문 만들기
			String sql="insert into board(num, name, subject, content, readcount, date) values(?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt =con.prepareStatement(sql);
			pstmt.setInt(1, 2); // 게시판의 글번호는 우선 하드코딩; 새 글 작성할 때마다 숫자를 키워야 한다.
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getSubject());
			pstmt.setString(4, dto.getContent());
			pstmt.setInt(5, dto.getReadcount());
			pstmt.setTimestamp(6, dto.getDate());
			// 4 sql 구문 실행
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			// 마무리
		} finally {
			
		}
		
	} // insertBoard() method
} // class
