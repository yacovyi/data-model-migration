package com.ws.ng.database.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "public.chapter")
public class Chapter implements Model {

    @Id
    @Column(name = "chapter_wsid")
    private String chapterWSID;

    @ManyToOne
    @Id
    @JoinColumn(name = "investigation_wsid")
    private Investigation investigation;

    @Column(name = "chapter_name")
    private String chapterName;

    @Column(name = "chapter_description")
    private String chapterDescription;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_on")
    private Date updatedOn;

    @Column(name = "updated_by")
    private String updatedBy;
}
