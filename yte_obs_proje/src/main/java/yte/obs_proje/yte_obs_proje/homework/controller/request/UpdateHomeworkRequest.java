package yte.obs_proje.yte_obs_proje.homework.controller.request;

import yte.obs_proje.yte_obs_proje.homework.entity.Homework;

public record UpdateHomeworkRequest(
        String defination,
        String PDF,
        String endTime,
        Long lessonId,
        Long assistantId
) {
    public Homework toDomainEntity() {
        return new Homework(defination, PDF, endTime, lessonId, assistantId);
    }
}
