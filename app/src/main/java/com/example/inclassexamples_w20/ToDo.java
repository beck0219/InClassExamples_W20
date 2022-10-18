package com.example.inclassexamples_w20;

public class ToDo {
    private String todo;
    private boolean urgent;
    public ToDo(String todo, boolean urgent) {
        this.todo = todo;
        this.urgent = urgent;
    }
    public String getTodo() {
        return todo;
    }
    public void setTodo(String todo) {
        this.todo = todo;
    }
    public void setUrgent(boolean urgent){
        this.urgent = urgent;
    }
    public boolean getUrgent(){
        return urgent;
    }

}
