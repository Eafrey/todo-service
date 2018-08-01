package com.thoughtworks.traing.chensen.todoservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "todo")
//@Where(clause = "delete = false")
@SQLDelete(sql = "UPDATE todo SET deleted = true WHERE id = ?")
public class TodoInfo {
    @Id
    @GeneratedValue
    private int id;


    private String content;

    @JsonProperty
    boolean readOnly() {
        return true;
    }

    @JsonProperty
    private boolean complete;
//    boolean complete() {
//        return false;
//    }


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "todo_id")
    private List<Task> tasks;

    @JsonProperty
    boolean visible() {
        return true;
    }

    @Column(columnDefinition = "DATETIME")
    private Date date;

//    @JsonProperty
//    long date() {
//        return new Date().getTime();
//    }
}
