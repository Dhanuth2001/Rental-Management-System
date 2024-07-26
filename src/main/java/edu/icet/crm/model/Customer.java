package edu.icet.crm.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data

public class Customer {
    private Long customerID;
    private String name;
    private String city;
    private String contactNo;
}
