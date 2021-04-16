package com.skarim.user.object;

import java.net.InetAddress;

public class BaseResponse {
    private InetAddress notificationServer;
    private Object data;

    public BaseResponse() {
    }

    public BaseResponse(InetAddress notificationServer) {
        this.notificationServer = notificationServer;
    }

    public InetAddress getNotificationServer() {
        return notificationServer;
    }

    public void setNotificationServer(InetAddress notificationServer) {
        this.notificationServer = notificationServer;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
