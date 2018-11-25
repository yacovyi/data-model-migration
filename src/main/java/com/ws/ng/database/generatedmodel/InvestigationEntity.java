package com.ws.ng.database.generatedmodel;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "investigation", schema = "public", catalog = "ws-ng-42")
public class InvestigationEntity {
    private String investigationWsid;
    private String caseWsid;
    private Object chapternodes;
    private String createdby;
    private Timestamp createdon;
    private String updatedby;
    private Timestamp updatedon;

    @Id
    @Column(name = "investigation_wsid")
    public String getInvestigationWsid() {
        return investigationWsid;
    }

    public void setInvestigationWsid(String investigationWsid) {
        this.investigationWsid = investigationWsid;
    }

    @Basic
    @Column(name = "case_wsid")
    public String getCaseWsid() {
        return caseWsid;
    }

    public void setCaseWsid(String caseWsid) {
        this.caseWsid = caseWsid;
    }

    @Basic
    @Column(name = "chapternodes")
    public Object getChapternodes() {
        return chapternodes;
    }

    public void setChapternodes(Object chapternodes) {
        this.chapternodes = chapternodes;
    }

    @Basic
    @Column(name = "createdby")
    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    @Basic
    @Column(name = "createdon")
    public Timestamp getCreatedon() {
        return createdon;
    }

    public void setCreatedon(Timestamp createdon) {
        this.createdon = createdon;
    }

    @Basic
    @Column(name = "updatedby")
    public String getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(String updatedby) {
        this.updatedby = updatedby;
    }

    @Basic
    @Column(name = "updatedon")
    public Timestamp getUpdatedon() {
        return updatedon;
    }

    public void setUpdatedon(Timestamp updatedon) {
        this.updatedon = updatedon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvestigationEntity that = (InvestigationEntity) o;
        return Objects.equals(investigationWsid, that.investigationWsid) &&
                Objects.equals(caseWsid, that.caseWsid) &&
                Objects.equals(chapternodes, that.chapternodes) &&
                Objects.equals(createdby, that.createdby) &&
                Objects.equals(createdon, that.createdon) &&
                Objects.equals(updatedby, that.updatedby) &&
                Objects.equals(updatedon, that.updatedon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(investigationWsid, caseWsid, chapternodes, createdby, createdon, updatedby, updatedon);
    }
}
