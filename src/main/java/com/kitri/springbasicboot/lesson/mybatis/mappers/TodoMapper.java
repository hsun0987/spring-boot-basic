package com.kitri.springbasicboot.lesson.mybatis.mappers;

import com.kitri.springbasicboot.lesson.mybatis.dto.RequestTodo;
import com.kitri.springbasicboot.lesson.mybatis.dto.ResponseTodo;
import com.kitri.springbasicboot.lesson.mybatis.todo.Todo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

// 기존 DAO 역할
@Mapper
public interface TodoMapper {
    List<ResponseTodo> findAll();
    ResponseTodo findById(Long id);
    void save(RequestTodo todo);
    void update(Long id);
    void deleteById(Long id);
}
