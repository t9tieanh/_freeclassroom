package com.freeclassroom.freeclassroom.configuration;

import com.freeclassroom.freeclassroom.entity.user.TeacherEntity;
import com.freeclassroom.freeclassroom.repository.TeacherRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class AuditorAwareImpl implements AuditorAware<TeacherEntity> {

    TeacherRepository teacherRepository;

    @Override
    public Optional<TeacherEntity> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            return Optional.empty();
        }

        return teacherRepository.findByUsername(authentication.getName());
    }
}
