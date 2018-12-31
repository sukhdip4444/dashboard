package com.prism.dashboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.prism.dashboard.model.ProjectTypeMast;

@Service
public class ProjectTypeMastService {
	 @Autowired
	    private JdbcTemplate jtm; 
	    public List<ProjectTypeMast> getProjects() {
	        String sql = "SELECT * FROM project_type_mast";
	        List<ProjectTypeMast> types = jtm.query(sql, new BeanPropertyRowMapper(ProjectTypeMast.class));
	        return types;
	    }
}
