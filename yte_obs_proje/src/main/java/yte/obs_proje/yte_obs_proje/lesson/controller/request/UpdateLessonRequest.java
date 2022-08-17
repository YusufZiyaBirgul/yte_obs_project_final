package yte.obs_proje.yte_obs_proje.lesson.controller.request;

import yte.obs_proje.yte_obs_proje.lesson.entity.Lesson;

import java.time.LocalDateTime;

public record UpdateLessonRequest(


        String name,
        String defination,
        String type,
        String code,

        LocalDateTime time,
        String room,
        String source,
        Long academicianId,
        Long assistantId
) {

    public Lesson toDomainEntity() {
        return new Lesson(name, defination, type, code, time, room, source,academicianId,assistantId);
    }
}
