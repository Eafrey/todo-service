package com.thoughtworks.traing.chensen.todoservice.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.tools.javac.comp.Todo;
import com.thoughtworks.traing.chensen.todoservice.model.TodoInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface ToDoRepository extends JpaRepository<TodoInfo, Integer> {





//    @Value(value = "classpath:static/todo.json")
//    private Resource data;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//
//    public List<TodoInfo> list() {
//        List<TodoInfo> res = new ArrayList<>();
//        res.add(new TodoInfo(1, "todo1"));
//        res.add(new TodoInfo(2, "todo2"));
//        res.add(new TodoInfo(3, "todo3"));
//
//        return  res;
//    }
//
//    public List<TodoInfo> getListFromFile() throws IOException {
//        List<TodoInfo> res = new ArrayList<>();
//        String jsonStr = "";
//        try {
//            InputStreamReader reader = new InputStreamReader(data.getInputStream());
//            BufferedReader br = new BufferedReader(reader);
//            String line = "";
//            while ((line = br.readLine()) != null) {
//                jsonStr += line;
//            }
//
////            JSONObject jsonObject = new JSONObject(jsonStr);
////            JSONArray todos = jsonObject.getJSONArray("todos");
////            for(int i=0; i<todos.length(); i++) {
////                JSONObject jo = (JSONObject) todos.get(i);
////                int id = jo.getInt("id");
////                String content = jo.getString("content");
////                TodoInfo todoInfo = new TodoInfo(id, content);
////                res.add(todoInfo);
////            }
////            System.out.print("todos" + res);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        List<TodoInfo> list = objectMapper.readValue(jsonStr, new TypeReference<List<TodoInfo>>(){});
//
//        return list;
//    }

}
