package com.tactfactory.monsuperprojet.entities;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Role extends EntityDb {

    @NotNull
    private String name;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public Role(String name) {
        super();
        this.name = name;
    }

    public Role(int id, String name) {
        super();
        this.setId(id);
        this.name = name;
    }

    public Role() {
    }

    @Override
    public String toString() {
        return "Role [id=" + this.getId() + ", name=" + name + "]";
    }
}
