package com.example.challenge.challenge1.repository;

import com.example.challenge.challenge1.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository extends JpaRepository<Track, Integer> {

    public Track findByTrackArtist(String trackArtist);
    public Track findByTrackId(int trackId);
}
