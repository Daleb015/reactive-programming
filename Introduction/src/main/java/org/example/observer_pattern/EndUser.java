package org.example.observer_pattern;

public class EndUser implements Observer{

    String name;

    public EndUser(String name,SubjectLibrary subjectLibrary) {
        this.name = name;
        subjectLibrary.subscribeObserver(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void update(String avail) {
        System.out.println("Hello "+name+"! we are glad to notify you that your book is now "+avail);
    }
}
