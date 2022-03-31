package com.example.main.repositories;

import com.example.main.models.LinkModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LinkRepository extends JpaRepository<LinkModel, Long> {
    List<LinkModel> findAllByKlijentId(long clientId);
    List<LinkModel> findAllByKorisnikId(long userId);

}
