package org.uengine.process.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String tracingTag;
    private String iconURL;
    private int cost;
    private boolean hidden;
    private boolean dynamicChangeAllowed;
    private boolean queuingEnabled;
    private String activityIcon;
    private String statusCode;
    private boolean faultTolerant;
    // Other fields and relationships
}