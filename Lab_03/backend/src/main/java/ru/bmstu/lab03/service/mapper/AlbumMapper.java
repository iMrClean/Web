package ru.bmstu.lab03.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.bmstu.lab03.model.dto.AlbumDTO;
import ru.bmstu.lab03.model.entity.Album;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AlbumMapper extends EntityMapper<AlbumDTO, Album> {

    @Mapping(target = "tracks", ignore = true)
    AlbumDTO toDto(Album album);

    Album toEntity(AlbumDTO albumDTO);

    List<AlbumDTO> toDto(List<Album> entityList);

    List<Album> toEntity(List<AlbumDTO> dtoList);
}
