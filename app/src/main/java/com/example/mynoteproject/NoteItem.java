package com.example.mynoteproject;

public class NoteItem {
    public String title;
    public String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String toString()
    {
        return  title+ "-" +content;
    }
}
