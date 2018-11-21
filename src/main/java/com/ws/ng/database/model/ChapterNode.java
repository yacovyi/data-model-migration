package com.ws.ng.database.model;

import java.util.List;

public class ChapterNode {

    private String chapterNodeId;
    private List<ChapterNode> subChapterNodes;

    public String getChapterNodeId() {
        return chapterNodeId;
    }

    public void setChapterNodeId(String chapterNodeId) {
        this.chapterNodeId = chapterNodeId;
    }

    public List<ChapterNode> getSubChapterNodes() {
        return subChapterNodes;
    }

    public void setSubChapterNodes(List<ChapterNode> subChapterNodes) {
        this.subChapterNodes = subChapterNodes;
    }
}
