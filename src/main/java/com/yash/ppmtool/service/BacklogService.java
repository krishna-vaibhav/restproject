package com.yash.ppmtool.service;

import com.yash.ppmtool.domain.Backlog;
import com.yash.ppmtool.domain.Project;

public interface BacklogService {

	
	void createBacklog(Project project);
	
	Backlog findBacklog(String project_identifier);
	
}
