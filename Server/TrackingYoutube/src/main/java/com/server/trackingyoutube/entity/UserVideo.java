package com.server.trackingyoutube.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user_video")
public class UserVideo implements java.io.Serializable {
    @EmbeddedId
    private  UserVideoID id;

    private Float currentMin;

    private Float TotalMin;

    public UserVideoID getId() {
        return id;
    }

    public void setId(UserVideoID id) {
        this.id = id;
    }

    public Float getCurrentMin() {
        return currentMin;
    }

    public void setCurrentMin(Float currentMin) {
        this.currentMin = currentMin;
    }

    public Float getTotalMin() {
        return TotalMin;
    }

    public void setTotalMin(Float totalMin) {
        TotalMin = totalMin;
    }

    public UserVideo(UserVideoID id, Float currentMin, Float totalMin) {
        this.id = id;
        this.currentMin = currentMin;
        TotalMin = totalMin;
    }
    public UserVideo(){}
}
