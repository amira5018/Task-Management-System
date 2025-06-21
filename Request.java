/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskmangmentproject;

/**
 *
 * @author HP
 */
public class Request {
   private String RequestId;
   private static int RequectCount;
   private String description;
   private String  title;
   private String statue;
  public Request(){
       
   }

    public Request(String description, String title) {
       this.setRequestId("Request_"+RequectCount);
        this.description = description;
        this.title = title;
        this.setStatue(statue);
    }

    public String getRequestId() {
        return RequestId;
    }

    public void setRequestId(String RequestId) {
        this.RequestId = RequestId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatue() {
        return statue;
    }

    public void setStatue(String statue) {
        this.statue = statue;
    }
  
    
}
