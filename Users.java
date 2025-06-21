/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskmangmentproject;

/**
 *
 * @author HP
 */
public class Users {
 private String name ;
 private String Email;
 private String Passward;
 public Users(){}
 public Users(String name,String Email,String Passward){
     this.setPassward(Passward);
     this.setName(name);
     this.setEmail(Email);
 }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassward() {
        return Passward;
    }

    public void setPassward(String Passward) {
        this.Passward = Passward;
    }
    
}
