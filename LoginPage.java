/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskmangmentproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LoginPage implements ActionListener {
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JTextField userNameField = new JTextField();
    JTextField userEmailField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userNameLabel = new JLabel("User Name:");
    JLabel userEmailLabel = new JLabel("User Email:");
    JLabel userPasswordLabel = new JLabel("Password:");
    JLabel messageLabel = new JLabel();

    UserAuthenticattion auth;

    public LoginPage(UserAuthenticattion auth) {
        this.auth = auth;

        userNameLabel.setBounds(50, 100, 75, 25);
        userEmailLabel.setBounds(50, 150, 75, 25);
        userPasswordLabel.setBounds(50, 200, 75, 25);
        messageLabel.setBounds(125, 300, 250, 35);
        userNameField.setBounds(125, 100, 200, 25);
        userEmailField.setBounds(125, 150, 200, 25);
        userPasswordField.setBounds(125, 200, 200, 25);
        loginButton.setBounds(125, 250, 100, 25);

        frame.add(userNameLabel);
        frame.add(userEmailLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(userNameField);
        frame.add(userEmailField);
        frame.add(userPasswordField);
        frame.add(loginButton);

        loginButton.addActionListener(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 400);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String userName = userNameField.getText();
            String userEmail = userEmailField.getText();
            String password = new String(userPasswordField.getPassword());

            if (userName.isEmpty() || userEmail.isEmpty() || password.isEmpty()) {
                messageLabel.setText("Please fill in all fields.");
            } else {
                Users user = auth.authenticateUser(userName, userEmail, password);
                if (user != null) {
                    messageLabel.setText("Login successful! Welcome " + user.getName());
                } else {
                    messageLabel.setText("Invalid login. Please check your credentials.");
                }
            }
        }
    }
}
