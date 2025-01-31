package com.sayan.UrlShortner.repositories;

import com.sayan.UrlShortner.entities.UrlMapping;
import com.sayan.UrlShortner.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UrlMappingRepository extends JpaRepository<UrlMapping, Long> {
    UrlMapping findByShortUrl(String shortUrl);
    List<UrlMapping> findByUsers(Users user);
}
