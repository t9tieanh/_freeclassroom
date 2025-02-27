package com.freeclassroom.freeclassroom.repository.classroom.post;

import com.freeclassroom.freeclassroom.entity.classroom.post.NoticeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeRepository extends JpaRepository<NoticeEntity, String> {
}
