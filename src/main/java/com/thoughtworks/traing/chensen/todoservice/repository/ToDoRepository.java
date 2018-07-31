package com.thoughtworks.traing.chensen.todoservice.repository;

import com.sun.tools.javac.comp.Todo;
import com.thoughtworks.traing.chensen.todoservice.model.Person;
import com.thoughtworks.traing.chensen.todoservice.model.TodoInfo;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ToDoRepository {
    public List<TodoInfo> list() {
        List<TodoInfo> res = new ArrayList<>();
        res.add(new TodoInfo(1, "todo1"));
        res.add(new TodoInfo(2, "todo2"));
        res.add(new TodoInfo(3, "todo3"));

        return  res;
    }

    public List<TodoInfo> getListFromFile(String fileName) {
        List<TodoInfo> res = new ArrayList<>();
        try {
            File file = new File(fileName);
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
            BufferedReader br = new BufferedReader(reader);
            String line = "";
            String jsonStr = "";
            while ((line = br.readLine()) != null) {
                jsonStr += line;
            }

            JSONObject jsonObject = new JSONObject(jsonStr);
            JSONArray todos = jsonObject.getJSONArray("todos");
            for(int i=0; i<todos.length(); i++) {
                JSONObject jo = (JSONObject) todos.get(i);
                int id = jo.getInt("id");
                String content = jo.getString("content");
                TodoInfo todoInfo = new TodoInfo(id, content);
                res.add(todoInfo);
            }
            System.out.print("todos" + res);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }

}
