package com.javarush.jira.bugtracking.task;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Slf4j
@RestController
@RequestMapping(value = TagController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;


    public static final String REST_URL = "/api/tags";

    @GetMapping("/task{id}")
    @Transactional
    public List<Tag> getAllTagsByTaskId(@PathVariable Long id) {
        log.info("get all Tags by task id={}", id);
        return tagService.findTagsByTaskId(id);
    }

    @GetMapping("/all")
    public List<Tag> getAllTags() {
        log.info("get all Tags");
        return tagService.findAllTags();
    }

    @PostMapping("/task{id}/{tagName}")
    public Tag createTag(@PathVariable Long id, @PathVariable String tagName){
        log.info("Create tag for task by id={} name tag={}" , id, tagName);
        return tagService.create(id, tagName);
    }

}
