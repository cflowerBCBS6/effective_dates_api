package com.bcbsnc.effective_dates.model;

public class GithubModel {
    private String name;
    private String path;
    private String sha;
    private float size;
    private String url;
    private String html_url;
    private String git_url;
    private String download_url;
    private String type;
    private String content;
    private String encoding;
    _links _linksObject;


    // Getter Methods

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public String getSha() {
        return sha;
    }

    public float getSize() {
        return size;
    }

    public String getUrl() {
        return url;
    }

    public String getHtml_url() {
        return html_url;
    }

    public String getGit_url() {
        return git_url;
    }

    public String getDownload_url() {
        return download_url;
    }

    public String getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public String getEncoding() {
        return encoding;
    }

    public _links get_links() {
        return _linksObject;
    }

    // Setter Methods

    public void setName(String name) {
        this.name = name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public void setGit_url(String git_url) {
        this.git_url = git_url;
    }

    public void setDownload_url(String download_url) {
        this.download_url = download_url;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public void set_links(_links _linksObject) {
        this._linksObject = _linksObject;
    }
}
class _links {
    private String self;
    private String git;
    private String html;


    // Getter Methods

    public String getSelf() {
        return self;
    }

    public String getGit() {
        return git;
    }

    public String getHtml() {
        return html;
    }

    // Setter Methods

    public void setSelf(String self) {
        this.self = self;
    }

    public void setGit(String git) {
        this.git = git;
    }

    public void setHtml(String html) {
        this.html = html;
    }
}