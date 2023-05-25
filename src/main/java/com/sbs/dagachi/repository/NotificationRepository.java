package com.sbs.dagachi.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sbs.dagachi.vo.Notification;

@Mapper
public interface NotificationRepository {
	List<Notification> getForPrintLiveNotification(int notification_id);

	public void setDelStatusToOne(int notification_id);
	
	int getCountNotificationsDelstatusZero();
}
