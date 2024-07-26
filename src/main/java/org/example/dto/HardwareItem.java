package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HardwareItem {

    private Long itemId;
    private String name;
    private String availability;
    private double rentalPerDay;
    private double fineDay;
}
