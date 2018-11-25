package com.ws.ng.database.generatedmodel;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "chapter", schema = "public", catalog = "ws-ng-42")
@IdClass(ChapterEntityPK.class)
public class ChapterEntity {
    private String chapterWsid;
    private String chapterDescription;
    private String chapterName;
    private String createdBy;
    private Timestamp createdOn;
    private String updatedBy;
    private Timestamp updatedOn;
    private String investigationWsid;

    @Id
    @Column(name = "chapter_wsid")
    public String getChapterWsid() {
        return chapterWsid;
    }

    public void setChapterWsid(String chapterWsid) {
        this.chapterWsid = chapterWsid;
    }

    @Basic
    @Column(name = "chapter_description")
    public String getChapterDescription() {
        return chapterDescription;
    }

    public void setChapterDescription(String chapterDescription) {
        this.chapterDescription = chapterDescription;
    }

    @Basic
    @Column(name = "chapter_name")
    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    @Basic
    @Column(name = "created_by")
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Basic
    @Column(name = "created_on")
    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    @Basic
    @Column(name = "updated_by")
    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Basic
    @Column(name = "updated_on")
    public Timestamp getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Timestamp updatedOn) {
        this.updatedOn = updatedOn;
    }

    @Id
    @Column(name = "investigation_wsid")
    public String getInvestigationWsid() {
        return investigationWsid;
    }

    public void setInvestigationWsid(String investigationWsid) {
        this.investigationWsid = investigationWsid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChapterEntity that = (ChapterEntity) o;
        return Objects.equals(chapterWsid, that.chapterWsid) &&
                Objects.equals(chapterDescription, that.chapterDescription) &&
                Objects.equals(chapterName, that.chapterName) &&
                Objects.equals(createdBy, that.createdBy) &&
                Objects.equals(createdOn, that.createdOn) &&
                Objects.equals(updatedBy, that.updatedBy) &&
                Objects.equals(updatedOn, that.updatedOn) &&
                Objects.equals(investigationWsid, that.investigationWsid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chapterWsid, chapterDescription, chapterName, createdBy, createdOn, updatedBy, updatedOn, investigationWsid);
    }
}
