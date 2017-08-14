package io.khasang.teamnote.entity;

public enum Priority {
    PRIORITY_LOW("низкий"),
    PRIORITY_MEDIUM("средний"),
    PRIORITY_HIGH("высокий");

    private String name;

    Priority(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  name;
    }
}
