package domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Worker {
    private String id;//uuid
    private String username;
    private String password;
    private double balance;//余额
    private int workStatus;//工作状态 1/0
    private String workStatusStr;//工作状态 1：工作中/0：空闲
    private Date orderTime;//接单时间
    private String orderTimeStr;//接单时间字符串
    private int ordersCount;//接单数量

    public int getOrdersCount() {
        return ordersCount;
    }

    public void setOrdersCount(int ordersCount) {
        this.ordersCount = ordersCount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getworkStatus() {
        return workStatus;
    }

    public void setworkStatus(int workStatus) {
        this.workStatus = workStatus;
    }

    public String getworkStatusStr() {
        return workStatus == 1 ? "送单中" : "空闲";
    }

    public void setworkStatusStr(String workStatusStr) {
        this.workStatusStr = workStatusStr;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderTimeStr() {
        SimpleDateFormat sdf = new SimpleDateFormat();
        return sdf.format(orderTime);
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }
}
