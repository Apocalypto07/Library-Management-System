package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.model.Member;

public interface MemberService {

    Member addMember(Member member);

    List<Member> getAllMembers();

    Member getMemberById(int id);

    Member updateMember(int id, Member member);

    List<Member> getMembersByPhone(String phone);

    List<Member> getMembersByEmail(String email);
}
