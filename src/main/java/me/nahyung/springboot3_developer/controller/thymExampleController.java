package me.nahyung.springboot3_developer.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
public class thymExampleController {

    @GetMapping("/thymeleaf/sample")
    public String thymeleafSample(Model model){
        User user = new User();
        user.setId(101L);
        user.setName("홍길동");
        user.setAge(25);
        user.setRoles(List.of("USER", "ADMIN"));

        model.addAttribute("user", user);
        model.addAttribute("isAdmin", true); // 관리자 여부 플래그
        model.addAttribute("items", List.of("사과", "바나나", "딸기"));
        model.addAttribute("today", LocalDate.now());

        return "sample"; // sample.html을 찾아서 렌더링
    }

    @Getter
    @Setter
    static class User {
        private Long id;
        private String name;
        private int age;
        private List<String> roles;
    }
}

