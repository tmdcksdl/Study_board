package com.example.board.service;

import com.example.board.dto.SignUpResponseDto;
import com.example.board.entitiy.Member;
import com.example.board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor  // MemberRepository 생성자를 주입받기 위해 사용한다.
public class MemberService {  // 확장될 이유가 없다면 구현체 클래스를 그대로 사용해도 된다. 변경이나 확장될 여지가 있다면 인터페이스로 설계해야 한다.

    // 속성
    private final MemberRepository memberRepository;

    // 생성자


    // 기능
    public SignUpResponseDto signUp(String username, String password, Integer age) {

        Member member = new Member(username, password, age);

        Member savedMember = memberRepository.save(member);  // 저장한 member를 반환받을 수 있다.

        return new SignUpResponseDto(savedMember.getId(), savedMember.getUsername(), savedMember.getAge());
    }
}
