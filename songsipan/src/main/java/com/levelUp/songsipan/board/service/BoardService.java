package com.levelUp.songsipan.board.service;

import com.levelUp.songsipan.board.dto.BoardInputDto;
import com.levelUp.songsipan.board.dto.BoardUpdateDto;
import com.levelUp.songsipan.board.entity.BoardEntity;
import com.levelUp.songsipan.board.repository.BoardRepository;
import com.levelUp.songsipan.user.entity.UserEntity;
import com.levelUp.songsipan.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Transactional
public class BoardService {

    private BoardRepository boardRepository;
    private UserRepository userRepository;

    //게시글 조회
    public BoardEntity fetch(String id) {
        BoardEntity boardEntity = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("에러 그만할래.."));
        return boardEntity;
    }

    //게시글 작성
    public BoardEntity create(BoardInputDto boardInputDto) {

        UserEntity userEntity = userRepository.findById(boardInputDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("사용자 조회가 안 되어요."));

        BoardEntity boardEntity = new BoardEntity();

        boardEntity.setUserId(boardInputDto.getUserId());
        boardEntity.setTitle(boardInputDto.getTitle());
        boardEntity.setDetail(boardInputDto.getDetail());

        return boardRepository.save(boardEntity);
    }

    //게시글 수정
    public BoardEntity update(BoardUpdateDto boardUpdateDto) {
        BoardEntity boardEntity = boardRepository.findById(boardUpdateDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수가 없어요."));
        boardEntity.setTitle(boardEntity.getTitle());
        boardEntity.setDetail(boardEntity.getDetail());

        return boardEntity;
    }

    //게시글 삭제
    public void delete(String id) {
        BoardEntity boardEntity = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수가 없어요."));
        boardRepository.delete(boardEntity);
    }
}
