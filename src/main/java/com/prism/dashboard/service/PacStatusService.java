package com.prism.dashboard.service;

import java.sql.Array;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

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

@Service
public class PacStatusService {
	 @Autowired
	    private JdbcTemplate jtm; 
	    public List<PacStatusModel> getData() {
	        String sql = "select status_mast.status_desc,count(*) from prism.project_mast\r\n" + 
	        		"inner join prism.status_mast on status_mast.id=project_mast.status_id\r\n" + 
	        		"group by status_mast.status_desc";
	        List<PacStatusModel> types = jtm.query(sql, new BeanPropertyRowMapper(PacStatusModel.class));
	        return types;
	    }
	    
	    public List<HostingStatisticsModel> getHostingStatstics(){
	    	String sql="SELECT proj_params->>'hosting' as hosting,count(*) FROM prism.project_mast group by hosting";
	    	List<HostingStatisticsModel> types=jtm.query(sql, new BeanPropertyRowMapper(HostingStatisticsModel.class));
	    	return types;
	    }
	    
	    public List<HodStatusModel> getHodWiseStaus(){
	    	String sql="SELECT user_hod->>'name' as hod,count(*) FROM prism.project_mast group by hod;";
	    	List<HodStatusModel> types=jtm.query(sql, new BeanPropertyRowMapper(HodStatusModel.class));
	    	return types;
	    }
	    
	    public List<NumberOfMeetingsModel> getMeetings(int id){
	    	String sql="select count(*) from prism.meeting_details where id="+id+" group by id";
	    	List<NumberOfMeetingsModel> count=jtm.query(sql, new BeanPropertyRowMapper(NumberOfMeetingsModel.class));
	    	return count;
	    }
	    
	    public List<CostWiseProjectSubmittedModel> getCostWiseProjects(){
	    	String sql="select public.state_mast.state_name, sum(proj_cost_total) from prism.project_mast inner join public.state_mast on public.state_mast.state_code=prism.project_mast.state_code group by public.state_mast.state_name";
	    	List<CostWiseProjectSubmittedModel> data=jtm.query(sql, new BeanPropertyRowMapper(CostWiseProjectSubmittedModel.class));
	    	return data;
	    }
	    
	    public List<StateWisePojectsModel> getStateWiseProjects(){
	    	String sql="select public.state_mast.state_name, count(*) from prism.project_mast inner join public.state_mast on public.state_mast.state_code=prism.project_mast.state_code\r\n" + 
	    			"group by public.state_mast.state_name";
	    	List<StateWisePojectsModel> data=jtm.query(sql, new BeanPropertyRowMapper(StateWisePojectsModel.class));
	    	return data;
	    }
	    
	    public  List<MonthWiseProjects> getMonthWiseProjects(){
	    	String sql="SELECT extract(month from project_sancation_details.proj_submission_date) as month, count(*) FROM prism.project_sancation_details GROUP BY month;";
	    	List<MonthWiseProjects> data=jtm.query(sql, new BeanPropertyRowMapper(MonthWiseProjects.class));
	    	return data;
	    }
	    
	    public List<DropdownDataModel> getDropdownData(){
	    	String sql="select project_mast.id,project_mast.title from prism.project_mast;";
	    	List<DropdownDataModel> data=jtm.query(sql, new BeanPropertyRowMapper(DropdownDataModel.class)); 
	    	return data;
	    }
	    
	    public List<DropdownDataModel> getDropdownProjectData(int id){
	    	String sql="select id,title,proj_desc,proj_duration,proj_start_date,proj_end_date,proj_cost_total from prism.project_mast where id="+id;
	    	List<DropdownDataModel> data=jtm.query(sql, new BeanPropertyRowMapper(DropdownDataModel.class)); 
	    	return data;
	    }
}
