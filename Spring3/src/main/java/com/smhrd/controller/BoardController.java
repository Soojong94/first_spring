package com.smhrd.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpServerErrorException;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.smhrd.entity.Board;
import com.smhrd.entity.Member;
import com.smhrd.entity.Reply;
import com.smhrd.mapper.BoardMapper;

@Controller // 해당 클래스가 Controller 가 되기 위한 명시
public class BoardController {

	@Autowired
	private BoardMapper mapper;

	// upcasting 이 되어 데이터타입이 다르게 나올 수 있음
	// 추상클래스와 인터페이스는 객체 생성 불가능
	// 그런데 객체를 받아왔음 : 무엇인가가 구현을 했다는 것임

	/*
	 * root context 내부의 <bean class="org.mybatis.spring.SqlSessionFactoryBean">
	 * <property name="dataSource" ref="dataSource" /> </bean> 이 구현함
	 */

	@RequestMapping("/")
	public String home() {
		return "main";
	}

	@RequestMapping("boardList.do")
	public @ResponseBody List<Board> boardList() {
		System.out.println("게시글 전체보기 기능");
		List<Board> list = mapper.boardList();

		return list;
	}

	@RequestMapping("/boardCount.do/{idx}")
	public @ResponseBody void boardCount(@PathVariable("idx") int idx) {
		System.out.println("게시글 조회수 기능");
		mapper.boardCount(idx);

	}
//

//
	@RequestMapping("/boardInsert.do")
	public @ResponseBody void boardInsert(HttpServletRequest request) {

		// 기본 생성자를 만들어야 하는 이유 - 만들지 않으면 이 아래 코드가 작동하지 않음
		// 내부적으로 작동하는 코드

		// Board vo = new Board();

		// String title = request.getParameter("title");
		// String content = request.getParameter("content");
		// String writer = request.getParameter("writer");

		// vo.setTitle(title);
		// vo.setTitle(content);
		// vo.setTitle(writer);

		System.out.println("게시글 입력 기능");

		// 파일을 서버 폴더에 저장하는 객체
		MultipartRequest multi = null;
		int fileMaxSize = 10 * 1024 * 10000;
		String savePath = request.getRealPath("resources/board");

		System.out.println(savePath);

		try {
			multi = new MultipartRequest(request, savePath, fileMaxSize, "UTF-8", new DefaultFileRenamePolicy());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String title = multi.getParameter("title");
		String content = multi.getParameter("content");
		String writer = multi.getParameter("writer");
		String imgpath = multi.getFilesystemName("imgpath");

		Board vo = new Board();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(writer);
		vo.setImgpath(imgpath);

		System.out.println(vo.toString());
		mapper.boardInsert(vo);

	}

	@RequestMapping("/boardDelete.do/{idx}")
	public @ResponseBody void boardDelete(@PathVariable("idx") int idx) {
		System.out.println("게시글 삭제 기능");
		mapper.boardDelete(idx);

	}

	@RequestMapping("/boardUpdate.do")
	public @ResponseBody void boardUpdate(Board vo) {
		System.out.println("게시글 수정 기능");
		mapper.boardUpdate(vo);

	}

	@RequestMapping("/joinForm.do")
	public String joinForm() {

		return "joinForm";
	}

	@RequestMapping("/join.do")
	public String join(Member vo) {

		return null;
	}
}

//
//	@RequestMapping("/replyInsert.do")
//	public String replyInsert(Reply vo) {
//		System.out.println("댓글 작성 기능");
//		mapper.replyInsert(vo);
//		return "redirect:/boardContent.do?idx=" + vo.getBoardnum();
//	}
//}
