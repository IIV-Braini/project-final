package com.javarush.jira.bugtracking.task;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class TagService {

    private final TagRepository repository;

    @Transactional
    public Tag create(Long task_id, String tagName) {
        Tag tag = new Tag(task_id, tagName);
        repository.addTag(task_id, tagName);
        return tag;
    }

    @Transactional
    public List<Tag> findAllTags() {
        return repository.findAllTags();
    }

    @Transactional
    public List<Tag> findTagsByTaskId(Long taskId) {
        return repository.findTagsByTaskId( taskId);
    }


}
