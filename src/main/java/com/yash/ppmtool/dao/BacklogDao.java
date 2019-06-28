package com.yash.ppmtool.dao;

import com.yash.ppmtool.domain.Backlog;

public interface BacklogDao {

	/**
	 * To create backlog 
	 * @param backlog to be created
	 */
	void save(Backlog backlog);
	
	
	/**
	 * To find backlog
	 * @param project_identifier to be searched in backlog
	 * @return backlog of specific project identifier
	 */
	Backlog find(String project_identifier);
	
}
