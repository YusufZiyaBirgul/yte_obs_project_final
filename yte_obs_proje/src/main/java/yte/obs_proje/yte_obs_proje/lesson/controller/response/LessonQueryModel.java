package yte.obs_proje.yte_obs_proje.lesson.controller.response;

import yte.obs_proje.yte_obs_proje.lesson.entity.Lesson;

import java.time.LocalDateTime;

public record LessonQueryModel(

        Long id,
        String name,
        String defination,
        String type,
        String code,

        LocalDateTime time,
        String room,
        String source
) {


    public LessonQueryModel(Lesson lesson) {
        this(
                lesson.getId(),
                lesson.getName(),
                lesson.getDefination(),
                lesson.getType(),
                lesson.getCode(),
                lesson.getTime(),
                lesson.getRoom(),
                lesson.getSource()
        );
    }
}
