package io.khasang.teamnote.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long userIdCreator;
    private long userIdExecutor;
    private long statusId;
    private long priorityId;
    private long lableId;
    private String name;
    private String description;
    private LocalDateTime creationDate;
    private LocalDateTime issueDate;
    private LocalDateTime estimatedDate;
    private LocalDateTime updatedDate;
    private String color;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserIdCreator() {
        return userIdCreator;
    }

    public void setUserIdCreator(long userIdCreator) {
        this.userIdCreator = userIdCreator;
    }

    public long getUserIdExecutor() {
        return userIdExecutor;
    }

    public void setUserIdExecutor(long userIdExecutor) {
        this.userIdExecutor = userIdExecutor;
    }

    public long getStatusId() {
        return statusId;
    }

    public void setStatusId(long statusId) {
        this.statusId = statusId;
    }

    public long getPriorityId() {
        return priorityId;
    }

    public void setPriorityId(long priorityId) {
        this.priorityId = priorityId;
    }

    public long getLableId() {
        return lableId;
    }

    public void setLableId(long lableId) {
        this.lableId = lableId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDateTime issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDateTime getEstimatedDate() {
        return estimatedDate;
    }

    public void setEstimatedDate(LocalDateTime estimatedDate) {
        this.estimatedDate = estimatedDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
