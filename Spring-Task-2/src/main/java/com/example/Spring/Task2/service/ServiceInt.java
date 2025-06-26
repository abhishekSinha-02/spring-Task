package com.example.Spring.Task2.service;

import com.example.Spring.Task2.dto.PanCardDto;
import com.example.Spring.Task2.dto.PersonDto;
import com.example.Spring.Task2.entity.Person;
import com.example.Spring.Task2.enums.Gender;
import java.util.List;

/**
 * @Author ➤➤➤ pavaniB
 * @Date ➤➤➤ 29/04/23
 * @Time ➤➤➤ 9:51 am
 * @Project ➤➤➤ Spring Task-2
 */
public interface ServiceInt {


    PersonDto savePerson(PersonDto personDto);

    //1.Find all persons who have no Pan Card
    List<Person> findAllByPanCardIsNull();

    //2.Count of Pan Cards whose Person age is under 25
    Long countOfPersonWhoseAgeIsUnder25();

    //3.Get all Pan Cards whose Person age is under 25
    List<PanCardDto> listOfPanCardWithPersonAgeIsUnder25();

    //4.Get all Persons who belongs to particular City
    List<PersonDto> findAllByAddress(String address);

    //5.Get all the details of the Persons who have same name
    List<PersonDto> findAllByName(String name);

    //6.Get all the Pan Cards whose Pan number starts with 'G' (or) Contains 'G'
    List<PanCardDto> findAllByPanCardNumberStartsWithOrContains(String string);

    //7.Count the Persons By Gender
    Long countByGender(Gender gender);
}
