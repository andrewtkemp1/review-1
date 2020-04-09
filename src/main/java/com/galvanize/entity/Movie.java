package com.galvanize.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.xml.transform.Result;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Movie {
    @JsonInclude
    private String Title;
    @JsonInclude
    private String url;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Model{" +
                "Title='" + Title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
