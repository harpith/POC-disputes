package com.disputes.poc.Entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name="complaints")
public class complaints {
    @Id
    private long id;
    private String text;
    private String label;
    private String issue;
    @Column(name="sub_issue")
    private String subIssue;

}
