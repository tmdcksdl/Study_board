package com.example.board.repository;

import com.example.board.entitiy.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


public interface MemberRepository extends JpaRepository<Member, Long> {  // Long은 id의 타입이다.

    default Member findByIdOrElseThrow(Long id) {
        return findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Does not exist id : " + id
                        )
                );
    }
}
