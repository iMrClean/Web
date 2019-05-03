package ru.bmstu.lab03.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bmstu.lab03.model.dto.TrackDTO;
import ru.bmstu.lab03.repository.TrackRepository;
import ru.bmstu.lab03.service.mapper.TrackMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TrackService {

    private final TrackRepository trackRepository;

    private final TrackMapper trackMapper;

    @Autowired
    public TrackService(TrackRepository trackRepository, TrackMapper trackMapper) {
        this.trackRepository = trackRepository;
        this.trackMapper = trackMapper;
    }

    public List<TrackDTO> findAll(Long albumId) {
        return trackRepository.findByAlbumId(albumId)
                .stream()
                .map(trackMapper::toDto).collect(Collectors.toList());
    }
}