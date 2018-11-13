package com.my.web.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.my.web.domain.PageDTO;
import com.my.web.domain.Pagination;
import com.my.web.domain.QnaVO;
import com.my.web.service.QnaService;

@Controller
@RequestMapping("/qna")
public class QnaController {
	private static final Logger logger = LoggerFactory.getLogger(QnaController.class);

	@Inject
	private QnaService service;
	
	// list
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String boardList(PageDTO pdto, Model model) throws Exception {
		logger.info("목록 보기 : ==============================");
		
		List<QnaVO> list = service.selectBoardListByPage(pdto);
		
		Pagination pagination = new Pagination(pdto);
		pagination.setTotalCnt(service.countBoard());
		model.addAttribute("list", list);
		model.addAttribute("paging", pagination);
		
		return "qna/boardList";
	}
	
	// writeForm
	@RequestMapping(value="write", method=RequestMethod.GET)
	public String writeForm() throws Exception {
		logger.info("글 쓰기 폼: ==============================");
		
		return "qna/writeForm";
	}
	
	// writeAction
	@RequestMapping(value="write", method=RequestMethod.POST)
	public String writeAction(@ModelAttribute("qnaVO") QnaVO boardVO) throws Exception {
		logger.info("글 쓰기 액션: ==============================");
		
		service.insertBoard(boardVO);
		
		return "redirect:/qna/list";
	}
	
	// view
	@RequestMapping(value="view", method=RequestMethod.GET)
	public String view(@RequestParam("code") int code, 
			@ModelAttribute("pdto") PageDTO pdto, Model model) throws Exception {
		logger.info("글 읽기: ==============================");
		
		QnaVO resultVO = service.selectBoardByCode(code);
		model.addAttribute("result", resultVO);
		
		return "qna/view";
		
	}
	
	// modifyForm
	@RequestMapping(value="modify", method=RequestMethod.GET)
	public String modifyForm(@RequestParam("code") int code, 
			@ModelAttribute("pdto") PageDTO pdto, Model model) throws Exception {
		/*
		 *  @ModelAttribute("pdto") PageDTO pdto
		 *  1. PageDTO pdto (요청 파라메터 받아서 객체 생성)
		 *  2. model.addAttribute("pdto", pdto);
		 */
		logger.info("글 수정 폼: ==============================");
		
		QnaVO resultVO = service.selectBoardByCode(code);
		model.addAttribute("result", resultVO);
		
		return "qna/modifyForm";
	}
	
	// modifyAction
	@RequestMapping(value="modify", method=RequestMethod.POST)
	public String modifyAction(@ModelAttribute("qnaVO") QnaVO boardVO, 
			PageDTO pdto, RedirectAttributes rttr) throws Exception {
		logger.info("글 수정 액션: ==============================");
		
		try {
			service.updateBoard(boardVO);
		} catch(Exception e) {
			e.printStackTrace();
		}
		rttr.addAttribute("page", pdto.getPage());
		rttr.addAttribute("perPage", pdto.getPerPage());
		return "redirect:/qna/list";
	}
	
	// answerForm
	@RequestMapping(value="answer", method=RequestMethod.GET)
	public String answerForm() throws Exception {
		logger.info("답글 쓰기 폼: ==============================");
		
		return "qna/answerForm";
		
	}
	
	// answerAction
	@RequestMapping(value="answer", method=RequestMethod.POST)
	public String answerAction(@ModelAttribute("qnaVO") QnaVO boardVO, Model model) throws Exception {
		/**
    	 * @ModelAttribute("qnaVO") QnaVO boardVO 
    	 * 1. QnaVO boardVO (요청 파라메터 받아서 객체 생성)
    	 * 2. model.addAttribute("qnaVO", qnaVO);
    	 */
		logger.info("답글 쓰기 액션: ==============================");
		service.insertAnswer(boardVO);
		
		return "redirect:/qna/list";
	}
	
	// remove
	@RequestMapping(value="remove", method=RequestMethod.POST)
	public String remove(@RequestParam("code") int code, 
			PageDTO pdto, RedirectAttributes rttr) throws Exception {
		logger.info("글 삭제: ==============================");
		
		service.deleteBoard(code);
		rttr.addAttribute("page", pdto.getPage());
		rttr.addAttribute("perPage", pdto.getPerPage());
		
		return "redirect:/qna/list";
	}
}
