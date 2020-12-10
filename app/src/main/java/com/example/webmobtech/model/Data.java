
package com.example.webmobtech.model;

import java.util.List;

public class Data {

    private List<Result> results = null;
    private Info info;

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Data{" +
                "results=" + results +
                ", info=" + info +
                '}';
    }
}
