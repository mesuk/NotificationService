package com.skarim.user.controller;


import com.skarim.user.domain.Notification;
import com.skarim.user.object.BaseResponse;
import com.skarim.user.service.NotificationService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping("/notification")
@Api(tags = {"NotificationController"})
public class NotificationController {


    private NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping(value = "/saveNotification")
    public ResponseEntity<BaseResponse> saveNotification(HttpServletRequest requestHeader, @RequestBody Notification request) throws RuntimeException {

        Notification user = notificationService.saveNotification(request);

        BaseResponse baseResponse = new BaseResponse(getServerInfo());

        if(user != null){
            baseResponse.setData(user);
            return new ResponseEntity<>(baseResponse, HttpStatus.OK);

        }else{
            baseResponse.setData("Error occurred");
            return new ResponseEntity<>(baseResponse, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping(value = "/fetchAllNotification")
    public ResponseEntity<BaseResponse> fetchAllNotification() throws RuntimeException {
        BaseResponse baseResponse = new BaseResponse(getServerInfo());
        baseResponse.setData(notificationService.fetchAllNotification());
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/findNotificationByUserName")
    public ResponseEntity<BaseResponse> findNotificationByUserName(@RequestParam String mobileNumber) throws RuntimeException {
        BaseResponse baseResponse = new BaseResponse(getServerInfo());
        baseResponse.setData(notificationService.findNotificationByUserName(mobileNumber));
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @PostMapping(value = "/deleteNotification")
    public ResponseEntity<BaseResponse> deleteNotification(HttpServletRequest requestHeader, @RequestBody Notification request) throws RuntimeException {

        BaseResponse baseResponse = new BaseResponse(getServerInfo());
        baseResponse.setData(notificationService.deleteNotification(request));
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    private InetAddress getServerInfo(){
        try {
            InetAddress ip = InetAddress.getLocalHost();
            return ip;
        } catch (UnknownHostException e) {

            e.printStackTrace();
            return null;
        }
    }

}
