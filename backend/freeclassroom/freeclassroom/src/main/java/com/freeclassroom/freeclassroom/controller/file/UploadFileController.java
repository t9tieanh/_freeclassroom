package com.freeclassroom.freeclassroom.controller.file;

import com.freeclassroom.freeclassroom.service.utils.FileStorageService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/files")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UploadFileController {
    FileStorageService fileStorageService;

    @GetMapping("/image/{fileName}")
    public ResponseEntity<byte[]> getImageResized(@PathVariable String fileName) throws IOException {
        byte[] resizedImage = fileStorageService.resizeImage(fileName, 200, 200);

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG) // 🔥 Đặt MIME type phù hợp (có thể là PNG, JPEG,...)
//                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + file.getFilename() + "\"") // 🔥 Hiển thị file thay vì tải về
                .body(resizedImage);
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            String storedFileName = fileStorageService.storeFileAuto(file);
            return ResponseEntity.ok("File đã lưu thành công: " + storedFileName);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Lỗi lưu file: " + e.getMessage());
        }
    }

}
