package com.freeclassroom.freeclassroom.entity.classroom;

import com.freeclassroom.freeclassroom.entity.AbstractEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.hibernate.engine.internal.Cascade;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "tag")
public class TagEntity extends AbstractEntity {
    String name;
    String iconUrl;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "tag_classroom",
            joinColumns = @JoinColumn(name = "tag_id"),
            inverseJoinColumns = @JoinColumn(name = "classroom_id")
    )
    List<ClassRoomEntity> classrooms;
}
