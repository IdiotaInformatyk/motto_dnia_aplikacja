package com.example.motto_dnia_aplikacja;

public class Mott {
    private final Integer id;
    private final String content;

    public Integer getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Mott(Integer id, String content) {
        this.id = id;
        this.content = content;
    }
}
