package com.example.Spring.Task2.repo;

import com.example.Spring.Task2.entity.Person;
import com.example.Spring.Task2.enums.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * @Author ➤➤➤ pavaniB
 * @Date ➤➤➤ 29/04/23
 * @Time ➤➤➤ 9:50 am
 * @Project ➤➤➤ Spring Task-2
 */

@Repository
public interface PersonRepo extends JpaRepository<Person,Long> {
    List<Person> findAllByPanCardIsNull();
    Long countByPanCardDateOfBirthIsAfter(LocalDate dateOfBirth);
    List<Person> findAllByAddress(String address);
    List<Person> findAllByName(String name);
    Long countByGender(Gender gender);
}
