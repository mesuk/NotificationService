package com.skarim.user.repository;

import com.skarim.user.domain.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends MongoRepository<Notification,String> {
    @Override
    List<Notification> findAll();

    List<Notification> findAllByMobileNumber(String mobileNumber);
    List<Notification> findAllByUserId(String userId);
    List<Notification> findAllByUserName(String userName);

    void deleteById(String id);
    long countAllByUserName(String userName);
}
