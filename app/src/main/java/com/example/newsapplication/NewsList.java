package com.example.newsapplication;

import java.util.ArrayList;

public class NewsList {

    private ArrayList<ModelClass> articles;

    public ArrayList<ModelClass> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<ModelClass> articles) {
        this.articles = articles;
    }




    public NewsList(ArrayList<ModelClass> articles) {
        this.articles = articles;
    }
}
