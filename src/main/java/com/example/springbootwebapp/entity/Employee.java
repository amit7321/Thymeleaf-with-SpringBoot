package com.example.springbootwebapp.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Getter
@ToString
@Table(name = "tbl_employee")
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name ;
    private String email ;
    private String department ;
}
