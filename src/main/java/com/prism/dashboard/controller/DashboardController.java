package com.prism.dashboard.controller;

import java.util.List;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.prism.dashboard.model.CostWiseProjectSubmittedModel;
import com.prism.dashboard.model.DropdownDataModel;
import com.prism.dashboard.model.HodStatusModel;
import com.prism.dashboard.model.HostingStatisticsModel;
import com.prism.dashboard.model.MonthWiseProjects;
import com.prism.dashboard.model.NumberOfMeetingsModel;
import com.prism.dashboard.model.PacStatusModel;
import com.prism.dashboard.model.ProjectTypeMast;
import com.prism.dashboard.model.StateWisePojectsModel;
import com.prism.dashboard.service.GeneratePdfReport;
import com.prism.dashboard.service.PacStatusService;

@Controller
@RequestMapping("/")
public class DashboardController {
	@Autowired
	PacStatusService service;
	
	@RequestMapping("/dashboard")
	public ModelAndView getData() {
		ModelAndView mv=new ModelAndView();
		List<PacStatusModel> data=service.getData();
		List<HostingStatisticsModel> hostingData=service.getHostingStatstics();
		List<HodStatusModel> hodData=service.getHodWiseStaus();
		List<CostWiseProjectSubmittedModel> costWiseData=service.getCostWiseProjects();
		List<StateWisePojectsModel> stateWiseData=service.getStateWiseProjects();
		List<MonthWiseProjects> monthWiseData=service.getMonthWiseProjects();
		List<DropdownDataModel> dropdownData=service.getDropdownData();
	//	List<DropdownDataModel> dropdownProjectData=getProjectData(@RequestParam("id") int id);
		
		//convert data into json format
		Gson gson = new Gson();
		 String jsonData = gson.toJson(hodData);
		
		
		//System.out.println(jsonData);
		
		mv.addObject("data",data);
		mv.addObject("hostingData",hostingData);
		mv.addObject("hodData",hodData);
		mv.addObject("costWiseData",costWiseData);
		mv.addObject("stateWiseData",stateWiseData);
		mv.addObject("monthWiseData",monthWiseData);
		mv.addObject("dropdownData",dropdownData);
		mv.setViewName("dashboard.html");
		return mv;
	}
	
	@RequestMapping("/dashboard/{id}")
	public List<DropdownDataModel> getProjectData(@RequestParam("id") int id){
		List<DropdownDataModel> data=service.getDropdownProjectData(id);
		return data;
	}
	
	
	@RequestMapping("/dashboard/")
	public List<NumberOfMeetingsModel> getProjectId(@RequestParam("project_id") int id) {
		List<NumberOfMeetingsModel> data= service.getMeetings(id);
		Gson gson = new Gson();
		 String jsonData = gson.toJson(data);

		//System.out.println(jsonData);
	
		return data;
	}
	
	@RequestMapping(value="/pdfReportPieChart1", method=RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> pacStatusReport() throws IOException {

		List<PacStatusModel> data=service.getData();

        ByteArrayInputStream bis = GeneratePdfReport.pacStatusReport(data);

        HttpHeaders headers = new HttpHeaders();
        		headers.add("Content-Disposition", "inline; filename=pacStatusReport.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}
