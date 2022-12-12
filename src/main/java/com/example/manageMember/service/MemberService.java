package com.example.manageMember.service;

import com.example.manageMember.domain.Member;
import com.example.manageMember.repository.MemberRespository;
import com.example.manageMember.repository.MemoryMemberRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRespository memberRespository = new MemoryMemberRepository();
    /** 회원 가입 ================================*/
    public Long join(Member member) {
        // 동일한 이름의 중복 회원 검증
//        Optional<Member> result = memberRespository.findByName(member.getName());
//        result.ifPresent(m -> {
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });
        validateDuplicateMember(member);
        // 보통은 따로 에러처리롤 분리한다.
        // 메서드로 만들어내는 방법 해당 부분을 영역지정한 상태로, ctrl + t 하고 extract method 선택
        // 또는 option + command + m 클릭
        memberRespository.save(member);
        return member.getId();
    }
    private void validateDuplicateMember(Member member) {
        memberRespository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /** 전체 회원 조회 =============================*/
    public List<Member> findMembers() {
        return memberRespository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRespository.findById(memberId);
    }
}
