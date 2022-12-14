package com.example.manageMember.controller;

import com.example.manageMember.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    //@Autowired private MemberService memberService;
    private MemberService memberService;

    @Autowired
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }

//    @Autowired
//    public MemberController(MemberService memberService) {
//        this.memberService = memberService;
//    }
    // 생성자에 @Autowired 어노테이션을 불여주면, 스프링 컨테이너에 있는 memberService 스프링이 연결해준다.
    // 위와 같은 작업이 가능한 전제 조건은 MemberService가 스프링 컨테이너에 의해 관리되고 있어야 한다는 점이다.
    // 때문에 해당 MemberService클래스 위에는 @Service 어노테이션을 붙여주어야 한다.
    // 일반적으로 @Service, @RestController, @Controller, @Repository 등의 어노테이션이 존재한다.
    // 기본적으로 @Component 라는 어노테이션을 통해 스프링 빈에 자동 등록이 되는데, @Controller, @Service, @Repository는 @Component를 포함하고 있기 때문에 해당 어노테이션을 통해서도 스프링 빈에 등록이 되게 된다..
    // 최상단에 public static void main을 실행하는 Application 클래스의 하위 구조에서 가능한다.
    // 또한 스프링 컨테이너에 등록되는 각 클래스들은 싱글턴 패턴을 취하여, 각 1개의 클래스들만 등록되어 프로젝트에서 공유된다. 이는 메모리를 절약해준다.

    /**
     * 스프링 빈을 등록하는 두 가지 방식
     *  빈(Bean)이란 ?
     *  1. 컴포넌트 스캔을 통한 자동 의존관계 설정 방식
     *  이는 앞서 설명하였던 것으로, 어노테이션 등을 사용하는 방식이다.
     *  2. 자바 코드를 통해 직업 스프링 빈을 등록하는 방식
     * */
}
