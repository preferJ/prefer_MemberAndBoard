package com.prefer_memberandboard.Entity;

import com.prefer_memberandboard.DTO.MemberDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "member_table")
public class MemberEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String memberId;
    @Column
    private String memberPassword;
    @Column
    private String memberName;
    @Column
    private String memberEmail;
    @Column
    private String memberMobile;
    @Column
    private String memberProfile;


    public static MemberEntity toSaveEntity(MemberDTO memberDTO) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setId(memberDTO.getId());
        memberEntity.setMemberId(memberDTO.getMemberId());
        memberEntity.setMemberPassword(memberDTO.getMemberPassword());
        memberEntity.setMemberName(memberDTO.getMemberName());
        memberEntity.setMemberEmail(memberDTO.getMemberEmail());
        memberEntity.setMemberMobile(memberDTO.getMemberMobile());
        memberEntity.setMemberProfile(memberDTO.getMemberProfile());
        return memberEntity;
    }


}
