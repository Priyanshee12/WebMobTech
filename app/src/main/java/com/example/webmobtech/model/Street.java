
package com.example.webmobtech.model;


public class Street {

    private Integer number;
    private String name;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Street{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
}
