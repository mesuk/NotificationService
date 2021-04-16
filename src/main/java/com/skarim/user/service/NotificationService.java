package com.skarim.user.service;

import com.skarim.user.domain.Notification;
import com.skarim.user.repository.NotificationRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService implements INotificationService {
    private static Log log = LogFactory.getLog(NotificationService.class);

    private NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public Notification saveNotification(Notification request) {

        Notification notification;

        notification = new Notification();
        notification.setUserId(request.getUserId());
        notification.setUserName(request.getUserName());
        notification.setEmail(request.getEmail());
        notification.setMobileNumber(request.getMobileNumber());
        notification.setMessage(request.getMessage());
        notificationRepository.save(notification);
        return notification;
    }

    @Override
    public boolean deleteNotification(Notification request) {
        notificationRepository.deleteById(request.getId());
        return true;
    }

    @Override
    public List<Notification> fetchAllNotification() {
        return notificationRepository.findAll();
    }

    @Override
    public List<Notification> findNotificationByUserName(String userName) {
        return notificationRepository.findAllByUserName(userName);
    }
}
