package com.maukaz.infotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maukaz.infotech.entites.ElectionApp;

@Repository
public interface ElectionRepository extends JpaRepository<ElectionApp, Integer> {

}
