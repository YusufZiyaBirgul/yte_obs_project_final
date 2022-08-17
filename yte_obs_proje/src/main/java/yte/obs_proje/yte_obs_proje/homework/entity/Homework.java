package yte.obs_proje.yte_obs_proje.homework.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import yte.obs_proje.yte_obs_proje.assistant.entity.Assistant;
import yte.obs_proje.yte_obs_proje.common.entity.BaseEntity;
import yte.obs_proje.yte_obs_proje.lesson.entity.Lesson;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Homework extends BaseEntity {

    private String defination;
    private String PDF;
    private String endTime;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "assistant_id", referencedColumnName = "ID")
    private Assistant assistant;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "lesson_id", referencedColumnName = "ID")
    private Lesson lesson;

    public Homework(String defination, String PDF, String endTime, Long assistantId, Long lessonId) {
        this.defination = defination;
        this.PDF = PDF;
        this.endTime = endTime;

        this.lesson=new Lesson();
        this.lesson.setId(lessonId);

        this.assistant=new Assistant();
        this.assistant.setId(assistantId);

    }


    public void update(Homework updateHomework) {
        this.defination = updateHomework.defination;
        this.PDF = updateHomework.PDF;
        this.endTime = updateHomework.endTime;
    }
}
