package com.kitri.springbasicboot.lesson.mybatis.todo;

import com.kitri.springbasicboot.lesson.mybatis.dto.RequestTodo;
import com.kitri.springbasicboot.lesson.mybatis.dto.ResponseTodo;
import com.kitri.springbasicboot.lesson.mybatis.mappers.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/api/todos/")
public class TodoApiController {

    @Autowired
    TodoMapper todoMapper;

    @GetMapping("")
    public ArrayList<ResponseTodo> todos(){
        ArrayList<ResponseTodo> list = (ArrayList<ResponseTodo>) todoMapper.findAll();
        return list;
    }
    @PostMapping("")
    public void add(@RequestBody RequestTodo todo){
        todoMapper.save(todo);
    }
    @PutMapping("{id}")
    public void finish(@PathVariable Long id){
        todoMapper.update(id);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        todoMapper.deleteById(id);
    }
}
