package org.graduatetrackingsystem.graduatetracking.ServiceIpml;


import org.graduatetrackingsystem.graduatetracking.dtos.AdminDto;
import org.graduatetrackingsystem.graduatetracking.dtos.AdminLoginDto;
import org.graduatetrackingsystem.graduatetracking.entities.Admin;
import org.graduatetrackingsystem.graduatetracking.entities.Student;
import org.graduatetrackingsystem.graduatetracking.reponses.AdminLoginResponse;
import org.graduatetrackingsystem.graduatetracking.reponses.StudentLoginResponse;
import org.graduatetrackingsystem.graduatetracking.repositories.AdminRepository;
import org.graduatetrackingsystem.graduatetracking.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<AdminDto> getAllAdmins() {
        return adminRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AdminDto getAdminById(long id) {
        Optional<Admin> admin = adminRepository.findById(id);
        return admin.map(this::toDto).orElse(null);
    }

    @Override
    public AdminDto createAdmin(AdminDto dto) {
        Admin admin = toEntity(new Admin(), dto);
        String encodedPassword = passwordEncoder.encode(admin.getPassword());
        admin.setPassword(encodedPassword);
        return toDto(adminRepository.save(admin));
    }

    @Override
    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }

    @Override
    public AdminDto updateAdmin(long id, AdminDto dto) {
        Optional<Admin> existingAdmin = adminRepository.findById(id);
        if (existingAdmin.isPresent()) {
            Admin admin = existingAdmin.get();
            admin = toEntity(admin, dto);
            return toDto(adminRepository.save(admin));
        }
        return null;
    }

    @Override
    public AdminLoginResponse loginAdmin(AdminLoginDto adminLoginDto) {
        Admin admin = adminRepository.findByUsername(adminLoginDto.getUsername());
        if (admin != null) {
            boolean isPwdRight = passwordEncoder.matches(adminLoginDto.getPassword(), admin.getPassword());
            if (isPwdRight) {
                return new AdminLoginResponse("Login Success", true, admin.getAdminId());
            } else {
                return new AdminLoginResponse("Password Not Match", false, null);
            }
        } else {
            return new AdminLoginResponse("Email not exists", false, null);
        }
    }

    private Admin toEntity(Admin entity, AdminDto dto) {
        entity.setPassword(dto.getPassword());
        entity.setUsername(dto.getUsername());
        return entity;
    }

    private AdminDto toDto(Admin entity) {
        return AdminDto.builder()
                .adminId(entity.getAdminId())
                .username(entity.getUsername())
                .password(entity.getPassword())
                .build();
    }
}

