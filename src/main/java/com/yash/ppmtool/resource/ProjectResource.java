package com.yash.ppmtool.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.yash.ppmtool.dao.ProjectDAO;
import com.yash.ppmtool.daoimpl.ProjectDAOImpl;
import com.yash.ppmtool.domain.Project;
import com.yash.ppmtool.exception.ProjectException;
import com.yash.ppmtool.service.ProjectService;
import com.yash.ppmtool.serviceimpl.ProjectServiceImpl;

@Path("projects")
public class ProjectResource {

	private ProjectService projectService = new ProjectServiceImpl();
	private ProjectDAO projectDAO = new ProjectDAOImpl();

	//CRUD to get project list
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Project> listAllProjects()
	{
		List<Project> projectList = null;
		try {
			projectList = projectService.listProject();
		} catch (ProjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return projectList;
	}
	
	//CRUD to create project
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String createProject(Project project)
	{
		
		try {
		 projectService.createProject(project);
		} catch (ProjectException e) {
			
			e.printStackTrace();
		}
		
		return "Record Added Successfully";
	}
	
	//CRUD to delete project on bases of project identifier
	@DELETE
	@Path("/{project_identifier}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteProjectByIdentifier(@PathParam("project_identifier") String project_identifier)
	{
		 try {
			projectService.deleteProject(project_identifier);
		} catch (ProjectException e) {
			e.printStackTrace();
		}
		 return "Project Deleted Successfully";
	}
	
	//CRUD to update project 
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String updateProjectById(Project project)
	{   
		try {
			
			projectService.updateProject(project);
		} catch (ProjectException e) {
			e.printStackTrace();
		}
		return "project updated successfully";
	}
	
}
