package com.example.challenge.challenge1.service;

import com.example.challenge.challenge1.domain.Track;
import com.example.challenge.challenge1.repository.TrackRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService{

    private TrackRepository trackRepository;

    public TrackServiceImpl(TrackRepository trackRepository){
        this.trackRepository = trackRepository;
    }

    @Override
    public Track addTrack(Track track) {
        return trackRepository.save(track);
    }

    @Override
    public List<Track> getAllTrack() {
        return trackRepository.findAll();
    }

    @Override
    public Track getTrackById(int trackId) {
        return trackRepository.findByTrackId(trackId);
    }

    @Override
    public boolean deleteTrackById(int trackId) {
        trackRepository.deleteById(trackId);
        return true;
    }

    @Override
    public Track getTrackByArtist(String trackArtist) {
        return trackRepository.findByTrackArtist(trackArtist);
    }

    @Override
    public Track updateTrackDetails(Track track, int trackId) {

        Optional<Track> optionalTrack = trackRepository.findById(trackId);

        if(optionalTrack.isEmpty()){
            return null;
        }

        Track existingTrack = optionalTrack.get();

        if(existingTrack.getTrackName() != null){
            existingTrack.setTrackName(track.getTrackName());
        }

        if(existingTrack.getTrackComments() != null){
            existingTrack.setTrackComments(track.getTrackComments());
        }
        if(existingTrack.getTrackArtist() != null){
            existingTrack.setTrackArtist(track.getTrackArtist());
        }
        if(existingTrack.getTrackRating() != 0){
            existingTrack.setTrackRating(track.getTrackRating());
        }

        return trackRepository.save(existingTrack);
    }
}
