package com.zt.es.entity;

import com.zt.constants.SysConst;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Date;

@Document(indexName = SysConst.INDEX, type = SysConst.ARTICLE)
public class EsArticle implements Serializable {
    private static final long serialVersionUID = 9201034849892179274L;

    @Id
    private String articleId;

    private String title;// 标题

    private String media;// 媒体名称

    private String mediaType;    //媒体类型

    private String content;// 内容

    private Date publishDateTime;// 发布日期时间

    private String publishDate;// 发布日期

    private String author;// 作者

    private String keywords;// 关键词

    private String url;// 原文链接

    private String urlMD5;// url的MD5值

    private String crawlerDate;// 采集时间，格式：yyyy-MM-dd

    private Date crawlerDateTime;// 采集时间

    private String articleFingerprint;//文章指纹

    private Integer hot;//热度

    private String isAnalyzed;//是否已经分析，已经分析：是；未分析：否

    private String taskId;//晴空系统的采集任务id，用于到晴空系统中反查数据

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishDateTime() {
        return publishDateTime;
    }

    public void setPublishDateTime(Date publishDateTime) {
        this.publishDateTime = publishDateTime;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlMD5() {
        return urlMD5;
    }

    public void setUrlMD5(String urlMD5) {
        this.urlMD5 = urlMD5;
    }

    public String getCrawlerDate() {
        return crawlerDate;
    }

    public void setCrawlerDate(String crawlerDate) {
        this.crawlerDate = crawlerDate;
    }

    public Date getCrawlerDateTime() {
        return crawlerDateTime;
    }

    public void setCrawlerDateTime(Date crawlerDateTime) {
        this.crawlerDateTime = crawlerDateTime;
    }

    public String getArticleFingerprint() {
        return articleFingerprint;
    }

    public void setArticleFingerprint(String articleFingerprint) {
        this.articleFingerprint = articleFingerprint;
    }

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }

    public String getIsAnalyzed() {
        return isAnalyzed;
    }

    public void setIsAnalyzed(String isAnalyzed) {
        this.isAnalyzed = isAnalyzed;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    @Override
    public String toString() {
        return "EsArticle{" +
                "articleId='" + articleId + '\'' +
                ", title='" + title + '\'' +
                ", media='" + media + '\'' +
                ", mediaType='" + mediaType + '\'' +
                ", content='" + content + '\'' +
                ", publishDateTime=" + publishDateTime +
                ", publishDate='" + publishDate + '\'' +
                ", author='" + author + '\'' +
                ", keywords='" + keywords + '\'' +
                ", url='" + url + '\'' +
                ", urlMD5='" + urlMD5 + '\'' +
                ", crawlerDate='" + crawlerDate + '\'' +
                ", crawlerDateTime=" + crawlerDateTime +
                ", articleFingerprint='" + articleFingerprint + '\'' +
                ", hot=" + hot +
                ", isAnalyzed='" + isAnalyzed + '\'' +
                ", taskId='" + taskId + '\'' +
                '}';
    }
}
