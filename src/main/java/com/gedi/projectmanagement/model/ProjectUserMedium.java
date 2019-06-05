package com.gedi.projectmanagement.model;

public class ProjectUserMedium {
    private String id;

    private String userId;

    private String aId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getaId() {
        return aId;
    }

    public void setaId(String aId) {
        this.aId = aId;
    }

    public ProjectUserMedium() {
    }

    public ProjectUserMedium(String id, String userId, String aId) {
        this.id = id;
        this.userId = userId;
        this.aId = aId;
    }

    @Override
    public String toString() {
        return "ProjectUserMedium{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", aId='" + aId + '\'' +
                '}';
    }
}