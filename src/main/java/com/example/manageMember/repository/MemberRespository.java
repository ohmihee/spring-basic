package com.example.manageMember.repository;

import com.example.manageMember.domain.Member;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface MemberRespository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    // 타입에 null이 추가된 것, 즉 값이 null일 가능성이 있는 경우에 사용된다.
    List<Member> findAll();
}
