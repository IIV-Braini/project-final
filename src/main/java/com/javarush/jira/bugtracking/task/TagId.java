package com.javarush.jira.bugtracking.task;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
@EqualsAndHashCode
@AllArgsConstructor
public class TagId implements Serializable {

    @Column(name = "task_id")
    private Long taskId;

    @Column(name = "tag")
    private String nameTag;

}
