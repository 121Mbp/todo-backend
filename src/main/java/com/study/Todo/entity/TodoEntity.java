package com.study.Todo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "todo")
@ToString
@Setter
@Getter
public class TodoEntity {
    @Id
    @SequenceGenerator(
            name = "todo_seq",
            sequenceName = "todo_SEQ",
            initialValue = 1,
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "todo_seq")
    private Long id;
    private String title;
    private String userId;
    private boolean done;
}