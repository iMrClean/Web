package ru.bmstu.lab03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bmstu.lab03.model.dto.TrackDTO;
import ru.bmstu.lab03.service.TrackService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TrackController {

    private final TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @GetMapping("/albums/{albumId}/tracks")
    public ResponseEntity<List<TrackDTO>> getAllTracks(@PathVariable Long albumId) {
        List<TrackDTO> allAlbums = trackService.findAll(albumId);
        return new ResponseEntity<>(allAlbums, HttpStatus.OK);
    }
}
