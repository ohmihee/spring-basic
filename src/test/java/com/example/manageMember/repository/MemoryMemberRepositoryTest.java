package com.example.manageMember.repository;

import com.example.manageMember.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class MemoryMemberRepositoryTest {
    // 테스트는 의존관계 상관없이 설계되기 때문에 테스트시마다 store를 clear해준다.
    // TDD (Test Drivend Development : 테스트 주도 개발) : 테스트와 같은 틀을 먼저 만들고 개발이 진행되는 것.
    MemoryMemberRepository respository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        respository.clearStore();
    }
    @Test
    public void save() {
        //
        Member member = new Member();
        member.setName("spring");
        respository.save(member);
        Member result = respository.findById(member.getId()).get();
        System.out.println("result = "+(result == member));
        //Assertions.assertEquals(member, result);
        //Assertions.assertEquals(member, null);
        //assertThat(member).isEqualTo(result);
        assertThat(result).isEqualTo(null);
        // null 이면

    }

    @Test public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        respository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        respository.save(member2);

        Member result = respository.findByName("spring2").get();

        assertThat(result).isEqualTo(member1);
        // 동일한 이름이 존재하는 경우 test failed
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        respository.save(member1);

        Member member2 = new Member();
        member1.setName("spring2");
        respository.save(member1);

        List<Member> result = respository.findAll();

        assertThat(result.size()).isEqualTo(3);
    }
}