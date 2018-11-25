package com.ws.ng.database.generatedmodel;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "databasechangelog", schema = "public", catalog = "ws-ng-42")
public class DatabasechangelogEntity {
    private String id;
    private String author;
    private String filename;
    private Timestamp dateexecuted;
    private int orderexecuted;
    private String exectype;
    private String md5Sum;
    private String description;
    private String comments;
    private String tag;
    private String liquibase;
    private String contexts;
    private String labels;
    private String deploymentId;

    @Basic
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "filename")
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Basic
    @Column(name = "dateexecuted")
    public Timestamp getDateexecuted() {
        return dateexecuted;
    }

    public void setDateexecuted(Timestamp dateexecuted) {
        this.dateexecuted = dateexecuted;
    }

    @Basic
    @Column(name = "orderexecuted")
    public int getOrderexecuted() {
        return orderexecuted;
    }

    public void setOrderexecuted(int orderexecuted) {
        this.orderexecuted = orderexecuted;
    }

    @Basic
    @Column(name = "exectype")
    public String getExectype() {
        return exectype;
    }

    public void setExectype(String exectype) {
        this.exectype = exectype;
    }

    @Basic
    @Column(name = "md5sum")
    public String getMd5Sum() {
        return md5Sum;
    }

    public void setMd5Sum(String md5Sum) {
        this.md5Sum = md5Sum;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "comments")
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Basic
    @Column(name = "tag")
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Basic
    @Column(name = "liquibase")
    public String getLiquibase() {
        return liquibase;
    }

    public void setLiquibase(String liquibase) {
        this.liquibase = liquibase;
    }

    @Basic
    @Column(name = "contexts")
    public String getContexts() {
        return contexts;
    }

    public void setContexts(String contexts) {
        this.contexts = contexts;
    }

    @Basic
    @Column(name = "labels")
    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }

    @Basic
    @Column(name = "deployment_id")
    public String getDeploymentId() {
        return deploymentId;
    }

    public void setDeploymentId(String deploymentId) {
        this.deploymentId = deploymentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DatabasechangelogEntity that = (DatabasechangelogEntity) o;
        return orderexecuted == that.orderexecuted &&
                Objects.equals(id, that.id) &&
                Objects.equals(author, that.author) &&
                Objects.equals(filename, that.filename) &&
                Objects.equals(dateexecuted, that.dateexecuted) &&
                Objects.equals(exectype, that.exectype) &&
                Objects.equals(md5Sum, that.md5Sum) &&
                Objects.equals(description, that.description) &&
                Objects.equals(comments, that.comments) &&
                Objects.equals(tag, that.tag) &&
                Objects.equals(liquibase, that.liquibase) &&
                Objects.equals(contexts, that.contexts) &&
                Objects.equals(labels, that.labels) &&
                Objects.equals(deploymentId, that.deploymentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, filename, dateexecuted, orderexecuted, exectype, md5Sum, description, comments, tag, liquibase, contexts, labels, deploymentId);
    }
}
