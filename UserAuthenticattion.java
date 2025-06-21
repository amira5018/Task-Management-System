/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskmangmentproject;



import java.util.ArrayList;

public class UserAuthenticattion {
    private ArrayList<Users> usersList = new ArrayList<>();
    private FileHandler fileHandler;

    public UserAuthenticattion() {
        fileHandler = new FileHandler("users.txt");
        usersList = fileHandler.loadUsersFromFile(); // Load users from file when the application starts
    }

    public void User(Users user) {
        usersList.add(user);
        fileHandler.saveUserToFile(user); // Save the new user to the file
    }

    public Users authenticateUser(String name, String email, String password) {
        for (Users user : usersList) {
            if (user.getName().equals(name) && user.getEmail().equals(email) && user.getPassward().equals(password)) {
                return user;
            }
        }
        return null; // Return null if no matching user is found
    }
}
