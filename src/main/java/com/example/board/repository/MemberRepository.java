package com.example.board.repository;

import com.example.board.entitiy.Member;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member, Long> {  // Long은 id의 타입이다.


}
