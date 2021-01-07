package com.sparta.model;

public enum CourseType {
    JAVA("Java"),
    CSHARP("C#"),
    DATA("Data"),
    DEVOPS("DevOps"),
    BUSINESS("Business");

    private String courseName;

    public CourseType(String name) {
        this.courseName = name;
    }
}