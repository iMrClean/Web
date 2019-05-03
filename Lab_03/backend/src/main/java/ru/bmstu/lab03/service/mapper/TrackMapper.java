package ru.bmstu.lab03.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.bmstu.lab03.model.dto.TrackDTO;
import ru.bmstu.lab03.model.entity.Track;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AlbumMapper.class})
public interface TrackMapper extends EntityMapper<TrackDTO, Track> {

    @Mapping(source = "album.id", target = "albumId")
    TrackDTO toDto(Track track);

    @Mapping(source = "albumId", target = "album.id")
    Track toEntity(TrackDTO trackDTO);

    List<TrackDTO> toDto(List<Track> entityList);

    List<Track> toEntity(List<TrackDTO> dtoList);
}