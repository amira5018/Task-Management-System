package com.mycompany.taskmangmentproject;

import java.util.Date;

public class Vacation {

          private final int vacationId;
          private final int empId;
          private String description;
          private final VacationTypes vacationType;
          private final Date vacationStartDate;
          private final Date vacationEndDate;

          private VacationStatus status;

          private static int vacationsNum;


          // Constructor
          public Vacation(int empId , VacationTypes vacationType , Date vacationStartDate , Date vacationEndDate) {
                    this(empId , vacationType , vacationStartDate , vacationEndDate , "");
          }


          public Vacation(int empId , VacationTypes vacationType , Date vacationStartDate , Date vacationEndDate , String description) {
                    this.vacationId = ++vacationsNum;
                    this.empId = empId;
                    this.description = description;
                    this.vacationType = vacationType;
                    this.vacationStartDate = vacationStartDate;
                    this.vacationEndDate = vacationEndDate;
                    updateStatus();
                    if ( vacationStartDate.before(new Date())
                            || vacationEndDate.before(vacationStartDate) ) {
                              throw new AssertionError("Invalid dates");
                    }
          }


          public static int getVacationsNum() {
                    return vacationsNum;
          }


          public String getDescription() {
                    return description;
          }


          public void setDescription(String description) {
                    this.description = description;
          }


          public int getEmpId() {
                    return empId;
          }


          public VacationStatus getStatus() {
                    return status;
          }


          public void updateStatus() {
                    Date now = new Date();
                    if ( now.after(vacationStartDate) ) {
                              if ( now.before(vacationEndDate) ) {
                                        this.status = VacationStatus.STARTED;
                              } else {
                                        this.status = VacationStatus.ENDED;
                              }
                    } else {
                              this.status = VacationStatus.PENDING;
                    }
          }


          public Date getVacationEndDate() {
                    return vacationEndDate;
          }


          public int getVacationId() {
                    return vacationId;
          }


          public Date getVacationStartDate() {
                    return vacationStartDate;
          }


          public VacationTypes getVacationType() {
                    return vacationType;
          }


          public int getVacationDaysToStart() {
                    int start = new Date().getDate();
                    int end = vacationStartDate.getDate();
                    return end - start;
          }


          public int getVacationDaysToEnd() {
                    int start = new Date().getDate();
                    int end = vacationEndDate.getDate();
                    return end - start ;
          }


          public int getVacationDaysCount() {
                    int start = vacationStartDate.getDate();
                    int end = vacationEndDate.getDate();
                    return end - start + 1;
          }


          // Display vacation details
          @Override
          public String toString() {
                    return "Vacation"
                            + "\n\tID : " + vacationId
                            + "\n\tEmployee ID : " + empId
                            + "\n\tType : " + vacationType
                            + "\n\tStatus : " + status;
          }

}
