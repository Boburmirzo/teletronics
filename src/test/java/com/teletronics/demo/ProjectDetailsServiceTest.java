package com.teletronics.demo;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.teletronics.demo.model.Project;
import com.teletronics.demo.service.ProjectDetailsService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProjectDetailsServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProjectDetailsService service;

    /**
     * Test method to check if list of Projects is returned.
     */
    @Test
    public void projectsListTest() {
        when(service.projectsList("test")).thenReturn(getDummyProjectsList());
        try {
			this.mockMvc.perform(get("/projects/Boburmirzo")).andDo(print()).andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    private List<Project> getDummyProjectsList(){
    	long id = 123;
    	String name = "test";
    	String fullName = "fullName";
    	String htmlUrl = "htmlUrl";
    	String description = "description";
    	
        Project project1 = new Project(id, name, fullName, htmlUrl, description);
        Project project2 = new Project(id, name, fullName, htmlUrl, description);
        Project project3 = new Project(id, name, fullName, htmlUrl, description);
        Project project4 = new Project(id, name, fullName, htmlUrl, description);
        
        List<Project> projects = new ArrayList<>();
        projects.add(project1);
        projects.add(project2);
        projects.add(project3);
        projects.add(project4);
        
        return projects;
        
        
    }
}