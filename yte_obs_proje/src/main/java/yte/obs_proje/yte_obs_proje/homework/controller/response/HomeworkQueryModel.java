package yte.obs_proje.yte_obs_proje.homework.controller.response;

import yte.obs_proje.yte_obs_proje.homework.entity.Homework;

public record HomeworkQueryModel(
        Long id,
        String defination,
        String PDF,
        String endTime,
        Long assistantId,
        Long lessonId
) {
    public HomeworkQueryModel(Homework homework) {
        this(
                homework.getId(),
                homework.getDefination(),
                homework.getPDF(),
                homework.getEndTime(),

                homework.getLesson().getId(),
                homework.getAssistant().getId()

        );
    }
}
