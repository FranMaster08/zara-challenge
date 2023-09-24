package com.zara.zara.responses;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApplicationDates {
    private LocalDateTime startDate;
    private LocalDateTime endsDate;
}
