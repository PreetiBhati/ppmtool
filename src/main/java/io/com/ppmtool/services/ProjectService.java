package io.com.ppmtool.services;

import io.com.ppmtool.domain.Project;
import io.com.ppmtool.execeptions.ProjectIOExecption;
import io.com.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdate(Project project){
               try{
                   project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
                   return projectRepository.save(project);
               }
               catch (Exception e){
                  throw new ProjectIOExecption("Project Id"+project.getProjectIdentifier().toUpperCase()+"already Exist");
               }

    }
    public Project findProjectByIdentifier(String projectId){

        Project project= projectRepository.findByProjectIdentifier(projectId);
if(project== null){
   throw new ProjectIOExecption("Project is not available");
}
return project;
    }
    public Iterable<Project> findAllProjects(){
        return projectRepository.findAll();
    }
public void deleteProjectbyId(String projectid){
    Project project= projectRepository.findByProjectIdentifier(projectid);
    if(project== null){
        throw new ProjectIOExecption("Project is not available");
    }
        projectRepository.delete(project);
}
public Project editPrjectById(Project project){
    Project project1= projectRepository.findByProjectIdentifier(project.getProjectIdentifier());
    if(project1== null){
        throw new ProjectIOExecption("Project is not available");
    }
    return projectRepository.save(project1);
}
}
