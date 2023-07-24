package com.study.springboot;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springboot.dao.ISimpleBbsDao;

@Controller
public class MyController {

	@Autowired
	ISimpleBbsDao dao;
	
	@RequestMapping("/")
	public @ResponseBody String root() { 
		return "redirect:list";
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("list", dao.listDao());
		return "list";
	}
	@RequestMapping("/view")
	public String view(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		model.addAttribute("dto", dao.viewDao(id));
		return "view";
	}
	@RequestMapping("/delete")
	public String delete(@RequestParam("id") String id) {
		dao.deleteDao(id);
		return "redirect:list";
	}
	@RequestMapping("/writerForm")
	public void writeForm() {}
	
	@RequestMapping("/write")
		public String writer(HttpServletRequest request) {
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		Map<String, String> map = new HashMap<>();
		map.put("items1", writer);
		map.put("items2", title);
		map.put("items3", content);
		return "writeForm";
		
	}
}
