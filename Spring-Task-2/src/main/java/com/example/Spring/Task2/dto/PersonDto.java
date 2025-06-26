package com.example.Spring.Task2.dto;

import com.example.Spring.Task2.enums.Gender;
import lombok.Data;

/**
 * @Author ➤➤➤ pavaniB
 * @Date ➤➤➤ 29/04/23
 * @Time ➤➤➤ 9:52 am
 * @Project ➤➤➤ Spring Task-2
 */
@Data
public class PersonDto {
    Long id;
    String name;
    String address;
    Gender gender;
    PanCardDto panCard;
}
