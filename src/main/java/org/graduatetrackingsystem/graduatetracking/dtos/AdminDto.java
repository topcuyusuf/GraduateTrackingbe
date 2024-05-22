package org.graduatetrackingsystem.graduatetracking.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdminDto {
    private Long adminId;
    private String username;
    private String password;
}