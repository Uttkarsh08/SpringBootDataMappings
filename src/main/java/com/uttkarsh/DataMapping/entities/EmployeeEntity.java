package com.uttkarsh.DataMapping.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String name;

    @OneToOne(mappedBy = "manager") //mappedBy used to tell hibernate, that we dont want another new one-to-one mapping,
    // but want to make 2way connection with existing mapping
    @JsonIgnore
    private DepartmentEntity department;

    @ManyToOne(cascade = CascadeType.ALL) //cascade defines the propogation of operations from parent to child(b/w mapped tables), here ALL indicated that if we delete a worker from department, in both tables this operation should be visible
    @JoinColumn(name = "worker_department_id", referencedColumnName = "id") //referencedColumnName tells the reference to which this table is connected to another table. It can be ignored here because by default, it will  be referenced using ID only
    @JsonIgnore
    private DepartmentEntity workerDepartment;

    //We are using self defined equals and hashcode, because By default, Java's equals() method (from Object class) checks if two references point to the same memory address, which is not ideal for entity comparisons.
    //In bidirectional relationships, one entity has a reference to another, and vice versa, If equals() and hashCode() use these references directly, it can lead to infinite loops during comparisons.
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeEntity employee = (EmployeeEntity) o;
        return Objects.equals(id, employee.id) && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
