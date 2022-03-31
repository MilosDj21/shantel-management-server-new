package com.example.main.repositories;

import com.example.main.models.LinkCheckModel;
import com.example.main.models.LinkModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LinkCheckRepository extends JpaRepository<LinkCheckModel, Long> {
    List<LinkCheckModel> findAllByKlijentId(long clientId);
    List<LinkCheckModel> findAllByKorisnikId(long userId);
}
