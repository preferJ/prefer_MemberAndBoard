package com.prefer_memberandboard.controller;

import com.prefer_memberandboard.DTO.MemberDTO;
import com.prefer_memberandboard.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/saveForm")
    public String saveForm() {
        return "M/save";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "M/login";
    }

    @PostMapping("/saveReq")
    public String saveReq(@ModelAttribute MemberDTO memberDTO) {
        memberService.save(memberDTO);
        return "index";
    }

    @PostMapping("/loginReq")
    public String loginReq(HttpSession session, @RequestParam String memberId, @RequestParam String memberPassword) {
        MemberDTO memberDTO = memberService.findByMemberId(memberId);

        if (memberDTO == null) {
            return "M/login";
        } else {
            session.setAttribute("memberId", memberDTO.getMemberId());
            return "index";
        }
    }


    @GetMapping("/list")
    public String list(Model model) {
        List<MemberDTO> memberDTOList = memberService.findAll();
        model.addAttribute("memberDTOList", memberDTOList);
        return "M/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        MemberDTO memberDTO = memberService.findByid(id);
        System.out.println(memberDTO);
        model.addAttribute("memberDTO", memberDTO);
        return "M/detail";
    }


}
