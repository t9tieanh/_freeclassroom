package com.freeclassroom.freeclassroom.service.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class FileStorageService {

    private final Path baseDir;
    private final Path imageDir;
    private final Path documentDir;
    private final Path videoDir;
    private final Path otherDir;

    public FileStorageService(
            @Value("${file.base-dir}") String baseDir,
            @Value("${file.image-dir}") String imageDir,
            @Value("${file.document-dir}") String documentDir,
            @Value("${file.video-dir}") String videoDir,  @Value("${file.other-dir}") String otherFile) throws IOException {

        this.baseDir = Paths.get(baseDir).toAbsolutePath().normalize();
        this.imageDir = this.baseDir.resolve(imageDir);
        this.documentDir = this.baseDir.resolve(documentDir);
        this.videoDir = this.baseDir.resolve(videoDir);
        this.otherDir = this.baseDir.resolve(otherFile);

        // Tạo thư mục nếu chưa có
        Files.createDirectories(this.imageDir);
        Files.createDirectories(this.documentDir);
        Files.createDirectories(this.videoDir);
        Files.createDirectories(this.otherDir);
    }

    private String getFileExtension(String originalFilename) {
        int lastDotIndex = originalFilename.lastIndexOf(".");
        return (lastDotIndex == -1) ? "" : originalFilename.substring(lastDotIndex);
    }

    private String storeFile(MultipartFile file, Path targetDir) throws IOException {

        String fileExtension = getFileExtension(file.getOriginalFilename());
        String fileName = UUID.randomUUID() + fileExtension;
        Path targetLocation = targetDir.resolve(fileName);
        Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

        return fileName;
    }

    public String storeImage(MultipartFile file) throws IOException {
        return storeFile(file, imageDir);
    }

    public String storeDocument(MultipartFile file) throws IOException {
        return storeFile(file, documentDir);
    }

    public String storeVideo(MultipartFile file) throws IOException {
        return storeFile(file, videoDir);
    }

    public String storeOtherFile(MultipartFile file) throws IOException {
        return storeFile(file, otherDir);
    }
}