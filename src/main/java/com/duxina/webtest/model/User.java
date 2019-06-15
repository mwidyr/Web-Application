package com.duxina.webtest.model;

public class User {
    private Integer id;
    private String name;
    private Integer age;
    private String location;

    public User(Integer id, String name, Integer age, String location) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.location = location;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", location='").append(location).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
