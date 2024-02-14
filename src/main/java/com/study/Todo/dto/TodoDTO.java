package com.study.Todo.dto;

import com.study.Todo.entity.TodoEntity;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TodoDTO {
    private Long id;
    private String title;
    private boolean done;

    public TodoDTO(TodoEntity entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.done = entity.isDone();
    }

    public static TodoEntity toEntity(TodoDTO dto) {
        return TodoEntity.builder()
                .id(dto.getId())
                .title(dto.title)
                .done(dto.isDone())
                .build();
    }
}
