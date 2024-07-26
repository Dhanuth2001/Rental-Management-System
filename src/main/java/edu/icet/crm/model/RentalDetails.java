package edu.icet.crm.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data

public class RentalDetails {
    private Long rentDetailID;
    private Long rentID;
    private Long itemID;
    private Double totalItemCost;
    private Integer qty;
}
