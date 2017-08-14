package io.khasang.teamnote.entity;

import javax.persistence.*;

@Entity
@Table(name = "status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id")
    private long id;

    @Column(name = "status_name")
    private String name;

    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id")
    private Task taskStatus;

    public Status() {
    }

    public Status(String name) {
        this.name = name;
    }

    public Status(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Status(String name, String description, Task taskStatus) {
        this.name = name;
        this.description = description;
        this.taskStatus = taskStatus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Task getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Task taskStatus) {
        this.taskStatus = taskStatus;
    }
}
