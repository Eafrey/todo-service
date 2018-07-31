package com.thoughtworks.traing.chensen.todoservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoInfo {
    private int id;
    private String content;

    @JsonProperty
    boolean readOnly() {
        return false;
    }

    @JsonProperty
    boolean complete() {
        return false;
    }

    @JsonProperty
    boolean visible() {
        return true;
    }
}
