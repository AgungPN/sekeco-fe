package dtos.invoiceTour;

import dtos.tour.Tour;
import enums.Status;
import lombok.Data;

import java.util.Date;

@Data
public class InvoiceTour {
    private Long invoiceTourId;
    private Tour tourId;
    private int unitBus;
    private Long income;
    private int employee;
    private Status status;
    private Date createdAt;
    private Date updatedAt;
}
