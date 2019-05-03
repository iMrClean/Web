package ru.bmstu.lab03.model.entity;
import lombok.Getter;
import lombok.Setter;
import ru.bmstu.lab03.model.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Getter
@Setter
@Entity
@Table(name = "track")
public class Track extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "title")
    private String title;

    @Column(name = "artist")
    private String artist;

    @Column(name = "description")
    private String description;

    @Column(name = "src")
    private String src;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Track track = (Track) o;
        if (track.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), track.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Track{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", description='" + description + '\'' +
                ", src='" + src + '\'' +
                ", album=" + album +
                '}';
    }
}
