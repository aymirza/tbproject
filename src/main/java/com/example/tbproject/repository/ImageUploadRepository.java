package com.example.tbproject.repository;

import com.example.tbproject.model.ImageUpload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageUploadRepository extends JpaRepository<ImageUpload,Long> {
    Optional<ImageUpload> findByFilename(String filename);

}
