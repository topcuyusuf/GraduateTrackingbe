package org.graduatetrackingsystem.graduatetracking.controllers;

import org.graduatetrackingsystem.graduatetracking.dtos.AdminDto;
import org.graduatetrackingsystem.graduatetracking.dtos.AdminLoginDto;
import org.graduatetrackingsystem.graduatetracking.dtos.StudentLoginDto;
import org.graduatetrackingsystem.graduatetracking.entities.Admin;
import org.graduatetrackingsystem.graduatetracking.reponses.AdminLoginResponse;
import org.graduatetrackingsystem.graduatetracking.reponses.AdminResponse;
import org.graduatetrackingsystem.graduatetracking.reponses.StudentLoginResponse;
import org.graduatetrackingsystem.graduatetracking.requests.AdminRequest;
import org.graduatetrackingsystem.graduatetracking.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/admins")
@CrossOrigin
public class AdminController {

@Autowired
    private  AdminService adminService;

    @GetMapping
    public List<AdminResponse> getAllAdmins(){
        List<AdminResponse> getAdminList = adminService.getAllAdmins().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
        return getAdminList;
    }

    @GetMapping("{id}")
    public AdminResponse getAdminById(@PathVariable(value = "id")long id){
        return toResponse(adminService.getAdminById(id));
    }

    @PostMapping
    public AdminResponse createAdmin(@RequestBody AdminRequest newAdminRequest) {
        return toResponse(adminService.createAdmin(newAdminRequest.toDto()));
    }
    @PutMapping("/{id}")
    public AdminResponse update(@PathVariable(name = "id")long id,@RequestBody AdminRequest request){
        return toResponse( adminService.updateAdmin(id,request.toDto()));
    }

    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
    }
    private AdminResponse toResponse(AdminDto dto) {
        return AdminResponse.builder()
                .adminId(dto.getAdminId())
                .password(dto.getPassword())
                .username(dto.getUsername())
                .build();
    }
    @PostMapping(path = "/login")
    public ResponseEntity<?> loginAdmin(@RequestBody AdminLoginDto adminLoginDto) {
        AdminLoginResponse admimLoginResponse = adminService.loginAdmin(adminLoginDto);
        return ResponseEntity.ok(admimLoginResponse);
    }

}