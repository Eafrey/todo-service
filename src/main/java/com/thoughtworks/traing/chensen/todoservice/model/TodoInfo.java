package com.thoughtworks.traing.chensen.todoservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "todo")
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
    boolean complete() {
        return false;
    }

    @JsonProperty
    boolean visible() {
        return true;
    }

    @JsonProperty
    long date() {
        return new Date().getTime();
    }
}
