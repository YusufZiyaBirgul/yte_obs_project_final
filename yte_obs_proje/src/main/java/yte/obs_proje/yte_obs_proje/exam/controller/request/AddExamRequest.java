package yte.obs_proje.yte_obs_proje.exam.controller.request;

import yte.obs_proje.yte_obs_proje.exam.entity.Exam;

public record AddExamRequest(
        String name,
        String room,
        String time,
        String info,

        Long lessonId
) {
    public Exam toDomainEntity() {
        return new Exam(name, room,time,info,lessonId);

    }
}
