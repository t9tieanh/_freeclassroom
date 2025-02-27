package com.freeclassroom.freeclassroom.repository.classroom;

import com.freeclassroom.freeclassroom.entity.classroom.ClassRoomEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRoomRepository extends JpaRepository<ClassRoomEntity,String> {
    @Query("SELECT c FROM ClassRoomEntity c " +
            "INNER JOIN c.teacher t " +
            "INNER JOIN t.account a " +
            "WHERE a.username = :username")
    Page<ClassRoomEntity> findByUsernameTeacher(@Param("username") String username, Pageable pageable);

}
