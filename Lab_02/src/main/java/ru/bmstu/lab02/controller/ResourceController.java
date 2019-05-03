package ru.bmstu.lab02.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
public class ResourceController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * Метод отображения html файла
     *
     * @return возвращает статический ресурс
     */
    @GetMapping(value = "/index", produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<InputStreamResource> getHtml() {

        log.info("Request to get html");
        long start = System.currentTimeMillis();

        ClassPathResource htmlFile = new ClassPathResource("static/index.html");
        InputStreamResource in = null;
        try {
            in = new InputStreamResource(htmlFile.getInputStream());
        } catch (IOException e) {
            log.error("Exception: ", e);
        }

        log.info("Request to get html finished in {} ms", (System.currentTimeMillis() - start));

        return ResponseEntity.ok()
                .contentType(MediaType.TEXT_HTML)
                .body(in);
    }

    /**
     * Метод отображения картинки 3
     *
     * @return возвращает картинку
     */
    @GetMapping(value = "/image", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<InputStreamResource> getImage() {

        log.info("Request to get image");
        long start = System.currentTimeMillis();

        ClassPathResource imgFile = new ClassPathResource("static/img.jpg");
        InputStreamResource in = null;
        try {
            in = new InputStreamResource(imgFile.getInputStream());
        } catch (IOException e) {
            log.error("Exception: ", e);
        }

        log.info("Request to get image finished in {} ms", (System.currentTimeMillis() - start));

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(in);
    }
}
