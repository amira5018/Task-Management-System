/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskmangmentproject;

import java.io.*;
import java.util.ArrayList;

public class FileHandler {
    private String fileName;

    public FileHandler(String fileName) {
        this.fileName = fileName;
    }

    public ArrayList<Users> loadUsersFromFile() {
        ArrayList<Users> usersList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(","); // Assuming data is stored as name,email,password
                if (parts.length == 3) {
                    usersList.add(new Users(parts[0], parts[1], parts[2]));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No users file found, starting fresh.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usersList;
    }

    public void saveUserToFile(Users user) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            bw.write(user.getName() + "," + user.getEmail() + "," + user.getPassward());
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
