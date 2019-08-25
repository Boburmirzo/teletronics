package com.teletronics.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.teletronics.demo.controller.ProjectDetailsController;
import com.teletronics.demo.model.Project;

/**
* The ProjectDetailsService does the processing of Json response from external github url
* and returns the response in desired format.
*
* @author  Boburmirzo
* @version 1.0
* @since   2019-08-25
*/

@Service("projectDetailsService")
public class ProjectDetailsService {

	@Autowired
	RestTemplate restTemplate;

	@Value("${github.repos.restURL.part1}")
	String part1URL;

	@Value("${github.repos.restURL.part2}")
	String part2URL;

	private static final Logger log = LoggerFactory.getLogger(ProjectDetailsController.class);

	/**
	 * This method fetches the github repos of the user
     * by using Rest Template, keeps only the desired fields 
     * as per the Project model and returns the processed response
     * @param username
	 * @return list of Projects
	 */
	public List<Project> projectsList(String username) {
		String serviceURL = part1URL + username + part2URL;
		log.info("final url is ", serviceURL);
		
		ResponseEntity<List<Project>> response = restTemplate.exchange(serviceURL, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Project>>() {
				});

		return response.getBody();
	}

}
