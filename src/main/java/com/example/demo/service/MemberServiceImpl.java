package com.examly.springapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.examly.springapp.model.Member;

@Service
public class MemberServiceImpl implements MemberService {

    private static List<Member> members = new ArrayList<>();
    private static long idCounter = 1;

    @Override
    public Member addMember(Member member) {
        member.setMemberId(idCounter++);
        members.add(member);
        return member;
    }

    @Override
    public List<Member> getAllMembers() {
        return members;
    }

    @Override
    public Member getMemberById(int id) {
        return members.stream()
                .filter(m -> m.getMemberId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Member updateMember(int id, Member updatedMember) {
        for (Member member : members) {
            if (member.getMemberId() == id) {
                member.setName(updatedMember.getName());
                member.setPhone(updatedMember.getPhone());
                member.setEmail(updatedMember.getEmail());
                return member;
            }
        }
        return null;
    }

    @Override
    public List<Member> getMembersByPhone(String phone) {
        return members.stream()
                .filter(m -> m.getPhone().equals(phone))
                .collect(Collectors.toList());
    }

    @Override
    public List<Member> getMembersByEmail(String email) {
        return members.stream()
                .filter(m -> m.getEmail().equalsIgnoreCase(email))
                .collect(Collectors.toList());
    }
}
