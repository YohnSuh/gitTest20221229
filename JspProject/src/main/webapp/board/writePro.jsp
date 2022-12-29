
<%@page import="board.BoardDAO"%>
<%@page import="board.BoardDTO"%>
<%@page import="java.sql.Timestamp"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
// board/writePro.jsp
// 글쓰기 폼에서 입력한 내용을 서버에 전달하면 내장객체 request에 정보가 저장
// request 한글처리
request.setCharacterEncoding("utf-8");
// request name, subject, content parameter를 가져와 변수에 저장
String name = request.getParameter("name");
String subject = request.getParameter("subject");
String content = request.getParameter("content");

// BoardDTO 객체 생성 (기억장소 할당)
BoardDTO dto = new BoardDTO();
// set 메서드 호출, 파라미터값 저장
dto.setName(name);
dto.setSubject(subject);
dto.setContent(content);
// 현 시스템 날짜와 시간
dto.setDate(new Timestamp(System.currentTimeMillis()));
// 조회수 0 설정
dto.setReadcount(0);
// 글번호: dto.setNum(num) => BoardDAO에서 작업

// BoardDAO 객체생성 (기억장소 할당)
BoardDAO dao = new BoardDAO();

// BoardDAO주소.insertBoard(BoardDTO 주소) 메서드 호출
dao.insertBoard(dto);

// 글목록
%>