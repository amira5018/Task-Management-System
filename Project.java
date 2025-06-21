/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskmangmentproject;

/**
 *
 * @author HP
 */
import java.time.LocalDate;
  import java.util.ArrayList;
import java.util.List;

 

   public class Project {
       
    private static String projectId;
  private static  int  projectcounter=1;
    private String projectName;
      private LocalDate start_date;
    private LocalDate end_date;
    private Admin creator;
    private  ArrayList<Task> tasks; // List to store tasks related to the project

    // Constructor
    public Project(){}
    public Project( String projectName,LocalDate start_date,LocalDate end_date,Admin creator) {
       this.setProjectId("Project_"+projectcounter);
       projectcounter++;
        this.projectName = projectName;
         this.start_date = start_date;
        this.end_date = end_date;
        this.creator=creator;
        this.tasks = new ArrayList<>(); // Initialize the tasks list
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public Admin getCreator() {
        return creator;
    }

    public void setCreator(Admin creator) {
        this.creator = creator;
    }

    // Getters and Setters
    public String getProjectId() {
        return this.projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    // Methods
    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", tasks=" + tasks +
                '}';
    }
}
 

