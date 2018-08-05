package com.thoughtworks.traing.chensen.todoservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "todo")
@Where(clause = "deleted = false")
@SQLDelete(sql = "UPDATE todo SET deleted = true WHERE id = ?")
public class Todo {
    @Id
    @GeneratedValue
    private int id;

    private String content;

    @Column(name = "readonly")
    private boolean readOnly;

    private boolean complete;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "todo_id")
    private List<Task> tasks;

    private boolean visible;

    private boolean deleted;

    @Column(columnDefinition = "DATETIME")
    private Date date;

    public void setDate(Date date) {
        this.date = (Date) date.clone();
    }

    public Date getDate() {
        return (Date) date.clone();
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int createBy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public int getCreateBy() {
        return createBy;
    }

    public void setCreateBy(int createBy) {
        this.createBy = createBy;
    }
}
