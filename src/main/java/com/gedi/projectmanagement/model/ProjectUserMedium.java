package com.gedi.projectmanagement.model;

public class ProjectUserMedium {
    private String id; // 主键ID

    private String userId; // 用户ID

    private String aId; // 任务项ID

    private String pId; // 项目总计划表主键

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

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public ProjectUserMedium() {
    }

    public ProjectUserMedium(String id, String userId, String aId, String pId) {
        this.id = id;
        this.userId = userId;
        this.aId = aId;
        this.pId = pId;
    }

    @Override
    public String toString() {
        return "ProjectUserMedium{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", aId='" + aId + '\'' +
                ", pId='" + pId + '\'' +
                '}';
    }
}