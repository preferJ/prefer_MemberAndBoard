package com.prefer_memberandboard.service;

import com.prefer_memberandboard.DTO.MemberDTO;
import com.prefer_memberandboard.Entity.MemberEntity;
import com.prefer_memberandboard.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.patterns.DeclareTypeErrorOrWarning;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public void save(MemberDTO memberDTO) {
        memberRepository.save(MemberEntity.toSaveEntity(memberDTO));
    }

    public MemberDTO findByMemberId(String memberId) {
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findByMemberId(memberId);
        System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★");
        System.out.println(optionalMemberEntity.isPresent());
        System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★");
        if (optionalMemberEntity.isPresent()) {
            return MemberDTO.toSaveDTO(optionalMemberEntity.get());
        } else {
            return null;
        }
    }

    public List<MemberDTO> findAll() {
        List<MemberEntity> memberEntityList = memberRepository.findAll();
        List<MemberDTO> memberDTOList = new ArrayList<>();
        for (MemberEntity memberEntity : memberEntityList) {
            memberDTOList.add(MemberDTO.toSaveDTO(memberEntity));
        }
        return memberDTOList;
    }

    public MemberDTO findByid(Long id) {
        return MemberDTO.toSaveDTO(memberRepository.findById(id).get());
    }
}
