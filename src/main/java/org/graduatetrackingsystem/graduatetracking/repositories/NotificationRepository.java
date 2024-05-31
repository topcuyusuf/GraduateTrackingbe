package org.graduatetrackingsystem.graduatetracking.repositories;

import org.graduatetrackingsystem.graduatetracking.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification,Long> {
}
