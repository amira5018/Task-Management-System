

package com.mycompany.taskmangmentproject;

/**
 *
 * @author HP
 */
import java.util.Date;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
public class TaskMangmentProject {

    public static void main(String[] args) {
        
       Scanner input=new Scanner(System.in);
                      String startDate  = "20-10-2022";//خدي بالك لانهم معارفينه localDate مش String
                      String endDate = "10-10-2023";
                      LocalDate startdate = LocalDate.parse(startDate);
                      LocalDate enddate = LocalDate.parse(endDate);
                        priority priority;
                      String Tasktitle,  Taskphase,Taskdescription, leaderName,TaskEvaluation,LeaderOperations;
                     LocalDate TaskStartDate,TaskfromTime,TaskendDate,TaskToTime;
                     float estimation_hours,actual_hours;
                      String   EmployeeName,EmployeeEmail,EmployeePassward,UpdateOperation,Choice,
                      LeaderName,LeaderEmail,LeaderPassward;
                      String LeaderOperation,AdminOperation,ProjectOperations,projectName,EmployeeOperation;
                      Admin admin = new Admin();
       
       
    Admin aDmin = new Admin("remonda","remonda@32","remondA32");
        File_Handler obj = new File_Handler();
        UserAuthenticattion auth = new UserAuthenticattion();
        auth.User(new Users("admin", "admin@example.com", "admin123")); // Optional: Add a default admin user
        LoginPage loginPage = new LoginPage(auth);
        
        
      System.out.print("Enter Operation"+"project"+"\n"+"Employee"+"\n"+"Leader");
      AdminOperation=input.nextLine();
      switch(AdminOperation){
          case "project":
              System.out.print("Enter Operation"+"Add project"+"\n"+"Update project"+"\n"+"Delete project");
              ProjectOperations=input.nextLine();
              switch(ProjectOperations){
                  case "Add Project":
                      System.out.print("Project Name: ");
                      projectName=input.nextLine();
                   
                      admin.addProject(projectName, startdate, enddate);
                      break;
                  case "Update Project":
                     System.out.print("New Project Name: ");
                     admin.updateProject(0,"Another name", startdate, enddate);
                     break;
                   case "Delete Project":
                       admin.deleteProject(0);
                       break;
                    
              }
          case "Employee":
               System.out.print("Enter Operation"+"Add Employee"+"\n"+"Update Employee"+"\n"+"Delete Employee");
               EmployeeOperation=input.nextLine();
               switch(EmployeeOperation){
                   case "Add Employee":
                       System.out.print("Employee name:");
                       EmployeeName=input.nextLine();
                       System.out.print("Employee Email:");
                       EmployeeEmail=input.nextLine();
                       System.out.print("Employee Passward:");
                       EmployeePassward=input.nextLine();
                       admin.addEmployee(EmployeeName,EmployeeEmail, EmployeePassward);
                       break;
                   case "Update Employee" :
                       //System.out.print();
                       admin.updateEmployee(0, "Testname", "Testemail@mmdmd.com"," passcodetest");
                       break;
                   case "Delete Employee":
                      admin.deleteEmployee(0);
                      break;
                            
               }
          case "Leader":
               System.out.print("Enter Operation"+"Add Leader"+"\n"+"Update Leader"+"\n"+"Delete Leader");
               EmployeeOperation=input.nextLine();
               switch(EmployeeOperation){
                   case "Add Leader":
                       System.out.print("Leader name:");
                       LeaderName=input.nextLine();
                       System.out.print("Leader Email:");
                       LeaderEmail=input.nextLine();
                       System.out.print("Leader Passward:");
                       LeaderPassward=input.nextLine();
                       admin.addEmployee(LeaderName, LeaderEmail, LeaderPassward);
                       break;
                   case "Update Leader" :
                       //System.out.print();
                       admin.updateLeader(0, 0, 0);
                       break;
                   case "Delete Leader":
                      admin.deleteLeader(0, 0);
                      break;
                            
               }
      }
   
  
        

       
    
       
 
 System.out.print("-Create Task "+"\n"+"-View All Tasks"+"\n"+"-Assign Task To Employee"+"\n"+"Update Task"+"\n"
         +"Mange Vacations"+"\n"+"Mange Requests"+"\n"+"Reassign Task");
       LeaderOperations=input.nextLine();
       
     switch( LeaderOperations) {
         case "Create Task":
             System.out.print("Task Title: ");
               Tasktitle= input.nextLine();
    System.out.print("Taskphase: ");
    Taskphase= input.nextLine();
    System.out.print("priority: ");
    //priority= input.nextLine();  
    System.out.print("Taskdeclaration: ");
     Taskdescription= input.nextLine();
    System.out.print("leaderName: ");
    leaderName= input.nextLine();
    System.out.print("TaskEvaluation: ");
    TaskEvaluation= input.nextLine();
    
      System.out.print("TaskfromTime: ");
     TaskfromTime=LocalDate.now();
      System.out.print("TaskendDate: ");
     TaskendDate=LocalDate.now();
      System.out.print("TaskToTime: ");
    TaskToTime=LocalDate.now();
      System.out.print("TaskStartDate: ");
     TaskStartDate=LocalDate.now();
       System.out.print("TaskActualhours: ");
     actual_hours=input.nextFloat();
      System.out.print("TaskestimatedHours: ");
    estimation_hours=input.nextFloat();
    Leader leader=new Leader("remonda","remonda@52","remondA32");
    Project project=new Project("software", startdate, enddate, admin);
    Employee employee=new Employee();
 leader.CreateTask(project, Tasktitle,  Taskdescription,  TaskStartDate, TaskendDate,  estimation_hours, TaskfromTime,  TaskToTime,  actual_hours,  Taskphase, priority, 
                employee, leaderName,TaskEvaluation);
                System.out.println(leader.getTasks());
              break;
              
         case "View All Tasks":
             List<Task> Leadertasks = leader.getTasks();
    
            if (Leadertasks.isEmpty()) {
               System.out.println("No tasks assigned.");
                } else {
                     System.out.println("Tasks List:");
                     for (Task task : Leadertasks) {
                         System.out.println(task.toString());
                         System.out.println("--------------------------------");
               }
            }
             break;
         case "Assign Task To Employee":
             
         break;
         case "Update Task":
            System.out.print("What do you need to update?"+"\n"+"Update Taskphase"+"\n"+"Update Priority"+"\n"+
                    "Update Evaluation"+"\n"+"Update Title"+"\n"+"Update Description"+"Update EndDate");
            UpdateOperation=input.nextLine();
             switch(UpdateOperation){
                 case "Update TaskPhase":
                     break;
                 case "Update Priority":
                     break;
                 case "Update Evaluation":
                     break;
                 case "Update Title":
                     break;
                 case "Update Description":
                     break;
                 case "Update EndDate":
                     break;
             }
            break;
         case "Mange Vacations":
             System.out.print("enter your choice:mission"+"\n"+"  permission");
             Choice=input.nextLine();
             
             break;
         case "Mange Request":
             System.out.print("enter your choice:mission"+"\n"+"  permission");
             Choice=input.nextLine();
            break;
            
         case "Reassign Task":
             break;
     }     
    

     
       

     
        
    }
}
        
    

