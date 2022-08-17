package yte.obs_proje.yte_obs_proje.assistant.controller.request;

import yte.obs_proje.yte_obs_proje.assistant.entity.Assistant;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public record AddAssistantRequest(

        @NotBlank
        @Size(max = 25)
        String name,
        @NotBlank
        @Size(max = 25)
        String surname,

        String username,


        String password,

        Long academicianId
) {

    public Assistant toDomainEntity() {
        return new Assistant(name, surname, username, password,academicianId);
    }
}
