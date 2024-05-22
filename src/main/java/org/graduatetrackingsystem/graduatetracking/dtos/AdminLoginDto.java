package org.graduatetrackingsystem.graduatetracking.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdminLoginDto {
    private String username;
    private String password;
}
