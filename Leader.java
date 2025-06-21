/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskmangmentproject;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author HP
 */
public class Leader extends Users {
    
private  String leaderId ;
private static int LeaderCount=1;
Admin admin = new Admin();

 private List<Project> projects;
  private List<Task> tasksLeader;
   private List<Request> requests;
    private List<Vacation> Vacations;
  
public Leader(String name,String Email,String Passward){
    super(name,Email,Passward);
    this.setLeaderId("Leader_"+LeaderCount);
       LeaderCount++;
        this.tasksLeader= new ArrayList<>();
        this.projects = new ArrayList<>(); 
        this.Vacations=new ArrayList<>(); 
        this.requests=new ArrayList<>(); 
}
     public List<Task> getTasks() {
        return tasksLeader;
    }

    // Methods
    public void addTask(Task task) {
       tasksLeader.add(task);
    }

    public void removeTask(Task task) {
        tasksLeader.remove(task);
    }
    
     public ArrayList<String> getProject() throws InterruptedException {
        return admin.returnProjectlist();
    }
     public void removeProject(Project project) {
       projects.remove(project);
    }
      public List<Request> getRequest() {
        return requests;
    }
     public void removeRequest(Request request) {
       requests.remove(request);
    }
     
    

    // Methods
     public void addProjects(Project project) {
       projects.add(project);
     }
  
 boolean CreateTask(Project project,String title, String descriptition, LocalDate start_date, LocalDate end_date, float estimation_hours, 
                LocalDate fromtime, LocalDate totime, float actual_hours, taskphase Taskphase, priority PRIORITY, 
                 Employee employee, Leader creator,Evaluation evaluation ){
     
     if(projects.contains(project)){
       Task task=new Task( project, title,  descriptition,  start_date,  end_date,  estimation_hours, 
                          fromtime,  totime,  actual_hours,  Taskphase,  PRIORITY, 
                           employee, creator, evaluation );
        project.addTask(task);
      //  task.setStart_date(LocalDate.now());
        this.addTask(task);
        return true;
     }
     else
         return false;
 }
  
  
  
  public  Task AddTaskPhase(String NewTaskPhase,Task task){
      if(task.getTaskphase().equals(null)){
         task.setTaskphase(taskphase.valueOf(NewTaskPhase)); 
      }
      return task;
   }
  public  Task DeleteTaskPhase(String OldTaskPhase,Task task){
      if(task.getTaskphase().equals(OldTaskPhase)){
         task.setTaskphase(null); 
      }
      
      return task;
   }
  
  public  Task UpdateTaskPhase(String OldTaskPhase,String NewTaskPhase,Task task){
      if(task.getTaskphase().equals(OldTaskPhase)){
         task.setTaskphase(taskphase.valueOf(NewTaskPhase)); 
//        if(NewTaskPhase.equals("completed"))
//            task.setTotime(LocalDate.now());
      }
      
      return task;
   }
    public  Task UpdateTitle(String OldTitle,String NewTitle,Task task){
      if(task.getTitle()==OldTitle){
         task.setTitle(NewTitle);
      }
      
      return task;
   }
     public  Task UpdateDescription(String oldDescription,String NewDescription,Task task){
      if(task.getDescriptition().equals(oldDescription)){
         task.setDescriptition(NewDescription);
      }
      
      return task;
   }
     public  Task UpdatePriority(String oldPriority,String NewPriority,Task task){
      if(task.getPRIORITY().equals(oldPriority)){
         task.setPRIORITY(priority.valueOf(NewPriority));
      }
      
      return task;
   }
     
     public  Task UpdateTaskEvaluation(String oldTaskEvaluation,String NewTaskEvaluation,Task task){
      if(task.getEvaluation().equals( oldTaskEvaluation)){
         task.setEvaluation(Evaluation.valueOf(NewTaskEvaluation));
      }
      
      return task;
   }
    
   
     public  Task UpdateEndDate(LocalDate oldEndDate,LocalDate NewEndDate,Task task){
      if(task.getEnd_date().equals(oldEndDate)){
         task.setEndDate(NewEndDate);
      }
      
      return task;
   }
     public List<Request> getRequests() {
        return requests ;
    }
     
  int  AcseptRequest(Request request,String choose){
       if(request.getStatue().equals("pending")){
         switch(choose.toLowerCase()){
             case "mission":
                       return 1;
                    case "permission":
                       return -1;
                }
           }
          
          return 0;
         }
            
      int AcseptVacation(Vacation vacation,String choose){
         
          if(vacation.getStatus().equals("pending")){
                switch(choose.toLowerCase()){
                    case "mission":
                       return 1;
                    case "permission":
                       return -1;
                }
           }      
          return 0;
          
   }   


     
     
 boolean AssignTaskToEmployee(Employee employee,Task task){
     if(!tasksLeader.contains(task))
         return false;
     else{
         employee.addTask(task);
         //task.setFromtime(LocalDate.now());
         return true;
     }  
 }
   int ReassignTaskToEmployee(Employee currentemployee,Employee newemployee,Task task){
     if(!tasksLeader.contains(task))
         return 0;
     if(!currentemployee.getAssignedTasks().contains(task))
         return -1;
     
     else{
         currentemployee.RemoveTask(task);
         newemployee.addTask(task);
         return 1;
     }  
 }
   
    public String getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(String leaderId) {
        this.leaderId = leaderId;
    }
    
  
    
@Override
    public String toString(){
        return" Leder{ Leader ID= "+this.getLeaderId()+"\n"+"Leader Name= "+super.getName()
                +"\n"+"Leader Email= "+super.getEmail()+"\n"+"Leader Passward= "+super.getPassward()+"\n"+
                "projects: "+this.projects+"\n"+"Tasks"+this.tasksLeader+"\n"+"Request"+this.requests+"\n"+"Vacation"+this.Vacations;
    }
    
}
