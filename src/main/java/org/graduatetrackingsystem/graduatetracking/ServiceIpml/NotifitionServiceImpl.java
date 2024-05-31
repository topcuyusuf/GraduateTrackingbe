package org.graduatetrackingsystem.graduatetracking.ServiceIpml;

import lombok.RequiredArgsConstructor;
import org.graduatetrackingsystem.graduatetracking.dtos.NotificationDto;
import org.graduatetrackingsystem.graduatetracking.dtos.NotificationRequest;
import org.graduatetrackingsystem.graduatetracking.entities.Notification;
import org.graduatetrackingsystem.graduatetracking.entities.Student;
import org.graduatetrackingsystem.graduatetracking.repositories.NotificationRepository;
import org.graduatetrackingsystem.graduatetracking.services.NotifitaionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotifitionServiceImpl implements NotifitaionService {
    @Autowired
    private final NotificationRepository notificationRepository;
    @Override
    public List<NotificationDto> getAllNotification() {
        return null;
    }

    @Override
    public NotificationDto createNotification(NotificationDto notificationDto) {
        Notification notification = toEntity(notificationDto, new Notification());
        return toDto(notificationRepository.save(notification));
    }

    @Override
    public NotificationDto updateNotification(Long id, NotificationDto notificationDto) {
        return null;
    }
    public NotificationDto toDto(Notification entity,NotificationDto dto) {
        dto.setId(entity.getId());
        dto.setHeader(entity.getHeader());
        dto.setBody(entity.getBody());
        dto.setActive(entity.isActive());
        return dto;
    }
    public static Notification toEntity(NotificationDto dto) {
        Notification notification = new Notification();
        notification.setId(dto.getId());
        notification.setHeader(dto.getHeader());
        notification.setBody(dto.getBody());
        notification.setActive(dto.isActive());
        return notification;
    }
}
