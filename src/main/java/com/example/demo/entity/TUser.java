package com.example.demo.entity;


import com.example.demo.plugins.UserPasswordEncrypt;

import javax.persistence.*;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

@Entity
public class TUser extends  BaseEntity{


    @Column(unique = true,nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String tel;

    @Column(unique = true,nullable = true)
    private String wechat;

    @Column(unique = true,nullable = true)
    private String qq;

    @Column(nullable = false,unique = true)
    private String email;

    private Integer grade;




    @OneToMany(targetEntity = Schedule.class)
    private List<Schedule> scheduleList;



    @OneToMany(targetEntity = inkscreen.class)
    private  List<inkscreen> inkscreens;



    public List<Schedule> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }


    public List<inkscreen> getInkscreens() {
        return inkscreens;
    }

    public void setInkscreens(List<inkscreen> inkscreens) {
        this.inkscreens = inkscreens;
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

//    public void setPassword(String password) {
//        this.password = password;
//    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public void setPasswordT(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {

        this.password = UserPasswordEncrypt.encrypt(password, "abcdef" + strTo16(this.username) + "abcdef" + strTo16(this.username), 233);
    }

    public  void  setPassword(String password){
        this.password=password;
    }
    public boolean checkPassword(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {

        return this.password.equals(UserPasswordEncrypt.encrypt(password, "abcdef" + strTo16(this.username) + "abcdef" + strTo16(this.username), 233));
    }


    public static String strTo16(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            int ch = (int) s.charAt(i);
            String s4 = Integer.toHexString(ch);
            str = str + s4;
        }
        return str;
    }
    @Override
    public String toString() {
        return "TUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", tel='" + tel + '\'' +
                ", wechat='" + wechat + '\'' +
                ", qq='" + qq + '\'' +
                ", email='" + email + '\'' +
                ", grade=" + grade +
                ", scheduleList=" + scheduleList +
                '}';
    }
}
