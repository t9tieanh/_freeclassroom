package com.freeclassroom.freeclassroom.repository.classroom.post;

import com.freeclassroom.freeclassroom.entity.classroom.post.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity,String> {

    List<PostEntity> findBySection_Id(String id);
}
