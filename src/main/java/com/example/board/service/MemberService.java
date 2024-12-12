package com.example.board.service;

import com.example.board.dto.MemberResponseDto;
import com.example.board.dto.SignUpResponseDto;
import com.example.board.entitiy.Member;
import com.example.board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

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

    public MemberResponseDto findById(Long id) {

        Optional<Member> optionalMember = memberRepository.findById(id);// JpaRepository에 이미 구현되어 있는 메서드이다..!

        if (optionalMember.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id : " + id);  // NOT_FOUND로 할거면 게속 NOT_FOUND로 하고, 204를 사용할거면 계속 204 사용한다.
        }

        Member findMember = optionalMember.get();

        return new MemberResponseDto(findMember.getUsername(), findMember.getAge());
    }

    @Transactional  // 해당 범위 내 메서드가 트랜잭션이 되도록 보장해준다.
    public void updatePassword(Long id, String oldPassword, String newPassword) {

        Member findMember = memberRepository.findByIdOrElseThrow(id);  // findByIdOrElseThrow를 사용하지 않으면 Optional 객체가 비어있는지 계속해서 확인해줘야 한다.

        if (!findMember.getPassword().equals(oldPassword)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다.");
        }

        findMember.updatePassword(newPassword);
    }
}
