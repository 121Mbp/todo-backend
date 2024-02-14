package com.study.Todo.dto;

import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ResponseDTO<T> {
    private String error;
    private List<T> data;
}
