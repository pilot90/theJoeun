package com.my.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.my.web.domain.BoardVO;
import com.my.web.domain.PageDTO;
import com.my.web.domain.Pagination;
import com.my.web.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
    @Autowired
    private BoardService boardService;
    
    /**
     * 게시판 조회
     * @param boardVO
     * @param model
     * @return
     * @throws Exception
     */
  /*  @RequestMapping(value="/list", method=RequestMethod.GET)
    public String boardList(Model model) throws Exception{               
        List<BoardVO> list = boardService.selectBoardList();
        
        model.addAttribute("list", list);
        
        return "board/boardList"; //views/board/boardList.jsp
    }*/
    
    @RequestMapping(value="/list", method=RequestMethod.GET)
    public String boardList(PageDTO dto, Model model) throws Exception {
		List<BoardVO> list = boardService.selectBoardListByPage(dto);
		/*for (BoardVO boardVO : list) {
			System.out.println(boardVO.toString());
		}*/
		Pagination pagination = new Pagination(dto);
		pagination.setTotalCnt(boardService.countBoard());
		model.addAttribute("list", list);
		model.addAttribute("paging", pagination);
		
    	return "board/boardListPage";
    }
    
    /**
     * 글쓰기 폼
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/write", method=RequestMethod.GET)
    public String writeBoardForm() throws Exception{
    	
        return "board/writeForm";
    }
    
    /**
     * 게시글 등록
     * @param boardVO
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/write", method=RequestMethod.POST)
    public String write(@ModelAttribute("boardVO") BoardVO boardVO, Model model) throws Exception{
        // model.addAttribute("boardVO", boardVO);  // @ModelAttribute("boardVO") 가 자동으로 해줌.
        boardService.insertBoard(boardVO);
        
        return "redirect:/board/list";
    }
    
    /**
     * 게시글 조회
     * @param boardVO
     * @param model
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/view", method=RequestMethod.GET)
    public String viewForm(@RequestParam("code") int code, 
    		@ModelAttribute("pdto") PageDTO pdto, Model model) throws Exception{
    
        BoardVO resultVO = boardService.selectBoardByCode(code);
        // logger.info(resultVO.toString());
        model.addAttribute("result", resultVO);
        
        return "board/view";
    }
    
    /**
     * 게시글 수정
     * @param boardVO
     * @param model
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/modify", method=RequestMethod.GET)
    public String modifyForm(@RequestParam("code") int code,
    		@ModelAttribute("pdto") PageDTO pdto, Model model) throws Exception{        
    	/**
    	 * @ModelAttribute("pdto") PageDTO pdto 
    	 * 1. PageDTO pdto (요청 파라메터 받아서 객체 생성)
    	 * 2. model.addAttribute("pdto", pdto);
    	 */
        BoardVO resultVO = boardService.selectBoardByCode(code);
        
        model.addAttribute("result", resultVO);
        
        return "board/modifyForm";
    }
    
    /**
     * 게시글 수정
     * @param boardVO
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/modify", method=RequestMethod.POST)
    public String updateBoard(@ModelAttribute("boardVO") BoardVO boardVO, 
    		PageDTO pdto, RedirectAttributes rttr) throws Exception{

        try {
        	boardService.updateBoard(boardVO);
        } catch (Exception e) {
            e.printStackTrace();
        }        
        rttr.addAttribute("page", pdto.getPage());
        rttr.addAttribute("perPage", pdto.getPerPage());
        return "redirect:/board/list";
        
    }
    
    @RequestMapping(value="/remove", method=RequestMethod.POST)
    public String removeBoard(@RequestParam("code") int code, 
    		PageDTO pdto, RedirectAttributes rttr) throws Exception {
    	 
         boardService.deleteBoard(code);
         rttr.addAttribute("page", pdto.getPage());
         rttr.addAttribute("perPage", pdto.getPerPage());
         return "redirect:/board/list";
    }
}
