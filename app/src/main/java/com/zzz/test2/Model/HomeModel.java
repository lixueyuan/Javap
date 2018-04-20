package com.zzz.test2.Model;

/**
 * Created by Administrator on 2018/4/20.
 */

public class HomeModel {
    private String id;
    private String name;
    private String age;
    public HomeModel () {
        super();
    }

    public HomeModel(String id,String name,String age) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
