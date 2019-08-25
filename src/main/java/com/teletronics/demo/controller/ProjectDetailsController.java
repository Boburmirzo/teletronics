package com.teletronics.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.teletronics.demo.model.Project;
import com.teletronics.demo.service.ProjectDetailsService;

/**
* The ProjectDetailsController is the rest controller 
* & the application starting point.
*
 * @author  Boburmirzo
 * @version 1.0
 * @since   2019-08-25
*/

@RestController
public class ProjectDetailsController {

	@Autowired
	private ProjectDetailsService projectDetailsService;

	/**
	 *  This method that takes username as a path param
     * and renders the list of Projects a user has.
     * @param username
	 * @return Json response
	 */
	@GetMapping(value = "/projects/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Project> getProjectsByUser(@PathVariable("username") String username) {

		return projectDetailsService.projectsList(username);
	}

}
