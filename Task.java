/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskmangmentproject;

import java.time.LocalDate;

/**
 *
 * @author HP
 */
enum taskphase {Pending,UnderWork,Completed};
enum priority {high, low, medium};
enum Evaluation{Rejected,accepted,NeedModifications};

public class Task {
    private String code;
    private String title;
    private String descriptition;
    private static int count = 1;

    private LocalDate start_date;
    private LocalDate end_date;
    private float estimation_hours;
    
    private LocalDate fromtime;
    private LocalDate totime;
    private float actual_hours;
    private taskphase Taskphase;
    
    private priority PRIORITY;
    private Project project;
    private Employee employee;
    private Leader creator;
    
    private Evaluation evaluation;




// Constructor to initialize the task object

    public Task( Project project,String title, String descriptition, LocalDate start_date, LocalDate end_date, float estimation_hours, 
                LocalDate fromtime, LocalDate totime, float actual_hours, taskphase Taskphase, priority PRIORITY, 
                 Employee employee, Leader creator,Evaluation evaluation) {
        this.code = "task"+count++;
        this.title = title;
        this.descriptition = descriptition;
        this.start_date = start_date;
        this.end_date = end_date;
        this.estimation_hours = estimation_hours;
        this.fromtime = fromtime;
        this.totime = totime;
        this.actual_hours = actual_hours;
        this.Taskphase = Taskphase;
        this.PRIORITY = PRIORITY;
        this.project = project;
        this.employee = employee;
        this.creator = creator;
        this.evaluation=evaluation;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptition() {
        return descriptition;
    }

    public void setDescriptition(String descriptition) {
        this.descriptition = descriptition;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Task.count = count;
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

    public float getEstimation_hours() {
        return estimation_hours;
    }

    public void setEstimation_hours(float estimation_hours) {
        this.estimation_hours = estimation_hours;
    }

    public LocalDate getFromtime() {
        return fromtime;
    }

    public void setFromtime(LocalDate fromtime) {
        this.fromtime = fromtime;
    }

    public LocalDate getTotime() {
        return totime;
    }

    public void setTotime(LocalDate totime) {
        this.totime = totime;
    }

    public float getActual_hours() {
        return actual_hours;
    }

    public void setActual_hours(float actual_hours) {
        this.actual_hours = actual_hours;
    }

    public taskphase getTaskphase() {
        return Taskphase;
    }

    public void setTaskphase(taskphase Taskphase) {
        this.Taskphase = Taskphase;
    }

    public priority getPRIORITY() {
        return PRIORITY;
    }

    public void setPRIORITY(priority PRIORITY) {
        this.PRIORITY = PRIORITY;
    }

    public Project getPROJECT() {
        return project;
    }

    public void setPROJECT(Project PROJECT) {
        this.project= PROJECT;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Evaluation evaluation) {
        this.evaluation = evaluation;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Leader getCreator() {
        return creator;
    }

    public void setCreator(Leader creator) {
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "task{" + "" + code + ", title=" + title + ", descriptition=" + descriptition + ", start_date=" + start_date + ", end_date=" + end_date + ", estimation_hours=" + estimation_hours + ", fromtime=" + fromtime + ", totime=" + totime + ", actual_hours=" + actual_hours + ", Taskphase=" + Taskphase + ", PRIORITY=" + PRIORITY + ", PROJECT=" + project + ", employee=" + employee + ", creator=" + creator + '}';
    }

    void setEndDate(LocalDate NewEndDate) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    

}
