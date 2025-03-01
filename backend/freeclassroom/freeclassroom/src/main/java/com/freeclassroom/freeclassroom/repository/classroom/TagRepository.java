package com.freeclassroom.freeclassroom.repository.classroom;
import com.freeclassroom.freeclassroom.entity.classroom.TagEntity;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;

@Registered
public interface TagRepository  extends JpaRepository<TagEntity,String> {
}
