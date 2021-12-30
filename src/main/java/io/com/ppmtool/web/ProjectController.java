package io.com.ppmtool.web;

import io.com.ppmtool.domain.Project;
import io.com.ppmtool.services.MapValidationErrorService;
import io.com.ppmtool.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private MapValidationErrorService  mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> createNewProject (@Valid @RequestBody Project project, BindingResult result){
      ResponseEntity <?> errorMap= mapValidationErrorService.MapValidation(result);
      if(errorMap != null) return errorMap;

        Project project1= projectService.saveOrUpdate(project);
        return new ResponseEntity<Project>(project1 , HttpStatus.CREATED);
    }
    @GetMapping("/{projectId}")
    public ResponseEntity<?> getProjectById(@PathVariable String projectId){
        Project project= projectService.findProjectByIdentifier(projectId.toUpperCase());
        return  new ResponseEntity<Project>(project,HttpStatus.OK);
    }
    @PostMapping("/all")
 public  Iterable<Project> getAllProjects(){
        return projectService.findAllProjects();
    }
    @DeleteMapping ("/{projectid}")
        public ResponseEntity<?> deleteProject(@PathVariable String projectid){
       projectService.deleteProjectbyId(projectid.toUpperCase());
       return new ResponseEntity<String>("Project with id "+projectid.toUpperCase()+" deleted successfully.",HttpStatus.OK);

        }
        @PostMapping("/edit")
        public ResponseEntity<?> updateProject (@Valid @RequestBody Project project, BindingResult result){
            ResponseEntity <?> errorMap= mapValidationErrorService.MapValidation(result);
            if(errorMap != null) return errorMap;

            Project project1= projectService.editPrjectById(project);
            return new ResponseEntity<Project>(project1 , HttpStatus.CREATED);
        }
}
