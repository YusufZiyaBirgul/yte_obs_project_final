package yte.obs_proje.yte_obs_proje.assistant.controller.request;

import yte.obs_proje.yte_obs_proje.assistant.entity.Assistant;

public record UpdateAssistantRequest(

        String name,
        String surname,
        String username,

        String password,

        Long academicianId
) {
    public Assistant toDomainEntity() {
        return new Assistant(name, surname, username, password,academicianId);
    }

}
