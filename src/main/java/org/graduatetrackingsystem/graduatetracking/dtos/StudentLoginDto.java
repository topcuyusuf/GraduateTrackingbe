package org.graduatetrackingsystem.graduatetracking.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentLoginDto {
    private String email;
    private String password;
}
