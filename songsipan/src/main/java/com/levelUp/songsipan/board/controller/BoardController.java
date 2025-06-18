package com.levelUp.songsipan.board.controller;

import com.levelUp.songsipan.board.dto.BoardInputDto;
import com.levelUp.songsipan.board.dto.BoardUpdateDto;
import com.levelUp.songsipan.board.entity.BoardEntity;
import com.levelUp.songsipan.board.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class BoardController {

    private BoardService boardService;

    @GetMapping("/board")
    public BoardEntity fetchBoard(@RequestParam String id) {
        return boardService.fetch(id);
    }

    @PostMapping("/board")
    public BoardEntity createBoard(@RequestBody BoardInputDto boardInputDto) {
        return boardService.create(boardInputDto);
    }

    @PutMapping("/board")
    public BoardEntity updateBoard(@RequestBody BoardUpdateDto boardUpdateDto) {
        return boardService.update(boardUpdateDto);
    }

    @DeleteMapping("/board")
    public void deleteBoard(@RequestParam String id) {
        boardService.delete(id);
    }
}
