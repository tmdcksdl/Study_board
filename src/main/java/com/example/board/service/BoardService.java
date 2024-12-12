package com.example.board.service;

import com.example.board.dto.BoardResponseDto;
import com.example.board.entitiy.Board;
import com.example.board.entitiy.Member;
import com.example.board.repository.BoardRepository;
import com.example.board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    // 속성
    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;

    // 생성자


    // 기능
    public BoardResponseDto save(String title, String contents, String username) {

        Member findMember = memberRepository.findMemberByUsernameOrElseThrow(username);

        Board board = new Board(title, contents);
        board.setMember(findMember);

        Board savedBoard = boardRepository.save(board);  // save에 이미 @Transactional이 포함되어 있기 때문에 따로 사용하지 않아도 된다.

        return new BoardResponseDto(savedBoard.getId(), savedBoard.getTitle(), savedBoard.getContents());
    }
}
