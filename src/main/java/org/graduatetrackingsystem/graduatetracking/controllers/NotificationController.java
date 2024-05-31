package org.graduatetrackingsystem.graduatetracking.controllers;

import org.graduatetrackingsystem.graduatetracking.ServiceIpml.NotifitionServiceImpl;
import org.graduatetrackingsystem.graduatetracking.dtos.NotificationDto;
import org.graduatetrackingsystem.graduatetracking.dtos.NotificationRequest;
import org.graduatetrackingsystem.graduatetracking.dtos.NotificationResponse;
import org.graduatetrackingsystem.graduatetracking.dtos.StudentDto;
import org.graduatetrackingsystem.graduatetracking.entities.Notification;
import org.graduatetrackingsystem.graduatetracking.reponses.StudentResponse;
import org.graduatetrackingsystem.graduatetracking.requests.StudentRequest;
import org.graduatetrackingsystem.graduatetracking.services.NotifitaionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notification")
@CrossOrigin
public class NotificationController {
    @Autowired
    NotifitaionService notificationService;
    @PostMapping("/create")
    public NotificationResponse createNotification(@RequestBody NotificationRequest newNotificationRequest) {
        return toResponse(notificationService.createNotification(newNotificationRequest));
    }
    @GetMapping("/getAllNotifications")
    public List<NotificationResponse> getBasketList(){
        List<NotificationResponse> getNotificationList= notificationService.getAllNotification().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
        return getNotificationList;
    }

    public NotificationResponse toResponse(NotificationDto dto) {
        // Return a new StudentResponse object, using the builder pattern
        return NotificationResponse.builder()
                .header(dto.getHeader())
                .body(dto.getBody())
                .id(dto.getId())
                .active(dto.isActive())
                .build();
        }

    }
}
