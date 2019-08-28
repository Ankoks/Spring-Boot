package com.example.postgresdemo.repository;

import com.example.postgresdemo.model.Answer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    List<Answer> findByQuestionId(Long questionId);

    Page<Answer> findByQuestionId(Pageable pageable, Long questionId);

    @Modifying
    @Query("UPDATE Answer a SET a.text = :text WHERE a.id = :id")
    void updateApprovedStatus(@Param("id") Long id,
                              @Param("text") String text);
}
