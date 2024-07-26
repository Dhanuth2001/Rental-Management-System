package edu.icet.crm.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data

public class HardwareItem {
    private Long itemID;
    private String description;
    private String rentalPerDay;
    private String availability;
    private String finePerDay;

}
