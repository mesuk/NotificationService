package com.skarim.user.service;

import com.skarim.user.domain.Notification;

import java.util.List;

public interface INotificationService {
    public Notification saveNotification(Notification request);
    public boolean deleteNotification(Notification request);
    public List<Notification> fetchAllNotification();
    public List<Notification> findNotificationByUserName(String userName);
}
