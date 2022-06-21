package org.acme;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Film {

    private String title;
    private Integer episode;
    private String director;
    private LocalDate releaseDate;

    public Film() {
        System.out.println("Default constructor called");
    }

    @JsonCreator
    public Film(
            @JsonProperty("title") final String title,
            @JsonProperty("episode") final int episode,
            @JsonProperty("director") final String director,
            @JsonProperty("releaseDate") final LocalDate releaseDate) {
        System.out.println("Parameterized constructor called");
        this.title = title;
        this.episode = episode;
        this.director = director;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return this.title;
    }

    public Integer getEpisode() {
        return this.episode;
    }

    public String getDirector() {
        return this.director;
    }

    public LocalDate getReleaseDate() {
        return this.releaseDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setEpisode(Integer episode) {
        this.episode = episode;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Title: ").append(this.title).append("\n");
        sb.append("Episode: ").append(this.episode).append("\n");
        sb.append("Director: ").append(this.director).append("\n");
        sb.append("ReleaseDate: ").append(this.releaseDate).append("\n");

        return sb.toString();
    }
}