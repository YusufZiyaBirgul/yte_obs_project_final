package yte.obs_proje.yte_obs_proje.exam.entity;

import lombok.Getter;
import lombok.Setter;
import yte.obs_proje.yte_obs_proje.common.entity.BaseEntity;
import yte.obs_proje.yte_obs_proje.lesson.entity.Lesson;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Exam extends BaseEntity {

    private String name;
    private String room;
    private String time;
    private String info;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "lesson_id", referencedColumnName = "ID")
    private Lesson lesson;

    public Exam() {
    }

    public Exam(String name, String room, String time, String info, Long lessonId) {
        this.name = name;
        this.room = room;
        this.time = time;
        this.info = info;

        this.lesson=new Lesson();
        this.lesson.setId(lessonId);
    }

    public void update(Exam updateExam) {
        this.name = updateExam.name;
        this.room = updateExam.room;
        this.time = updateExam.time;
        this.info = updateExam.info;

    }
}
