package com.freeclassroom.freeclassroom.entity.classroom.post;


import com.freeclassroom.freeclassroom.entity.classroom.SectionEntity;
import com.freeclassroom.freeclassroom.enums.FileTypeEnum;
import com.freeclassroom.freeclassroom.enums.PostIconEnum;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "file")
public class FileEntity extends PostEntity {
    String fileUrl;

    @PrePersist
    public void prePersist() {
        if (getPostIcon() == null) {
            setPostIcon(PostIconEnum.FILE);
        }
    }
}
