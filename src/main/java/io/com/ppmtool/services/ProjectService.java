package io.com.ppmtool.services;

import io.com.ppmtool.domain.Project;
import io.com.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdate(Project project){

               return projectRepository.save(project);
    }
}
