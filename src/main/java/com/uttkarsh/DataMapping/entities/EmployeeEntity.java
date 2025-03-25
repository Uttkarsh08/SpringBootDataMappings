package com.uttkarsh.DataMapping.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
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

}
