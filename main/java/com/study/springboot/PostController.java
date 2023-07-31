package com.study.springboot;

import java.util.Map; 

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.study.springboot.dto.MemberDto;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {
    
    @PostMapping(value = "/domain")
    public String postExample() {
        return "Hello Post API";
    }
    //http:localhost:8081/api/v1/post-api/member
    @PostMapping(value = "/member")//requestbody 로 사용하는경우는 json으로 사용할때 쓴다 ?
    public @ResponseBody String postMember(@RequestBody Map<String, Object> postData) {
        StringBuilder sb = new StringBuilder();
        
        postData.entrySet().forEach(map ->{
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();
    }
    
    //http:localhost:8081/api/v1/post-api/member2
    @PostMapping(value="/member2")
    public String postMemberDto(@RequestBody MemberDto member) {
    	return member.toString();
    }






}
