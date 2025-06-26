package com.example.Spring.Task2.dto;

import lombok.Data;
import java.time.LocalDate;

/**
 * @Author ➤➤➤ pavaniB
 * @Date ➤➤➤ 29/04/23
 * @Time ➤➤➤ 9:52 am
 * @Project ➤➤➤ Spring Task-2
 */
@Data
public class PanCardDto {
    Long id;
    String panCardNumber;
    String name;
    LocalDate dateOfBirth;
    PersonDto person;
}
