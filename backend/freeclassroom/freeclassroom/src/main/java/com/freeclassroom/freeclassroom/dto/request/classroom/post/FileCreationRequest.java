package com.freeclassroom.freeclassroom.dto.request.classroom.post;

import org.springframework.web.multipart.MultipartFile;

public class PostCreationRequest {
    String title;
    String content;
    String sectionId;
    String fileUrl;
    MultipartFile file;
}
