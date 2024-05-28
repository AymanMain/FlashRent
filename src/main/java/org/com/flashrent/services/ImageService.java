package org.com.flashrent.services;

import org.com.flashrent.entities.Image;
import org.com.flashrent.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageService {

    private final ImageRepository imageRepository;

    @Autowired
    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public Image addImage(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setImage(file.getBytes());
        return imageRepository.save(image);
    }

    public Image save(Image image) {
        return imageRepository.save(image);
    }


    public void deleteImage(Long id){
        imageRepository.deleteById(id);
    }
}