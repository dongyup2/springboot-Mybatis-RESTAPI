package com.study.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.springboot.dto.MemberDto;

import java.util.Map;

@RestController // view를 안쓸때
@RequestMapping("/api/v1/get-api")
public class GetController {
    @RequestMapping(value="/hello", method=RequestMethod.GET)
    public String getHello(){
        return "Hello world";        
    }
    
    @GetMapping(value="/name")
    public String getName() {
        return "James";
    }
    
    @GetMapping(value="/variable1/{variable}")
    public String getVariable(@PathVariable String variable) {
        return variable;
    }
    
    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var) {
        return var;
    }
    
    @GetMapping(value="/request1")
    public String getRequestParam1(@RequestParam String name,@RequestParam String email,@RequestParam String organization) {
        return name + "|" + email + "|" + organization;
    }
    
    @GetMapping(value="/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param) {
        StringBuilder sb = new StringBuilder();
        
        param.entrySet().forEach(map ->{
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();
    }
    //http://localhost:8081/api/v1/get-api/request3?key1=aaa&key2=bbb
    @GetMapping(value="/request3")
    public String getRequestParam3(MemberDto member) { 
    	
    	return member.toString();
    }
    

}
