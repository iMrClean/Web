package ru.bmstu.lab03.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class TrackDTO implements Serializable {

    private Long id;

    private String title;

    private String artist;

    private String description;

    private String src;

    private Long albumId;

}
