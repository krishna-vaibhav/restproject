package com.yash.ppmtool.serviceimpl;

import com.yash.ppmtool.dao.BacklogDao;
import com.yash.ppmtool.dao.ProjectDAO;
import com.yash.ppmtool.daoimpl.BacklogDaoImpl;
import com.yash.ppmtool.daoimpl.ProjectDAOImpl;
import com.yash.ppmtool.domain.Backlog;
import com.yash.ppmtool.domain.Project;
import com.yash.ppmtool.service.BacklogService;

public class BacklogServiceImpl implements BacklogService {
	BacklogDao backlogDao = new BacklogDaoImpl();
	@Override
	public void createBacklog(Project project) {
		
		
		ProjectDAO projectDAO = new ProjectDAOImpl();
		Backlog backlog = new Backlog();
		System.out.println(project);
		project.setId(projectDAO.find(project.getProject_identifier()).getId());
	    backlog.setProject_id(project.getId());
	    backlog.setProject_identifier(project.getProject_identifier());
	    backlog.settSequence(project.getProject_identifier()+"b0");
	    
		
		
		backlogDao.save(backlog);

	}

	@Override
	public Backlog findBacklog(String project_identifier) {
		return backlogDao.find(project_identifier);
		
	}
	
	

}
