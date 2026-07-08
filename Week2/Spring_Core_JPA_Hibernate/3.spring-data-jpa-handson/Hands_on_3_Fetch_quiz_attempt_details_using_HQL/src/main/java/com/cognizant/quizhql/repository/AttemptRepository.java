package com.cognizant.quizhql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cognizant.quizhql.model.Attempt;

public interface AttemptRepository extends JpaRepository<Attempt, Integer> {

    @Query("""
        select distinct a
        from Attempt a
        join fetch a.user u
        join fetch a.attemptQuestions aq
        join fetch aq.question q
        left join fetch aq.attemptOptions ao
        where u.id=:userId
        and a.id=:attemptId
        """)
    Attempt getAttempt(@Param("userId") int userId,
                       @Param("attemptId") int attemptId);

}