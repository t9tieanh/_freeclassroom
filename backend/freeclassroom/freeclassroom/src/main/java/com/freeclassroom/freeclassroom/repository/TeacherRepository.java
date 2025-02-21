package com.freeclassroom.freeclassroom.repository;

import com.freeclassroom.freeclassroom.entity.user.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherEntity, String> {
}
