package com.freeclassroom.freeclassroom.repository;

import com.freeclassroom.freeclassroom.entity.classroom.ClassRoomEntity;
import com.freeclassroom.freeclassroom.entity.user.TeacherEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherEntity, String> {
    @Query("SELECT t FROM TeacherEntity t " +
            "INNER JOIN t.account a " +
            "WHERE a.username = :username")
    Optional<TeacherEntity> findByUsername(@Param("username") String username);
}
