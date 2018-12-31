package com.prism.dashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.prism.dashboard.model.ProjectApproachMastModel;
import com.prism.dashboard.model.ProjectTypeMast;
import com.prism.dashboard.service.ProjectApproachMastService;
import com.prism.dashboard.service.ProjectTypeMastService;

@Controller
public class ProjectApproachMastController {
	@Autowired
	ProjectApproachMastService service;
	
	@RequestMapping("/getdata3")
	public ModelAndView getData3() {
		ModelAndView mv=new ModelAndView();
		List<ProjectApproachMastModel> data=service.getProjects();
		mv.addObject("data",data);
		mv.setViewName("dashboard.html");
		return mv;
	}

}
