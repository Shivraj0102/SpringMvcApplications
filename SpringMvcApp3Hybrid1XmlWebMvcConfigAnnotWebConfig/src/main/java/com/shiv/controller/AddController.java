package com.shiv.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddController {

	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@RequestMapping("/add")
	public ModelAndView addNum(HttpServletRequest request, HttpServletResponse response) {
		Integer n1 = Integer.parseInt(request.getParameter("n1"));
		Integer n2 = Integer.parseInt(request.getParameter("n2"));
		Integer sum = n1 + n2;
		ModelAndView mv = new ModelAndView();
		mv.addObject("sum", sum);
		mv.setViewName("display");
		return mv;
	}

	@RequestMapping("/subtract")
	public ModelAndView subtract(Integer n1, Integer n2) {
		Integer sub = n1 - n2;
		ModelAndView mv = new ModelAndView();
		mv.addObject("sum", sub);
		mv.setViewName("display");
		return mv;
	}
}
