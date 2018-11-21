package com.ws.ng.database.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

public class ChapterId implements Serializable {
    @Id
    @Column(name = "chapter_wsid")
    private String chapterWSID;

    @ManyToOne
    @Id
    @JoinColumn(name = "investigation_wsid")
    private Investigation investigation;

    public ChapterId() {
    }

    public ChapterId(String chapterWSID, Investigation investigation) {
        this.chapterWSID = chapterWSID;
        this.investigation = investigation;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChapterId chapterId = (ChapterId) o;
        return Objects.equals(chapterWSID, chapterId.chapterWSID) &&
                Objects.equals(investigation, chapterId.investigation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chapterWSID, investigation);
    }
}
