package project.projecttest.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.projecttest.domain.Board;
import project.projecttest.domain.BoardNews;
import project.projecttest.dto.BoardDto;
import project.projecttest.dto.BoardNewsDto;
import project.projecttest.repository.BoardNewsRepository;
import project.projecttest.repository.BoardRepository;
import project.projecttest.service.BoardNewsService;
import project.projecttest.service.BoardService;

@Controller
@AllArgsConstructor
@RequestMapping("/board_news")
public class BoardNewsController {

    private final BoardNewsService boardNewsService;
    private final BoardNewsRepository boardNewsRepository;

    @GetMapping("/boardForm")
    public String addBoard() {
        return "/board_news/boardForm";
    }

    //
    @PostMapping("/boardForm")
    public String createBoard(@ModelAttribute BoardNewsDto boardNewsDto, Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = (UserDetails) principal;
        String username = userDetails.getUsername();
        boardNewsDto.setCreatedBy(username);
        boardNewsService.saveBoardNews(boardNewsDto);

        return "redirect:/board_news/boardList";
    }


    @GetMapping("/boardList")
    public String boardList(Model model, @PageableDefault(size = 10) Pageable pageable,
                            @RequestParam(required = false, defaultValue = "") String searchText) {

        Page<BoardNews> boards = boardNewsRepository.findByTitleContainingOrContentContaining(searchText, searchText, pageable);
        int startPage = Math.max(1, boards.getPageable().getPageNumber() - 1);
        int endPage = Math.min(boards.getTotalPages(), boards.getPageable().getPageNumber() + 3);


        model.addAttribute("boards", boards);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        return "board_news/boardList";
    }

    @GetMapping("/boardContent/{id}")
    public String boardContent(@PathVariable("id") Long id, Model model) {
        BoardNews boardNews = boardNewsRepository.findById(id).get();
        System.out.println("board = " + boardNews);
        model.addAttribute(boardNews);
        return "/board_news/boardContent";
    }
}
