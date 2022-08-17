package yte.obs_proje.yte_obs_proje.assistant.entity;


import lombok.Getter;
import lombok.Setter;
import yte.obs_proje.yte_obs_proje.academician.entity.Academician;
import yte.obs_proje.yte_obs_proje.common.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Assistant extends BaseEntity {


    private String name;
    private String surname;
    private String username;
    private String password;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "academician_id", referencedColumnName = "ID")
    private Academician academician;


    public Assistant() {
    }

    public Assistant(String name, String surname, String username, String password, Long academicianId) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;

        this.academician = new Academician();
        this.academician.setId(academicianId);


    }

    public void update(Assistant updateAssistant) {
        this.name = updateAssistant.name;
        this.surname = updateAssistant.surname;
        this.password = updateAssistant.password;

        this.academician = updateAssistant.academician;
    }
}

