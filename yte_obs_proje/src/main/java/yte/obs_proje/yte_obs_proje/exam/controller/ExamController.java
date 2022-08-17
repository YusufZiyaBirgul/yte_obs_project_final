package yte.obs_proje.yte_obs_proje.exam.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import yte.obs_proje.yte_obs_proje.common.response.MessageResponse;
import yte.obs_proje.yte_obs_proje.exam.controller.request.AddExamRequest;
import yte.obs_proje.yte_obs_proje.exam.controller.request.UpdateExamRequest;
import yte.obs_proje.yte_obs_proje.exam.controller.response.ExamQueryModel;
import yte.obs_proje.yte_obs_proje.exam.service.ExamService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/exams")
public class ExamController {


    private final ExamService examService;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('Academician','Assistant')")
    public MessageResponse addExam(@Valid @RequestBody AddExamRequest addExamRequest) {
        return examService.addExam(addExamRequest.toDomainEntity());
    }

    @PutMapping("{id}")
    @PreAuthorize("hasAnyAuthority('Academician','Assistant')")
    public MessageResponse updateExam(@Valid @RequestBody UpdateExamRequest updateExamRequest, @PathVariable Long id) {
        return examService.updateExam(id, updateExamRequest.toDomainEntity());

    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAnyAuthority('Academician','Assistant')")
    public MessageResponse getExamById(@PathVariable Long id) {
        return examService.deleteExamById(id);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('Academician','Assistant','Student')")
    public List<ExamQueryModel> getAllExams() {
        return examService.getAllExam()
                .stream()
                .map(exam -> new ExamQueryModel(exam))
                .toList();
    }

    @GetMapping("{id}")
    public ExamQueryModel getById(@PathVariable Long id) {
        return new ExamQueryModel(examService.getById(id));
    }


}
