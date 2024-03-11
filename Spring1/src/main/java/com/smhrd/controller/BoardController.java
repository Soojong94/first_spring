package com.smhrd.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smhrd.entity.Board;

@Controller // 해당 클래스가 Controller 가 되기 위한 명시
public class BoardController {

	@RequestMapping("/boardList.do") // client 가 요청한 url 맵핑
	public String boardList(Model model) {
		System.out.println("게시글 전체보기 기능");
		// 게시글 정보 - 번호, 제목, 내용, 작성자, 작성일, 조회수

		Board b1 = new Board(1, "점심", "추천", "Kim", "03.11", 5);
		Board b2 = new Board(2, "저녁", "생강", "Kang", "03.11", 15);
		Board b3 = new Board(3, "어제", "대추", "Lee", "03.10", 20);
		Board b4 = new Board(4, "오늘", "전병", "Choi", "03.11", 10);
		Board b5 = new Board(5, "내일", "스프링", "Park", "03.12", 4);

		List<Board> list = new ArrayList<Board>(); // upcasting
		list.add(b1);
		list.add(b2);
		list.add(b3);
		list.add(b4);
		list.add(b5);
		
		model.addAttribute("list", list); // model이란 매개변수를 받아 list 란 이름으로 list 를 넣음

		return "boardList"; // .jsp는 안 돌려주고 이름만 돌려줌 -> resolver가 붙여줌

	}

}
