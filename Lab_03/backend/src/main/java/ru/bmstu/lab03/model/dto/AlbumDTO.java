package ru.bmstu.lab03.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class AlbumDTO implements Serializable {

    private Long id;

    private String title;

    private String genre;

    private String artist;

    private String description;

    private String src;

    private Set<TrackDTO> tracks = new HashSet<>();

}
