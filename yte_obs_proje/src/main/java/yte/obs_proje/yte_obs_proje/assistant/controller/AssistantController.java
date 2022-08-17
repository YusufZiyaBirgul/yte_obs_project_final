package yte.obs_proje.yte_obs_proje.assistant.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import yte.obs_proje.yte_obs_proje.assistant.controller.request.AddAssistantRequest;
import yte.obs_proje.yte_obs_proje.assistant.controller.request.UpdateAssistantRequest;
import yte.obs_proje.yte_obs_proje.assistant.controller.response.AssistantQueryModel;
import yte.obs_proje.yte_obs_proje.assistant.service.AssistantService;
import yte.obs_proje.yte_obs_proje.common.response.MessageResponse;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/assistant")
@Validated
public class AssistantController {

    private final AssistantService assistantService;

    @PostMapping
    @PreAuthorize("hasAuthority('Admin')")
    public MessageResponse addAssistant(@Valid @RequestBody AddAssistantRequest addAssistantRequest) {
        return assistantService.addAssistant(addAssistantRequest.toDomainEntity());
    }

    @PutMapping("{id}")
    @PreAuthorize("hasAuthority('Admin')")
    public MessageResponse updateAssistant(@Valid @RequestBody UpdateAssistantRequest updateAssistantRequest, @PathVariable Long id) {
        return assistantService.updateAssistant(id, updateAssistantRequest.toDomainEntity());

    }

    @DeleteMapping("{id}")
    public MessageResponse deleteAssistantById(@PathVariable Long id) {
        return assistantService.deleteAssistantById(id);
    }


    @GetMapping
    public List<AssistantQueryModel> getAllAssistants() {
        return assistantService.getAllAssistant()
                .stream()
                .map(assistant -> new AssistantQueryModel(assistant))
                .toList();
    }

    @GetMapping("{id}")
    public AssistantQueryModel getById(@PathVariable Long id) {
        return new AssistantQueryModel(assistantService.getById(id));
    }


}
