package com.study.Todo.service;

import com.study.Todo.entity.TodoEntity;
import com.study.Todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    // 등록
    public List<TodoEntity> insert(TodoEntity entity) {
        validata(entity);
        todoRepository.save(entity);
        return todoRepository.findByUserId(entity.getUserId());
    }

    // 아이디 찾기
    public List<TodoEntity> retrieve(String userId) {
        return todoRepository.findByUserId(userId);
    }

    private void validata(TodoEntity entity) {
        if(entity == null)
            throw new RuntimeException("entity cannot be null");
        if(entity.getUserId() == null)
            throw new RuntimeException("unknown null");
    }

    public List<TodoEntity> update(TodoEntity entity) {
        validata(entity);
        final Optional<TodoEntity> original = todoRepository.findById(entity.getId());
        original.ifPresent(todo -> {
            todo.setTitle(entity.getTitle());
            todo.setDone(entity.isDone());
            todoRepository.save(todo);
        });
        return retrieve(entity.getUserId());
    }

    public List<TodoEntity> delete(TodoEntity entity) {
        validata(entity);
        try {
            todoRepository.delete(entity);
        } catch (Exception e) {
            throw new RuntimeException("error deleting entity" + entity.getId());
        }
        return retrieve(entity.getUserId());
    }
}
