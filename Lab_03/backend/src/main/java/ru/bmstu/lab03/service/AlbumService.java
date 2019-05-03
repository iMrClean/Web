package ru.bmstu.lab03.service;

import org.mapstruct.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bmstu.lab03.model.dto.AlbumDTO;
import ru.bmstu.lab03.model.entity.Album;
import ru.bmstu.lab03.repository.AlbumRepository;
import ru.bmstu.lab03.service.mapper.AlbumMapper;

@Service
@Transactional
public class AlbumService {

    private final AlbumRepository albumRepository;

    private final AlbumMapper albumMapper;

    @Autowired
    public AlbumService(AlbumRepository albumRepository, AlbumMapper albumMapper) {
        this.albumRepository = albumRepository;
        this.albumMapper = albumMapper;
    }

    public AlbumDTO findById(Long id) {
        Album album = albumRepository.findById(id).orElseThrow(
                () -> new RuntimeException("NotFound")
        );
        return albumMapper.toDto(album);
    }

    public Page<AlbumDTO> findAll(Pageable pageable) {
        return albumRepository.findAll(pageable)
                .map(albumMapper::toDto);
    }
}
