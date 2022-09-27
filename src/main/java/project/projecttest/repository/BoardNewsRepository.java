package project.projecttest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import project.projecttest.domain.Board;
import project.projecttest.domain.BoardNews;

import java.util.List;

public interface BoardNewsRepository extends JpaRepository<BoardNews, Long> {

    Page<BoardNews> findByTitleContainingOrContentContaining(String title, String content, Pageable pageable);
    List<BoardNews> findAll();

}