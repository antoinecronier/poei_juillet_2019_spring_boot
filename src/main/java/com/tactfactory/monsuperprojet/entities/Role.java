package com.tactfactory.monsuperprojet.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tactfactory.monsuperprojet.database.contracts.RoleContract;

@Entity
@Table(name = RoleContract.TABLE)
@AttributeOverride(name = "id", column = @Column(name=RoleContract.COL_ID))
public class Role extends EntityDb {

    @JsonProperty(value = RoleContract.COL_NAME)
    @Column(name = RoleContract.COL_NAME, nullable = false)
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
