package com.thoughtworks.traing.chensen.todoservice.repository;

import com.google.common.collect.ImmutableList;
import com.thoughtworks.traing.chensen.todoservice.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class PersonRepository {
    public List<Person> list() {
        List<Person> res = new ArrayList<>();

        res.add(new Person("ccc", "xi'an"));
        res.add(new Person("sss", "xi'an"));
        res.add(new Person("aaa", "xi'an"));

        return res;
    }
}
