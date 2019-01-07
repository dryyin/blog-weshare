package com.gitsck.pojo;

public class GUser {
    private Long uId;

    private String uUsername;

    private String uPassword;

    private Integer uRole;

    private String uLastime;

    private String uIp;

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public String getuUsername() {
        return uUsername;
    }

    public void setuUsername(String uUsername) {
        this.uUsername = uUsername == null ? null : uUsername.trim();
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword == null ? null : uPassword.trim();
    }

    public Integer getuRole() {
        return uRole;
    }

    public void setuRole(Integer uRole) {
        this.uRole = uRole;
    }

    public String getuLastime() {
        return uLastime;
    }

    public void setuLastime(String uLastime) {
        this.uLastime = uLastime == null ? null : uLastime.trim();
    }

    public String getuIp() {
        return uIp;
    }

    public void setuIp(String uIp) {
        this.uIp = uIp == null ? null : uIp.trim();
    }
}