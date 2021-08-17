package com.skillstorm.mobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillstorm.mobile.models.Plan;

public interface PlanRepo extends JpaRepository<Plan, Integer> {

}
