package com.javarush.jira.bugtracking.task;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "task_tag")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Tag {

    @EmbeddedId
    private TagId tagId;

    public Tag(Long taskId, String tagName){
        tagId = new TagId(taskId, tagName);
    }
}




/*
@Entity
@Table(name = "task_tag",
       uniqueConstraints = {@UniqueConstraint(columnNames = {"task_id", "tag"}, name = "uk_task_tag")})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Tag {

    @Id
    @Column(name = "task_id", nullable = false)
    @NotNull
    private Long taskId;


    @Column(name = "tag", nullable = false)
    @NotNull
    private String tagName;
}*/
