package com.example.project;

public record HealthRecord(String name, String details) {

    public String getName() {
        return name;
    }

    public String getDetails() {
        return details;
    }
}
