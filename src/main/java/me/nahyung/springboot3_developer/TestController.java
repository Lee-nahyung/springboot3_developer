package me.nahyung.springboot3_developer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    //@GetMapping("/test")
    //public String test(){
    //    return "Hello, world!";
    //}
    @Autowired
    TestService testService;    //TestService 빈 주입

    @GetMapping("/test")
    public List<Member> getAllMembers(){
        List<Member> members = testService.getAllMembers();
        return members;
    }
}
