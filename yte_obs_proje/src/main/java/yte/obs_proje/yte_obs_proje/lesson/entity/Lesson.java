package yte.obs_proje.yte_obs_proje.lesson.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import yte.obs_proje.yte_obs_proje.academician.entity.Academician;
import yte.obs_proje.yte_obs_proje.assistant.entity.Assistant;
import yte.obs_proje.yte_obs_proje.common.entity.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Lesson extends BaseEntity {

    private String name;
    private String defination;
    private String type;
    private String code;
    private LocalDateTime time;
    private String room;
    private String source;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "academician_id", referencedColumnName = "ID")
    private Academician academician;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "assistant_id",referencedColumnName = "ID")
    private Assistant assistant;






    public Lesson(String name,
                  String defination,
                  String type,
                  String code,
                  LocalDateTime time, //localtime
                  String room,
                  String source,
                  Long academicianId,
                  Long assistantId) {

        this.name = name;
        this.defination = defination;
        this.type = type;
        this.code = code;
        this.time = time;
        this.room = room;
        this.source = source;

        this.academician = new Academician();
        this.academician.setId(academicianId);

        this.assistant = new Assistant();
        this.assistant.setId(assistantId);
    }


    public void update(Lesson updateLesson) {
        this.name = updateLesson.name;
        this.defination = updateLesson.defination;
        this.type = updateLesson.type;
        this.code = updateLesson.code;
        this.time = updateLesson.time;
        this.room = updateLesson.room;
        this.source = updateLesson.source;

        this.academician = updateLesson.academician;

        this.assistant=updateLesson.assistant;
    }
}
