package com.smhrd.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smhrd.entity.Board;
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

	@RequestMapping("/boardList.do") // client 가 요청한 url 맵핑
	public String boardList(Model model)
	// new Model 로 생성하지 않음 -> Dependency Injection : IOC 때문에 가능한 개념
	{
		System.out.println("게시글 전체보기 기능");
		// 게시글 정보 - 번호, 제목, 내용, 작성자, 작성일, 조회수
		List<Board> list = mapper.boardList();

		model.addAttribute("list", list); // model이란 매개변수를 받아 list 란 이름으로 list 를 넣음

		return "boardList"; // .jsp는 안 돌려주고 이름만 돌려줌 -> resolver가 붙여줌

	}

	@RequestMapping("/boardContent.do")
	public String boardContent(@RequestParam("idx") int idx, Model model) {
		System.out.println("게시글 상세보기 기능");
		Board vo = mapper.boardContent(idx);
		model.addAttribute("vo", vo);

		return "boardContent";

	}

	@RequestMapping("/boardForm.do")
	public String boardForm() {
		System.out.println("게시물 쓰기 페이지 이동기능");
		return "boardForm";
	}

	@RequestMapping("/boardInsert.do")
	public String boardInsert(Board vo) {

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
		mapper.boardInsert(vo);

		return "redirect:/boardList.do";
	}

	@RequestMapping("/boardDelete.do")
	public String boardDelete(@RequestParam("idx") int idx) {
		System.out.println("게시글 삭제 기능");
		mapper.boardDelete(idx);
		return "redirect:/boardList.do";
	}

	@RequestMapping("/boardUpdateForm.do")
	public String boardUpdateForm(@RequestParam("idx") int idx, Model model) {
		System.out.println("게시글 수정 페이지 이동 기능");
		Board vo = mapper.boardContent(idx);
		model.addAttribute("vo", vo);
		return "boardUpdateForm";
	}
}
