package com.example.Spring.Task2.service;

import com.example.Spring.Task2.dto.PanCardDto;
import com.example.Spring.Task2.dto.PersonDto;
import com.example.Spring.Task2.entity.PanCard;
import com.example.Spring.Task2.entity.Person;
import com.example.Spring.Task2.enums.Gender;
import com.example.Spring.Task2.repo.PanCardRepo;
import com.example.Spring.Task2.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * @Author ➤➤➤ pavaniB
 * @Date ➤➤➤ 29/04/23
 * @Time ➤➤➤ 9:56 am
 * @Project ➤➤➤ Spring Task-2
 */
@Service
public class ServiceImplement implements ServiceInt{
    @Autowired
    PersonRepo personRepo;
    @Autowired
    PanCardRepo panCardRepo;

    Person dtoToPerson(PersonDto personDto){
        Person person=new Person();
        person.setId(personDto.getId());
        person.setName(personDto.getName());
        person.setAddress(personDto.getAddress());
        person.setGender(personDto.getGender());
        if (personDto.getPanCard()!=null) {
            person.setPanCard(dtoToPanCard(personDto.getPanCard()));
        }
        return person;
    }
    PersonDto personToDto(Person person){
        PersonDto personDto=new PersonDto();
        personDto.setId(person.getId());
        personDto.setName(person.getName());
        personDto.setAddress(person.getAddress());
        personDto.setGender(person.getGender());
        if (person.getPanCard()!=null) {
            person.getPanCard().setPerson(null);
            personDto.setPanCard(panCardToDto(person.getPanCard()));
        }
        return personDto;
    }

    PanCard dtoToPanCard(PanCardDto panCardDto){
        PanCard panCard=new PanCard();
        panCard.setId(panCardDto.getId());
        panCard.setName(panCardDto.getName());
        panCard.setDateOfBirth(panCardDto.getDateOfBirth());
        panCard.setPanCardNumber(panCardDto.getPanCardNumber());
        if (panCardDto.getPerson()!=null){
            panCard.setPerson(dtoToPerson(panCardDto.getPerson()));
        }
        return panCard;
    }
    PanCardDto panCardToDto(PanCard panCard){
        PanCardDto panCardDto=new PanCardDto();
        panCardDto.setId(panCard.getId());
        panCardDto.setName(panCard.getName());
        panCardDto.setDateOfBirth(panCard.getDateOfBirth());
        panCardDto.setPanCardNumber(panCard.getPanCardNumber());
        if (panCard.getPerson()!=null){
            panCard.getPerson().setPanCard(null);
            panCardDto.setPerson(personToDto(panCard.getPerson()));
        }
        return panCardDto;
    }
    @Override
    public PersonDto savePerson(PersonDto personDto) {
        return personToDto(personRepo.save(dtoToPerson(personDto)));
    }

    public List<Person> findAllByPanCardIsNull(){
        return personRepo.findAllByPanCardIsNull();
    }
    public Long countOfPersonWhoseAgeIsUnder25(){
        return personRepo.countByPanCardDateOfBirthIsAfter(LocalDate.now().minusYears(25));
    }
    public List<PanCardDto> listOfPanCardWithPersonAgeIsUnder25(){
        return panCardRepo.findAllByDateOfBirthIsAfter(LocalDate.now().minusYears(25)).stream().map(this::panCardToDto).toList();
    }
    public List<PersonDto> findAllByAddress(String address){
        return personRepo.findAllByAddress(address).stream().map(this::personToDto).toList();
    }
    public List<PersonDto> findAllByName(String name){
        return personRepo.findAllByName(name).stream().map(this::personToDto).toList();
    }
    public List<PanCardDto> findAllByPanCardNumberStartsWithOrContains(String string){
        return panCardRepo.findAllByPanCardNumberStartsWithOrPanCardNumberContains(string,string).stream().map(this::panCardToDto).toList();
    }
    public Long countByGender(Gender gender){
        return personRepo.countByGender(gender);
    }

}
