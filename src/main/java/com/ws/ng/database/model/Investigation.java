package com.ws.ng.database.model;



import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "investigation", schema = "public")
@TypeDefs({ @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)})
public class Investigation implements Model {
    @Id
    private String investigation_wsid;

    private String case_wsid;

    @Type(type = "jsonb")
    private ChapterNode chapterNodes;

    @OneToMany(fetch = FetchType.EAGER, mappedBy="investigation")
    private Set<Chapter> chapters;

    private Date createdOn;
    private String createdBy;
    private Date updatedOn;
    private String updatedBy;


    public String getInvestigation_wsid() {
        return investigation_wsid;
    }

    public void setInvestigation_wsid(String investigation_wsid) {
        this.investigation_wsid = investigation_wsid;
    }

    public String getCase_wsid() {
        return case_wsid;
    }

    public void setCase_wsid(String case_wsid) {
        this.case_wsid = case_wsid;
    }

    public ChapterNode getChapterNodes() {
        return chapterNodes;
    }

    public void setChapterNodes(ChapterNode chapterNodes) {
        this.chapterNodes = chapterNodes;
    }

    public Set<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(Set<Chapter> chapters) {
        this.chapters = chapters;
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
