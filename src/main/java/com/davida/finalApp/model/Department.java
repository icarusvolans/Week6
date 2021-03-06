package com.davida.finalApp.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;


@Entity
@Table(name = "department")
public class Department {

    @Id
    private long id;

    @NotNull
    private String name;

    @ManyToMany(mappedBy = "departments")
    private Collection<User> users;

    @ManyToMany
    @JoinTable(name = "departments_preferences", joinColumns = @JoinColumn(name = "department", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "preference_id", referencedColumnName = "id"))
    private Collection<Preference> preferences;



    public Department() {
        super();
    }

    public Department(final String name) {
        super();
        this.name = name;
    }

    //

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(final Collection<User> users) {
        this.users = users;
    }

    public Collection<Preference> getPreferences() {
        return preferences;
    }

    public void setPrivileges(final Collection<Preference> preferences) {
        this.preferences = preferences;
    }

/*    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Department department = (Department) obj;
        if (!department.equals(department.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Department [name=").append(name).append("]").append("[id=").append(id).append("]");
        return builder.toString();
    }*/
}