package com.freeclassroom.freeclassroom.repository;

import com.freeclassroom.freeclassroom.entity.classroom.SectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends JpaRepository<SectionEntity, String> {
}
