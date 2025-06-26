package com.example.Spring.Task2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @Author ➤➤➤ pavaniB
 * @Date ➤➤➤ 29/04/23
 * @Time ➤➤➤ 9:43 am
 * @Project ➤➤➤ Spring Task-2
 */

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PanCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(unique = true)
    String panCardNumber;
    String name;
    LocalDate dateOfBirth;
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "panCard")
    Person person;
}
