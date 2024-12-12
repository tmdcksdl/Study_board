package com.example.board.controller;

import com.example.board.dto.BoardResponseDto;
import com.example.board.dto.CreateBoardRequestDto;
import com.example.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

    // 속성
    private final BoardService boardService;

    // 생성자


    // 기능
    @PostMapping
    public ResponseEntity<BoardResponseDto> save(@RequestBody CreateBoardRequestDto requestDto) {

        BoardResponseDto boardResponseDto = boardService.save(
                requestDto.getTitle(),
                requestDto.getContents(),
                requestDto.getUsername()
        );

        return new ResponseEntity<>(boardResponseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BoardResponseDto>> findAll() {

        List<BoardResponseDto> boardResponseDtoList = boardService.findAll();

        return new ResponseEntity<>(boardResponseDtoList, HttpStatus.OK);
    }
}
