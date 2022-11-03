package com.example.challenge.challenge1.service;

import com.example.challenge.challenge1.domain.Track;

import java.util.List;

public interface TrackService {

    public Track addTrack(Track track);
    public List<Track> getAllTrack();
    public Track getTrackById(int trackId);
    public boolean deleteTrackById(int trackId);
    public Track getTrackByArtist(String trackArtist);
    public Track updateTrackDetails(Track track, int trackId);
}
