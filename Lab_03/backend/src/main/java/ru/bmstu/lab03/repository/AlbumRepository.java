package ru.bmstu.lab03.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bmstu.lab03.model.entity.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
}
