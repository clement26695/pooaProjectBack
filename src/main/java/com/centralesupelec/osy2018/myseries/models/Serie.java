package com.centralesupelec.osy2018.myseries.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "serie")
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String description;
    private String image;
    private Long tmdbId;

    // We put it here because of the API we choose that does not provide
    // the information for the episode entity
    private Integer episodeRunTime;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "serie_genre", joinColumns = @JoinColumn(name = "serie_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "id"))
    private Set<Genre> genres = new HashSet<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "serie")
    private Set<Season> seasons = new HashSet<>();

    public Serie() {
    }

    public Serie(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public long getTmdbId() {
        return tmdbId;
    }

    public void setTmdbId(long tmdbId) {
        this.tmdbId = tmdbId;
    }

    public Set<Season> getSeasons() {
        return seasons;
    }

    public void setSeasons(Set<Season> seasons) {
        this.seasons = seasons;
    }

    public Integer getEpisodeRunTime() {
        return episodeRunTime;
    }

    public void setEpisodeRunTime(int episodeRunTime) {
        this.episodeRunTime = episodeRunTime;
    }

}
