package com.study.springboot;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.springboot.dto.MemberDto;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {
	@PutMapping(value = "/member")
	public String postMember(@RequestBody Map<String, Object> putData) {
		StringBuilder sb = new StringBuilder();
		putData.entrySet().forEach(map ->{
			sb.append(map.getKey() + " | " + map.getValue());
		});
		return sb.toString();
	}
	@PutMapping(value = "/member1")
	public String postMemberDto1(@RequestBody MemberDto member) {
		return member.toString();
	}
	@PutMapping(value = "/member2")
	public ResponseEntity<MemberDto> postMemberDto2(@RequestBody MemberDto member){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(member);
	}
}
