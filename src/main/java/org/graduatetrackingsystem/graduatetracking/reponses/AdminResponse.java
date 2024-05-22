package org.graduatetrackingsystem.graduatetracking.reponses;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdminResponse {
    private Long adminId;
    private String username;
    private String password;
}
