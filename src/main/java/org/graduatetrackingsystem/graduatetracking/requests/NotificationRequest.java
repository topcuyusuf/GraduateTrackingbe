package org.graduatetrackingsystem.graduatetracking.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class NotificationRequest {

    private String header;
    private String body;
    private boolean active;

    public NotificationDto toDto() {
        return NotificationDto.builder()
                .header(this.header)
                .body(this.body)
                .active(this.active)
                .build();


    }
}
