package com.study.service;

import com.study.dto.MemberFormDTO;
import com.study.entity.Member;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
@Log4j2
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void createMemberTest(){
        MemberFormDTO memberFormDTO =  MemberFormDTO.builder()
                .email("test@email.com")
                .name("홍길동")
                .address("서울시 마포구 합정동")
                .password("1234")
                .build();
        Member member = Member.createMember(memberFormDTO, passwordEncoder);
        memberService.saveMember(member);
    }

}