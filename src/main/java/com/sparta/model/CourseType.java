package com.sparta.model;

public enum CourseType {
    JAVA("Java"),
    CSHARP("C#"),
    DATA("Data"),
    DEVOPS("DevOps"),
    BUSINESS("Business");

    private final String courseName;

    CourseType(String name) {
        this.courseName = name;
    }

    public String getCourseName() {
        return courseName;
    }
}