package com.example.challenge.challenge1.controller;

import com.example.challenge.challenge1.domain.Track;
import com.example.challenge.challenge1.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("trackdetails/v1/")
public class TrackController {

    private TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService){
        this.trackService = trackService;
    }

    @PostMapping("/track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track){
        return new ResponseEntity<>(trackService.addTrack(track), HttpStatus.CREATED);
    }

    @GetMapping("/tracks")
    public ResponseEntity<?> getAllTracks(){
        return new ResponseEntity<>(trackService.getAllTrack(),HttpStatus.OK);
    }

    @GetMapping("/tracks/{trackId}")
    public ResponseEntity<?> getTrackDetailsById(@PathVariable int trackId){
        return new ResponseEntity<>(trackService.getTrackById(trackId),HttpStatus.FOUND);
    }

    @DeleteMapping("/tracks/{trackId}")
    public ResponseEntity<?> deleteTrackById(@PathVariable int trackId){
        return new ResponseEntity<>(trackService.deleteTrackById(trackId),HttpStatus.OK);
    }

    @GetMapping("/track/{trackArtist}")
    public ResponseEntity<?> getTrackDetailByArtist(@PathVariable String trackArtist){
        return new ResponseEntity<>(trackService.getTrackByArtist(trackArtist),HttpStatus.FOUND);
    }

    @PutMapping("/tracks/{trackId}")
    public ResponseEntity<?> updateTrack(@RequestBody Track track, @PathVariable int trackId){
        return new ResponseEntity<>(trackService.updateTrackDetails(track,trackId),HttpStatus.OK);
    }
}
