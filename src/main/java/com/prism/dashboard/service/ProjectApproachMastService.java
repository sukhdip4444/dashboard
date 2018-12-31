package com.prism.dashboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.prism.dashboard.model.ProjectApproachMastModel;


@Service
public class ProjectApproachMastService {
	 @Autowired
	    private JdbcTemplate jtm;

	    
	    public List<ProjectApproachMastModel> getProjects() {

	        String sql = "SELECT * FROM approach_mast";

	        List<ProjectApproachMastModel> types = jtm.query(sql, new BeanPropertyRowMapper(ProjectApproachMastModel.class));

	        return types;
	    }
}
