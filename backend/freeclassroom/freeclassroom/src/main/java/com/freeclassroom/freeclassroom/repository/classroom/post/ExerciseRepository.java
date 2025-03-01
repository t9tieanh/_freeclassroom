package com.freeclassroom.freeclassroom.repository.classroom.post;

import com.freeclassroom.freeclassroom.entity.classroom.post.ExerciseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends JpaRepository<ExerciseEntity, String> {
}
