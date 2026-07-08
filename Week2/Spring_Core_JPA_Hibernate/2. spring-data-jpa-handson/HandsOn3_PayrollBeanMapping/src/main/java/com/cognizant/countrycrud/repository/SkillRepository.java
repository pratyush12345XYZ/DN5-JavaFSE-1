package com.cognizant.countrycrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.countrycrud.model.Skill;

public interface SkillRepository extends JpaRepository<Skill, Integer> {

}