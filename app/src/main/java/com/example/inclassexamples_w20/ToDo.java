package com.example.inclassexamples_w20;

public class ToDo {

    // INITIALIZATION OF CLASS VARIABLES
    private String todo;
    private int urgent;
    private int id;

    // A TODO METHOD THAT SETS THE VALUES OF OUR TWO VARIABLES
    public ToDo(String todo, int urgent) {
        this.todo = todo;
        this.urgent = urgent;
    }

    public ToDo() {

    }
    // wasn't returning name of the string todo - was showing whole package name isntead.
    @Override
    public String toString() {
        return todo;
    }

    // A METHOD TO SET THE VARIABLE TODO
    public void setTodo(String todo) {
        this.todo = todo;
    }

    // A METHOD TO SET THE VARIABLE URGENT
    public void setUrgent(int urgent){
        this.urgent = urgent;
    }

    // GETTER METHOD FOR THE TODO VARIABLE
    public String getTodo() {
        return todo;
    }

    // GETTER METHOD FOR THE URGENT VARIABLE
    public int getUrgent(){
        return urgent;
    }

    // Getter method for the id variable
    public int getId() {
        return id;
    }

    // Setter method for the id variable
    public void setId(int id) {
        this.id = id;
    }
}
