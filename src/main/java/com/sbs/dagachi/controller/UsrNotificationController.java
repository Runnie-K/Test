package com.sbs.dagachi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sbs.dagachi.service.NotificationService;
import com.sbs.dagachi.vo.Notification;

@Controller
public class UsrNotificationController {

	private NotificationService notificationService;

	public UsrNotificationController(NotificationService notificationService) {
		this.notificationService = notificationService;
	}

	@RequestMapping("/notifications/check")
    public ResponseEntity<List<Notification>> checkNotification(@RequestParam(defaultValue = "1") int notification_id) {
        List<Notification> notifications = notificationService.getForPrintLiveNotification(notification_id);
        
        return ResponseEntity.ok(notifications);
    }

	@DeleteMapping("/notifications/delete")
	public ResponseEntity<Void> deleteNotification(@RequestParam int notification_id) {
		notificationService.deleteNotification(notification_id);
	    return ResponseEntity.ok().build();
	}

}
