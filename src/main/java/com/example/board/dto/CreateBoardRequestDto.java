package com.example.board.dto;

import lombok.Getter;

@Getter
public class CreateBoardRequestDto {

    // 속성
    private final String title;

    private final String contents;

    private final String username;  // 어떤 회원이 작성했는지 요청 정보에 담겨있어야 한다.

    // 생성자
    public CreateBoardRequestDto(String title, String contents, String username) {
        this.title = title;
        this.contents = contents;
        this.username = username;
    }


    // 기능
}
