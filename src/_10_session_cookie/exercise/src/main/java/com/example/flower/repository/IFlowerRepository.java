package com.example.flower.repository;

import com.example.flower.model.Flower;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface IFlowerRepository extends JpaRepository<Flower, Integer> {

}
