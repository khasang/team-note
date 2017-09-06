package io.khasang.teamnote.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "TASKS")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "PARENT_ID",
            foreignKey = @ForeignKey(name = "FK_TASKS_PARENT_ID_TO_TASKS_ID"))
    private Task parentTask;

    @OneToMany(mappedBy = "parentTask", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<Task> subTasks;

    @ManyToOne
    @JoinColumn(name = "USER_ID_CREATOR",
            foreignKey = @ForeignKey(name = "FK_TASKS_USER_ID_CREATOR_TO_USERS_ID"))
    private User userCreator;

    @ManyToOne
    @JoinColumn(name = "USER_ID_EXECUTOR",
            foreignKey = @ForeignKey(name = "FK_TASKS_USER_ID_EXECUTOR_TO_USERS_ID"))
    private User userExecutor;

    @Column(name = "STATUS_ID")
    private long   statusId;
    @Column(name = "PRIORITY_ID")
    private long   priorityId;
    @Column(name = "LABLE_ID")
    private long   lableId;
    private String name;
    private String description;

    @Column(name = "CREATION_DATE")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime creationDate;

    @Column(name = "ISSUE_DATE")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime issueDate;

    @Column(name = "ESTIMATED_DATE")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime estimatedDate;

    @Column(name = "UPDATED_DATE")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime updatedDate;

    private String color;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUserCreator() {
        return userCreator;
    }

    public void setUserCreator(User userCreator) {
        this.userCreator = userCreator;
    }

    public User getUserExecutor() {
        return userExecutor;
    }

    public void setUserExecutor(User userExecutor) {
        this.userExecutor = userExecutor;
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

    public Task getParentTask() {
        return parentTask;
    }

    public void setParentTask(Task parentTask) {
        this.parentTask = parentTask;
    }

    public Set<Task> getSubTasks() {
        return subTasks;
    }

    public void setSubTasks(Set<Task> subTasks) {
        this.subTasks = subTasks;
    }

    public void addSubTasks(Task subTask) {
        subTask.setParentTask(this);
        getSubTasks().add(subTask);
    }

    public void removeSubTasks(Task subTask) {
        getSubTasks().remove(subTask);
    }
}
