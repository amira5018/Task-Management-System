package com.mycompany.taskmangmentproject;

import java.util.Date;

public class VacationRequest {

          private final int requestId;
          private final int empId;
          private String description;

          private final Date requestDate;
          private Date vacationStartDate;
          private Date vacationEndDate;
          private VacationTypes vacationType;

          private RequestStatus status; // استخدام enum للحالة
          private Date statusUpdateDate;

          private static int requestsNum;


          // Constructor
          public VacationRequest(int empId , VacationTypes vacationType , Date vacationStartDate , Date vacationEndDate) {
                    this(empId , vacationType , vacationStartDate , vacationEndDate , "");
          }


          public VacationRequest(int empId , VacationTypes vacationType , Date vacationStartDate , Date vacationEndDate , String description) {
                    this(new Date() , empId , vacationType , vacationStartDate , vacationEndDate , description);
          }


          public VacationRequest(Date requestDate , int empId , VacationTypes vacationType , Date vacationStartDate , Date vacationEndDate , String description) {
                    this.requestId = ++requestsNum;

                    this.empId = empId;
                    this.description = description;
                    this.requestDate = requestDate;
                    this.status = RequestStatus.PENDING;
                    this.statusUpdateDate = requestDate;

                    this.vacationType = vacationType;
                    this.vacationStartDate = vacationStartDate;
                    this.vacationEndDate = vacationEndDate;
                    if ( vacationStartDate.before(requestDate)
                            || vacationEndDate.before(vacationStartDate) ) {
                              throw new AssertionError("Invalid Dates");
                    }
          }


          public static int getRequestsNum() {
                    return requestsNum;
          }


          // Methods to approve or reject the request
          public Vacation approveRequest() {
                    if ( this.status == RequestStatus.PENDING ) {
                              this.status = RequestStatus.APPROVED;
                              this.statusUpdateDate = new Date();
                              return new Vacation(empId , vacationType , vacationStartDate , vacationEndDate , description);
                    }
                    return null;
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


          public Date getRequestDate() {
                    return requestDate;
          }


          public int getRequestId() {
                    return requestId;
          }


          public RequestStatus getStatus() {
                    return status;
          }


          public void setStatus(RequestStatus status) {
                    this.status = status;
          }


          public Date getStatusUpdateDate() {
                    return statusUpdateDate;
          }


          public void setStatusUpdateDate(Date statusUpdateDate) {
                    this.statusUpdateDate = statusUpdateDate;
          }


          public Date getVacationEndDate() {
                    return vacationEndDate;
          }


          public void setVacationEndDate(Date vacationEndDate) {
                    if ( this.status == RequestStatus.PENDING ) {
                              this.vacationEndDate = vacationEndDate;
                    }
          }


          public Date getVacationStartDate() {
                    return vacationStartDate;
          }


          public void setVacationStartDate(Date vacationStartDate) {
                    if ( this.status == RequestStatus.PENDING ) {
                              this.vacationStartDate = vacationStartDate;
                    }
          }


          public VacationTypes getVacationType() {
                    return vacationType;
          }


          public void setVacationType(VacationTypes vacationType) {
                    if ( this.status == RequestStatus.PENDING ) {
                              this.vacationType = vacationType;
                    }
          }


          public boolean rejectRequest() {
                    if ( this.status == RequestStatus.PENDING ) {
                              this.status = RequestStatus.REJECTED;
                              this.statusUpdateDate = new Date();
                              return true;
                    }
                    return false;
          }


          // Display request details
          @Override
          public String toString() {
                    return "Request"
                            + "\n\tID : " + requestId
                            + "\n\tEmployee ID : " + empId
                            + "\n\tStatus : " + status
                            + "\n\tUpdated : " + statusUpdateDate;
          }

}
