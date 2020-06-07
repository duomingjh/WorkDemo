package com.shw.workdemo.Bean;

public class user {
    private String id;
    private String name;
    private String passward;
    private String  siginature;

    public user() {
    }

    public user(String id, String name, String passward, String siginature) {
        this.id = id;
        this.name = name;
        this.passward = passward;
        this.siginature = siginature;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassward() {
        return passward;
    }

    public void setPassward(String passward) {
        this.passward = passward;
    }

    public String getSiginature() {
        return siginature;
    }

    public void setSiginature(String siginature) {
        this.siginature = siginature;
    }
}
