package com.javarush.jira.bugtracking.task;

import com.javarush.jira.common.BaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface TagRepository extends BaseRepository<Tag> {

    @Query("SELECT t FROM Tag t")
    List<Tag> findAllTags();

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO task_tag (task_id, tag) VALUES (:taskId, :tagName)", nativeQuery = true)
    void addTag(@Param("taskId") Long taskId, @Param("tagName") String tagName);

    @Transactional
    @Query("SELECT t FROM Tag t WHERE t.tagId.taskId =:taskId")
    List<Tag> findTagsByTaskId(Long taskId);
}
