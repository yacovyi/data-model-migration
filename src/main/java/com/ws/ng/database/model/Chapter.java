package com.ws.ng.database.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@IdClass(ChapterId.class)
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

    public String getChapterWSID() {
        return chapterWSID;
    }

    public void setChapterWSID(String chapterWSID) {
        this.chapterWSID = chapterWSID;
    }

    public Investigation getInvestigation() {
        return investigation;
    }

    public void setInvestigation(Investigation investigation) {
        this.investigation = investigation;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getChapterDescription() {
        return chapterDescription;
    }

    public void setChapterDescription(String chapterDescription) {
        this.chapterDescription = chapterDescription;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
