package com.example.inclassexamples_w20;

public class ToDo {
    private String todo;
    private int urgent;
    private int id;
    public ToDo(String todo, int urgent) {
        this.todo = todo;
        this.urgent = urgent;
    }
    public ToDo() {

    }
    @Override
    public String toString() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public void setUrgent(int urgent){
        this.urgent = urgent;
    }

    public String getTodo() {
        return todo;
    }

    public int getUrgent(){
        return urgent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
