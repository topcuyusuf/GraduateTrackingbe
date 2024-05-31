package org.graduatetrackingsystem.graduatetracking.services;

import org.graduatetrackingsystem.graduatetracking.dtos.NotificationDto;
import org.graduatetrackingsystem.graduatetracking.dtos.NotificationRequest;

import java.util.List;

public interface NotifitaionService {
    List<NotificationDto> getAllNotification();
    NotificationDto createNotification (NotificationRequest notificationRequest);
    NotificationDto updateNotification(Long id, NotificationDto notificationDto);
}
