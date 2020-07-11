package com.ashishd.webflux.profile;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

@RestController
@RequestMapping(value = "/profiles",produces = MediaType.APPLICATION_JSON_VALUE)
public class ProfileController {


    private ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping
    public Publisher<Profile> getAll(){
        return this.profileService.findAll();
    }

    @GetMapping("/{id}")
    public Publisher<Profile> getProfile(@PathVariable String id){
        return this.profileService.getProfile(id);
    }

    @PostMapping
    public Mono<ResponseEntity<Profile>> save(@RequestBody ProfileDto profileDto){
        return this.profileService
                .saveProfile(profileDto)
                .map( profile -> {
                    return ResponseEntity.created(URI.create("/profiles/" + profile.getId())).body(profile);
                });
    }
}
