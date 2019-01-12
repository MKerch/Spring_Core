package com.model;

public class Person {

    private String name;
    private int age;
    private double height;
    private double weight;
    private String position;
    private int salary;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        if (Double.compare(person.height, height) != 0) return false;
        if (Double.compare(person.weight, weight) != 0) return false;
        if (salary != person.salary) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        if (position != null ? !position.equals(person.position) : person.position != null) return false;
        return firstDayOfWork != null ? firstDayOfWork.equals(person.firstDayOfWork) : person.firstDayOfWork == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + salary;
        result = 31 * result + (firstDayOfWork != null ? firstDayOfWork.hashCode() : 0);
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getFirstDayOfWork() {
        return firstDayOfWork;
    }

    public void setFirstDayOfWork(String firstDayOfWork) {
        this.firstDayOfWork = firstDayOfWork;
    }

    private String firstDayOfWork;



}
