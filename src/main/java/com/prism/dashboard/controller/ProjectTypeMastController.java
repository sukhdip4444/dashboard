package com.prism.dashboard.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.prism.dashboard.model.ProjectTypeMast;
import com.prism.dashboard.repo.ProjectTypeMastRepo;
import com.prism.dashboard.service.ProjectTypeMastService;

@Controller
@RequestMapping("/")
public class ProjectTypeMastController {
	
	@Autowired
	ProjectTypeMastRepo repository;
	
	@Autowired
	ProjectTypeMastService service;
	
	/*
	@RequestMapping("/getdata")
	public ModelAndView getData() {
		ModelAndView mv=new ModelAndView("dashboard.html"); 
		ProjectTypeMast data=repository.findById(1).orElse( new ProjectTypeMast());
		mv.addObject(data);
		return mv;
		
	}
	*/
	
	@RequestMapping("/getdata")
	public ModelAndView  getData() {
		ModelAndView mv=new ModelAndView(); 
		//Iterable<ProjectTypeMast> data = repository.findAll();
		
		List<ProjectTypeMast> data2=new ArrayList<>();
		repository.findAll().forEach(data2::add);
		int count=data2.size();
		//ProjectTypeMast data= repository.findById(1).orElse(new ProjectTypeMast());
		mv.addObject("data",data2);
		mv.addObject("count",count);
		mv.setViewName("dashboard.html");
		return mv;
		
	}
	
	@RequestMapping("/getdata2")
	public ModelAndView getData2() {
		ModelAndView mv=new ModelAndView();
		List<ProjectTypeMast> data=service.getProjects();
		
		/*convert data into json format
		 Gson gson = new Gson();
		 String jsonData = gson.toJson(data);
		*/
		
		mv.addObject("data2",data);
		mv.setViewName("dashboard.html");
		return mv;
	}
	
	
	


}
 