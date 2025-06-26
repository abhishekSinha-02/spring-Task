package com.example.Spring.Task2.controller;

import com.example.Spring.Task2.dto.PanCardDto;
import com.example.Spring.Task2.dto.PersonDto;
import com.example.Spring.Task2.entity.Person;
import com.example.Spring.Task2.enums.Gender;
import com.example.Spring.Task2.service.ServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author ➤➤➤ pavaniB
 * @Date ➤➤➤ 29/04/23
 * @Time ➤➤➤ 10:17 am
 * @Project ➤➤➤ Spring Task-2
 */
@RestController
@RequestMapping("/person")
public class Controller {
    @Autowired
    ServiceInt serviceInt;
    @PostMapping("/savePerson")
    PersonDto savePerson(@RequestBody PersonDto personDto){
        return serviceInt.savePerson(personDto);
    }
    @GetMapping("/findAllByPanCardIsNull")
    List<Person> findAllByPanCardIsNull(){
        return serviceInt.findAllByPanCardIsNull();
    }
    @GetMapping("/countOfPersonWhoseAgeIsUnder25")
    Long countOfPersonWhoseAgeIsUnder25(){
        return serviceInt.countOfPersonWhoseAgeIsUnder25();
    }
    @GetMapping("/listOfPanCardWithPersonAgeIsUnder25")
    List<PanCardDto> listOfPanCardWithPersonAgeIsUnder25(){
        return serviceInt.listOfPanCardWithPersonAgeIsUnder25();
    }
    @GetMapping("/findAllByAddress/{address}")
    List<PersonDto> findAllByAddress(@PathVariable String address){
        return serviceInt.findAllByAddress(address);
    }
    @GetMapping("/findAllByName/{name}")
    List<PersonDto> findAllByName(@PathVariable String name){
        return serviceInt.findAllByName(name);
    }
    @GetMapping("/findAllByPanCardNumberStartsWithOrContains/{string}")
    List<PanCardDto> findAllByPanCardNumberStartsWithOrContains(@PathVariable String string){
        return serviceInt.findAllByPanCardNumberStartsWithOrContains(string);
    }
    @GetMapping("/countByGender/{gender}")
    Long countByGender(@PathVariable Gender gender){
        return serviceInt.countByGender(gender);
    }
}
