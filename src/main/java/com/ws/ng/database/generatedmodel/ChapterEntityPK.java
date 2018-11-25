package com.ws.ng.database.generatedmodel;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ChapterEntityPK implements Serializable {
    private String chapterWsid;
    private String investigationWsid;

    @Column(name = "chapter_wsid")
    @Id
    public String getChapterWsid() {
        return chapterWsid;
    }

    public void setChapterWsid(String chapterWsid) {
        this.chapterWsid = chapterWsid;
    }

    @Column(name = "investigation_wsid")
    @Id
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
        ChapterEntityPK that = (ChapterEntityPK) o;
        return Objects.equals(chapterWsid, that.chapterWsid) &&
                Objects.equals(investigationWsid, that.investigationWsid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chapterWsid, investigationWsid);
    }
}
