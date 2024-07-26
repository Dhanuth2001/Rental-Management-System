package edu.icet.crm.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data

@Entity
@Table(name = "Rental")
public class RentalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rentID;
    private Long customerID;
    private Date rentalDate;
    private Date expectedReturnDate;
    private Date returnedDate;
    private Integer lateDays;
    private Double fine;
    private Double totalCost;
}
