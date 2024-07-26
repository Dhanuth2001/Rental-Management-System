package edu.icet.crm.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data

@Entity
@Table(name = "hardwareItem")
public class HardwareItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemID;
    private String description;
    private String rentalPerDay;
    private String availability;
    private String finePerDay;

}
