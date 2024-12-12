package com.example.board.entitiy;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity  // @Entity Annotation이 붙어있는 클래스는 기본 생성자가 필요하다.
@Table(name = "member")
public class Member extends BaseEntity{

    // 속성
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // MySQL을 사용하기 때문에 IDENTITY를 사용한다!
    private Long id;

    @Column(nullable = false, unique = true)  // 필수이기 때문에 nullable을 false로 설정한다. 유일해야 하기 때문에 unique를 true로 설정한다.
    private String username;

    @Column(nullable = false)  // 필수이기 때문에 nullable을 false로 설정한다.
    private String password;

    private Integer age;  // 추가 조건이 없기 때문에 @Column을 생략해도 된다. null이 허용된다.

    // 기본생성자
    public Member() {}

    // 생성자 -> id는 자동으로 생성되므로 추가하지 않아도 된다.
    public Member(String username, String password, Integer age) {
        this.username = username;
        this.password = password;
        this.age = age;
    }

    // 기능
    public void updatePassword(String password) {
        this.password = password;
    }
}
