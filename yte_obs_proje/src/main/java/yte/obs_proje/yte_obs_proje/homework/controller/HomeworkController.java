package yte.obs_proje.yte_obs_proje.homework.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import yte.obs_proje.yte_obs_proje.common.response.MessageResponse;
import yte.obs_proje.yte_obs_proje.homework.controller.request.AddHomeworkRequest;
import yte.obs_proje.yte_obs_proje.homework.controller.request.UpdateHomeworkRequest;
import yte.obs_proje.yte_obs_proje.homework.controller.response.HomeworkQueryModel;
import yte.obs_proje.yte_obs_proje.homework.service.HomeworkService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/homeworks")
@Validated
@RequiredArgsConstructor
public class HomeworkController {


    private final HomeworkService homeworkService;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('Academician','Assistant')")
    public MessageResponse addExam(@Valid @RequestBody AddHomeworkRequest addExamRequest) {
        return homeworkService.addHomework(addExamRequest.toDomainEntity());
    }

    @PutMapping("{id}")
    @PreAuthorize("hasAnyAuthority('Academician','Assistant')")
    public MessageResponse updateExam(@Valid @RequestBody UpdateHomeworkRequest updateExamRequest, @PathVariable Long id) {
        return homeworkService.updateHomework(id, updateExamRequest.toDomainEntity());

    }

    @DeleteMapping("{id}")
    public MessageResponse getExamById(@PathVariable Long id) {
        return homeworkService.deleteHomeworkById(id);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('Academician','Assistant','Student')")
    public List<HomeworkQueryModel> getAllExams() {
        return homeworkService.getAllHomework()
                .stream()
                .map(homework -> new HomeworkQueryModel(homework))
                .toList();
    }

    @GetMapping("{id}")
    @PreAuthorize("hasAnyAuthority('Academician','Assistant','Student')")
    public HomeworkQueryModel getById(@PathVariable Long id) {
        return new HomeworkQueryModel(homeworkService.getById(id));
    }

}
