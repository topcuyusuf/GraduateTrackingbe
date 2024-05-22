package org.graduatetrackingsystem.graduatetracking.services;

import org.graduatetrackingsystem.graduatetracking.dtos.AdminDto;
import org.graduatetrackingsystem.graduatetracking.dtos.AdminLoginDto;
import org.graduatetrackingsystem.graduatetracking.reponses.AdminLoginResponse;
import org.graduatetrackingsystem.graduatetracking.reponses.StudentLoginResponse;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AdminService {
    List<AdminDto> getAllAdmins();
    AdminDto getAdminById(long id);
    AdminDto createAdmin(AdminDto dto);
    void deleteAdmin(Long id);
    AdminDto updateAdmin(long id, AdminDto dto);

    AdminLoginResponse loginAdmin(AdminLoginDto adminLoginDto);
}
