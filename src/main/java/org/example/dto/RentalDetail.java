package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentalDetail {

    private Long rentId;
    private String rentalDate;
    private String dueDate;
    private String returnedDate;
    private double total;
    private double fine;


}
