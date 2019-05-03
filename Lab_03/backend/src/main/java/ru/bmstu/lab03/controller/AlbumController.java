package ru.bmstu.lab03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bmstu.lab03.model.dto.AlbumDTO;
import ru.bmstu.lab03.service.AlbumService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AlbumController {

    private final AlbumService albumService;

    @Autowired
    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping("/albums/{id}")
    public ResponseEntity<AlbumDTO> getAlbum(@PathVariable Long id) {
        AlbumDTO result = albumService.findById(id);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/albums")
    public ResponseEntity<List<AlbumDTO>> getAllAlbums(Pageable pageable) {
        Page<AlbumDTO> allAlbums = albumService.findAll(pageable);
        return new ResponseEntity<>(allAlbums.getContent(), HttpStatus.OK);
    }

}
