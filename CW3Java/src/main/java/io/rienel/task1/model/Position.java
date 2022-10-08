package io.rienel.task1.model;

import java.util.UUID;

public class Position {
    private UUID id;
    private String name;
    private Integer salary;

    public Position() {
    }

    public Position(UUID id, String name, Integer salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public static class Builder {
        private UUID id;
        private String name;
        private Integer salary;

        public Position build() {
            Position position = new Position();
            position.setId(id);
            position.setName(name);
            position.setSalary(salary);
            return position;
        }

        public Builder setId(UUID id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSalary(Integer salary) {
            this.salary = salary;
            return this;
        }
    }
}
