package edu.icet.crm.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data

@Entity
@Table(name = "RentalDetails")
public class RentalDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rentDetailID;
    private Long rentID;
    private Long itemID;
    private Double totalItemCost;
    private Integer qty;
}
