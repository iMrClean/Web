package ru.bmstu.lab01.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class ResourceController {

    /**
     * Метод отображения текстового файла
     *
     * @return возвращает статический ресурс
     * @throws IOException ресурсов нет
     */
    @GetMapping(value = "/text", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<InputStreamResource> getTxt() throws IOException {

        ClassPathResource txtFile = new ClassPathResource("static/index.txt");
        InputStreamResource inputStreamResource = new InputStreamResource(txtFile.getInputStream());

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(inputStreamResource);
    }

    /**
     * Метод отображения txt файла как html
     *
     * @return возвращает статический ресурс
     * @throws IOException ресурсов нет
     */
    @GetMapping(value = "/hack", produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<InputStreamResource> getHtmlfromTxt() throws IOException {

        ClassPathResource htmlFile = new ClassPathResource("static/index.txt");
        InputStreamResource inputStreamResource = new InputStreamResource(htmlFile.getInputStream());

        return ResponseEntity
                .ok()
                .contentType(MediaType.TEXT_HTML)
                .body(inputStreamResource);
    }

    /**
     * Метод отображения html файла
     *
     * @return возвращает статический ресурс
     * @throws IOException ресурсов нет
     */
    @GetMapping(value = "/index", produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<InputStreamResource> getHtml() throws IOException {

        ClassPathResource htmlFile = new ClassPathResource("static/index.html");
        InputStreamResource inputStreamResource = new InputStreamResource(htmlFile.getInputStream());

        return ResponseEntity
                .ok()
                .contentType(MediaType.TEXT_HTML)
                .body(inputStreamResource);
    }

    /**
     * Метод отображения картинки 1
     *
     * @param response ответ
     * @throws IOException ресурсов нет
     */
    @GetMapping(value = "/image1", produces = MediaType.IMAGE_JPEG_VALUE)
    public void getImage1(HttpServletResponse response) throws IOException {

        ClassPathResource imgFile = new ClassPathResource("static/img.jpg");

        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(imgFile.getInputStream(), response.getOutputStream());
    }

    /**
     * Метод отображения картинки 2
     *
     * @return возвращает картинку
     * @throws IOException ресурсов нет
     */
    @GetMapping(value = "/image2", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage2() throws IOException {

        ClassPathResource imgFile = new ClassPathResource("static/img.jpg");
        byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(bytes);
    }

    /**
     * Метод отображения картинки 3 (предпочтительный способ)
     *
     * @return возвращает картинку
     * @throws IOException ресурсов нет
     */
    @GetMapping(value = "/image3", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<InputStreamResource> getImage3() throws IOException {

        ClassPathResource imgFile = new ClassPathResource("static/img.jpg");
        InputStreamResource inputStreamResource = new InputStreamResource(imgFile.getInputStream());

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(inputStreamResource);
    }
}
