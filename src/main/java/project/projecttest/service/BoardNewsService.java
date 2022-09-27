package project.projecttest.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.projecttest.domain.Board;
import project.projecttest.domain.BoardNews;
import project.projecttest.dto.BoardNewsDto;
import project.projecttest.repository.BoardNewsRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardNewsService {

    private final BoardNewsRepository boardNewsRepository;

    @Transactional
    public Long saveBoardNews(BoardNewsDto boardNewsDto) {
        boardNewsRepository.save(boardNewsDto.toEntity());
        return boardNewsDto.getId();
    }

    public List<BoardNews> findAll() {
        return boardNewsRepository.findAll();
    }

    @Transactional
    public Page<BoardNews> getBoardList(Pageable pageable) {

        return boardNewsRepository.findAll(pageable);

    }

    public Page<BoardNews> paging(int page) {
        return boardNewsRepository.findAll(PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "id")));

    }

//    @Transactional
//    public void updateVisit(Long id, BoardNewsDto boardNewsDto) {
//        BoardNews boardNews = boardNewsRepository.findById(id).orElseThrow((() ->
//                new IllegalStateException("해당 게시글이 존재하지 않습니다.")));
//    }

    public BoardNews findById(Long id){
        BoardNews boardNews = boardNewsRepository.findById(id).get();
        return boardNews;
    }

//    @Transactional
//    public Long BeforeCountVisitLogic(Long id) {
//
//        Board board = boardRepository.findById(id).orElseThrow((() ->
//                new IllegalStateException("해당 게시글이 존재하지 않습니다.")));
//
//        board.updateVisit(countVisitStore.get());
//        sleep(100);
//
//    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

