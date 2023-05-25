package com.sbs.dagachi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sbs.dagachi.repository.NotificationRepository;
import com.sbs.dagachi.vo.Notification;

@Service
public class NotificationService {

    private NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public List<Notification> getForPrintLiveNotification(int notification_id) {
		List<Notification> notifications = notificationRepository.getForPrintLiveNotification(notification_id);

		return notifications;
	}

	public void deleteNotification(int notification_id) {
		notificationRepository.setDelStatusToOne(notification_id);
    }
	
	public int getCountNotificationsDelstatusZero() {
	    return notificationRepository.getCountNotificationsDelstatusZero();
	}
}