package org.graduatetrackingsystem.graduatetracking.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class NotificationDto {

    private Long id;
    private String header;
    private String body;
    private boolean active;
}
