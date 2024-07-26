package edu.icet.crm.model;

import lombok.Data;

import java.util.Date;

@Data


public class Rental {
    private Long rentID;
    private Long customerID;
    private Date rentalDate;
    private Date expectedReturnDate;
    private Date returnedDate;
    private Integer lateDays;
    private Double fine;
    private Double totalCost;
}
