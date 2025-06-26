package com.example.Spring.Task2.repo;

import com.example.Spring.Task2.entity.PanCard;
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
public interface PanCardRepo extends JpaRepository<PanCard,Long> {
    List<PanCard> findAllByDateOfBirthIsAfter(LocalDate dateOfBirth);
    List<PanCard> findAllByPanCardNumberStartsWithOrPanCardNumberContains(String string1,String string2);
}
