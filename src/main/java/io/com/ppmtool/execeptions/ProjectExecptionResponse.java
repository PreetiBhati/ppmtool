package io.com.ppmtool.execeptions;

public class ProjectExecptionResponse {
    private String projectIdentifier;

    public ProjectExecptionResponse(String projectIdentifier){
        this.projectIdentifier=projectIdentifier;

    }

    public String getProjectIdentifier() {
        return projectIdentifier;
    }

    public void setProjectIdentifier(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }
}
