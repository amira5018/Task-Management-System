
package com.mycompany.taskmangmentproject;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author HP
 */
public class Employee extends Users {
    
    private String EmployeeId ;
    private static int EmployeeCount = 1;
  private List<Task>  assignedTasks;
   private List<Request> Employeerequests;
    private List<Vacation> EmployeeVacations;
    public Employee(){}
    
  public Employee (String name,String Email,String Passward){
    super(name,Email,Passward);
    
    this.setEmployeeId("Employee_"+EmployeeCount);
       EmployeeCount++;
        this. assignedTasks= new ArrayList<>();
        this.EmployeeVacations= new ArrayList<>();
        this.Employeerequests= new ArrayList<>();
  }
  
  Request MakeRequest(Employee employee){
      Request request=new Request(); 
      return request;
  }
   public Vacation makeVacation(VacationTypes type, LocalDate startDate, LocalDate endDate, String description) {
       
        Date start = Date.from(startDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date end = Date.from(endDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        if (start.before(new Date()) || end.before(start)) {
            throw new IllegalArgumentException("Invalid vacation dates.");
        }
        Vacation vacation = new Vacation(this.getEmployeeCount(), type, start, end, description);

        this.EmployeeVacations.add(vacation);
        return vacation;
    }

    // Methods
    public void addTask(Task task) {
        assignedTasks.add(task);
    }

    public List<Task> getAssignedTasks() {
        return assignedTasks;
    }
     public void RemoveTask(Task task) {
        assignedTasks.remove(task);
    }
     
     
      public void addRequest(Request request) {
        Employeerequests.add(request);
    }

    public List<Request> getEmployeeRequests() {
        return Employeerequests;
    }
     public void RemoveTask(Request request) {
        Employeerequests.remove(request);
    }
     
    public void addVacation(Vacation vacation) {
        EmployeeVacations.add(vacation);
    }

    public List<Vacation> getEmployeeVacations() {
        return EmployeeVacations;
    }
     public void RemoveVacation(Vacation vacation) {
        EmployeeVacations.remove(vacation);
    }



    public String getEmployeeId() {
        return EmployeeId;
    }
    
    public int getEmployeeCount()
    {
        return EmployeeCount;
    }
    
    public void setEmployeeId(String EmployeeId) {
        this. EmployeeId = EmployeeId;
    }
}
