package yte.obs_proje.yte_obs_proje.assistant.controller.response;

import yte.obs_proje.yte_obs_proje.assistant.entity.Assistant;

public record AssistantQueryModel(

        Long id,
        String name,
        String surname,
        String username,
        String password,
        Long academicianId


) {

    public AssistantQueryModel(Assistant assistant) {
        this(
                assistant.getId(),
                assistant.getName(),
                assistant.getSurname(),
                assistant.getUsername(),
                assistant.getPassword(),
                assistant.getAcademician().getId()

        );
    }
}
