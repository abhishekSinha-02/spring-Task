package com.example.Spring.Task2.entity;

import com.example.Spring.Task2.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author ➤➤➤ pavaniB
 * @Date ➤➤➤ 29/04/23
 * @Time ➤➤➤ 9:40 am
 * @Project ➤➤➤ Spring Task-2
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String address;
    @Enumerated(EnumType.STRING)
    Gender gender;
    @OneToOne(cascade = CascadeType.ALL)
    PanCard panCard;
}
