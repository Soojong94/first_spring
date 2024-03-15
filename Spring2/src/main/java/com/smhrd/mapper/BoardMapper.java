package com.smhrd.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.smhrd.entity.Board;
import com.smhrd.entity.Reply;

@Mapper
public interface BoardMapper {
	// 인터페이스로 구현한 이유 : 여러 개의 클래스에 다중상속을 하기 위해
	// 추상클래스로 만들면 1개밖에 상속을 못함

	// MyBatis와 Spring 사이를 연결해 실행하는 Class
	// SELECT * FROM BOARD ORDER BY INDATE DESC
	public List<Board> boardList();

	// @Select("SELECT * FROM BOARD WHERE IDX = #{idx}") 참조할 때는 #{}
	public Board boardContent(int idx);

//	@Insert("INSERT INTO BOARD (TITLE, CONTENT, WRITER) VALUES (#{title}, #{content}, #{writer})")
	public void boardInsert(Board vo);

	public void boardDelete(int idx);

	public void boardUpdate(Board vo);

	public void boardCount(int idx);

	public void replyInsert(Reply vo);

	public List<Reply> replyList(int idx);

	
	

//	 아래는 생략된 부분
//
//	public class SqlSessionFactoryBean implements BoardMapper{
//		
//		@Override
//		public List<Board> boardList(){
//			List<Board> boardList = new ArrayList();
//	        // JDBC를 사용하여 데이터베이스와 통신하여 게시물 목록을 조회하는 코드 작성
//	        return boardList;
//		}
//	}

}
