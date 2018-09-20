package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping("/viral")
	public String index() {
		return "viral";
	}
	
	@RequestMapping("/challenge")
	public String challenge(@RequestParam(value="name",required=false) String name, Model model) {
		model.addAttribute("name",name);
		return "challenge";
	}
	
	@RequestMapping("/challenge/{name}")
	public String challengePath(@PathVariable String name, Model model) {
		model.addAttribute("name",name);
		return "challenge";
	}
	
	@RequestMapping("/generator")
	public String generator(
			@RequestParam(value="a",required=false,defaultValue="0") String a,
			@RequestParam(value="b",required=false,defaultValue="0") String b,
			Model model
			) {
		model.addAttribute("a",a);
		model.addAttribute("b",b);
		int x = 1;
		int y = 1;
		if (Integer.parseInt(a)!=0) {
			x=Integer.parseInt(a);
		}
		if (Integer.parseInt(b)!=0) {
			y=Integer.parseInt(b);
		}
		String out = "";
		String temp = "h";
		for (int w=0;w<x;w++) {
			temp+="m";
		}
		for (int s=0;s<y;s++) {
			out+=temp+" ";
		}
		model.addAttribute("hasil",out);
		return "generator";
	}
	
}
