package org.graduatetrackingsystem.graduatetracking.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.graduatetrackingsystem.graduatetracking.dtos.AdminDto;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminRequest {
    private String username;
    private String password;

    public AdminDto toDto() {
        return AdminDto.builder()
                .username(this.username)
                .password(this.password)
                .build();
    }
}
