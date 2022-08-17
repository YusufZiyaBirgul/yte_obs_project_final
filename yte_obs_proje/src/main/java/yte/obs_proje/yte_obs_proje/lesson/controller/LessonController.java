package yte.obs_proje.yte_obs_proje.lesson.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import yte.obs_proje.yte_obs_proje.common.response.MessageResponse;
import yte.obs_proje.yte_obs_proje.lesson.controller.request.AddLessonRequest;
import yte.obs_proje.yte_obs_proje.lesson.controller.request.UpdateLessonRequest;
import yte.obs_proje.yte_obs_proje.lesson.controller.response.LessonQueryModel;
import yte.obs_proje.yte_obs_proje.lesson.service.LessonService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lessons")
@Validated
public class LessonController {

    private final LessonService lessonService;

    @PostMapping
    @PreAuthorize("hasAuthority('Admin')")
    public MessageResponse addLesson(@RequestBody AddLessonRequest addLessonRequest) {
        return lessonService.addLesson(addLessonRequest.toDomainEntity());
    }

    @PutMapping("{id}")
    @PreAuthorize("hasAnyAuthority('Admin','Academician','Assistant')")
    public MessageResponse updateLesson(@Valid @RequestBody UpdateLessonRequest updateLessonRequest, @PathVariable Long id) {
        return lessonService.updateLesson(updateLessonRequest.toDomainEntity(), id);
    }


    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('Admin')")
    public MessageResponse deleteLessonById(@PathVariable Long id) {
        return lessonService.deleteLessonById(id);
    }


    @GetMapping()
    @PreAuthorize("hasAnyAuthority('Student','Admin','Academician','Assistant')")
    public List<LessonQueryModel> getAllLesson() {
        return lessonService.getAllLesson()
                .stream()
                .map(lesson -> new LessonQueryModel(lesson))
                .toList();
    }

    @GetMapping("{id}")
    @PreAuthorize("hasAnyAuthority('Admin','Academician','Assistant')")
    public LessonQueryModel getLessonById(@PathVariable Long id) {
        return new LessonQueryModel(lessonService.getLessonById(id));
    }

}
