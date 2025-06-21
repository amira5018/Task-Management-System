package com.mycompany.taskmangmentproject;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException; 
import java.util.Scanner; 
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Admin extends Users{
    
    Employee obj = new Employee();
    Project projectObj = new Project();
    
    private int Em_id = obj.getEmployeeCount();
    private static int P_id=1;
    private String  project_name;
    private static int pCounter=0;
    

    
  Scanner scan = new Scanner(System.in);
  File_Handler fileHandler = new File_Handler();

    public Admin(){}
    public Admin(String name, String Email, String Passward) {
        super(name, Email, Passward);
    }
  
    
    
  public void addEmployee(String name, String email, String password)
  {
        super.setName(name) ;
        super.setEmail(email);
        super.setPassward(password);
        
        String filename = obj.getEmployeeId() + ".txt";
        
        fileHandler.createFile(filename);
        fileHandler.writeToFile(filename, "ID: " + Em_id, true);
        fileHandler.writeToFile(filename, "Name: " + name, true);
        fileHandler.writeToFile(filename, "Email: " + email, true);
        fileHandler.writeToFile(filename, "Password: " + password, true);
     }
  
  public void updateEmployee(int Em_id, String name, String email, String password) 
  {
      
      String filename = "employee_" + Em_id + ".txt";
       if( fileHandler.searchforFile(filename)){
        fileHandler.writeToFile(filename, "ID: " + Em_id, false);
        fileHandler.writeToFile(filename, "Name: " + name, true);
        fileHandler.writeToFile(filename, "Email: " + email, true);
        fileHandler.writeToFile(filename, "Password: " + password, true); }
       else
       {
           System.out.println("File you wanted to update is not found");
       }
  }
   
  public void deleteEmployee(int Em_id)
  {
      String fileName  = "employee_" + Em_id + ".txt";
     fileHandler.deleteFile(fileName);
  
  }
  
  
  public void addProject( String project_Name, LocalDate startDate, LocalDate endDate)
  {
       if (endDate.isBefore(startDate)) 
       {
            System.out.println("Error: End date cannot be before start date.");
            return;
        }
       String filename = projectObj.getProjectId()+ ".txt";
       fileHandler.createFile(filename);
       fileHandler.writeToFile(filename, "ID: " + P_id, true);
       fileHandler.writeToFile(filename, "ProjectName: "+ project_Name, true);
       fileHandler.writeToFile(filename, "Start date: " + startDate, true);
       fileHandler.writeToFile(filename, "Start date: " + endDate, true);
       pCounter++;
       P_id++;
  }
  public void updateProject(int P_id, String  project_Name, LocalDate startDate, LocalDate endDate)
  {
       if (endDate.isBefore(startDate)) 
       {
            System.out.println("Error: End date cannot be before start date.");
            return;
        }
         String filename = "Project_" + P_id + ".txt";
         if( fileHandler.searchforFile(filename)){
         fileHandler.writeToFile(filename, "Project id: "+ P_id, false);
        fileHandler.writeToFile(filename, "ProjectName: "+ project_Name, true);
        fileHandler.writeToFile(filename, "Start date: " + startDate, true);
       fileHandler.writeToFile(filename, "Start date: " + endDate, true);}
         else
         {
             System.out.println("File you wanted to update is not found");
         }
  }
  public void deleteProject(int P_id)
  {
      String filename = "Project_" +P_id + ".txt";
      fileHandler.deleteFile(filename);
      pCounter--;
  }
  public ArrayList<String> returnProjectlist() throws InterruptedException
  {
      return fileHandler.returnFileList(pCounter, "Project_" + P_id +".txt");
  }
  
  
  public void addLeader(String name, int Em_id, int P_id)
  {
       String filename = "Teamleader_" + Em_id +"_"+ P_id+ ".txt";
        
       fileHandler.createFile(filename);
       fileHandler.writeToFile(filename,"Team leader name:  "+ name, true);
  }
  public void updateLeader(int oldEm_id, int newEm_id, int P_id)
  {
      String oldFilename = "Teamleader_" + oldEm_id +"_"+ P_id+ ".txt";
      String Newfilename = "Teamleader_" + newEm_id +"_"+ P_id+ ".txt";
      fileHandler.updateFile(oldFilename, Newfilename);
  }
  public void deleteLeader(int Em_id, int p_id)
  {
      String filename = "Teamleader_" +Em_id +"_"+ p_id+".txt";
      fileHandler.deleteFile(filename);
  }
  
  public static void main(String[] args)
  {
      Admin admin = new Admin();

        
       
 }
}
