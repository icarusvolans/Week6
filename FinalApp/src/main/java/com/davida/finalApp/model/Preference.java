package com.davida.finalApp.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Preference {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String storeName;

    @ManyToMany(mappedBy = "preferences")
    private Collection<Department> departments;

    public Preference() {
        super();
    }

    public Preference(final String storeName) {
        super();
        this.storeName = storeName;
    }

    //

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(final String storeName) {
        this.storeName = storeName;
    }

    public Collection<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(final Collection<Department> departments) {
        this.departments = departments;
    }

/*    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Preference other = (Preference) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Preference [name=").append(name).append("]").append("[id=").append(id).append("]");
        return builder.toString();
    }*/
}
