package com.Pagination.Pagination.entity;

import com.Pagination.Pagination.Enum.TypesOfRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "courseName")
    private String courseName;
    @Enumerated (EnumType.STRING)
    private TypesOfRole typesOfRole;

    public Course(String courseName) {
        this.courseName = courseName;
    }

}
