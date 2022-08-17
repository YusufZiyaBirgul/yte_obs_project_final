package yte.obs_proje.yte_obs_proje.exam.controller.response;

import yte.obs_proje.yte_obs_proje.exam.entity.Exam;


public record ExamQueryModel(

        Long id,
        String name,
        String room,
        String time,
        String info,
        Long lessonId
) {


    public ExamQueryModel(Exam exam) {
        this(
                exam.getId(),
                exam.getName(),
                exam.getRoom(),
                exam.getTime(),
                exam.getInfo(),
                exam.getLesson().getId()

        );
    }


}
