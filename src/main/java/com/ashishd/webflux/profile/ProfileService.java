package com.ashishd.webflux.profile;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@Service
public class ProfileService {

    private ProfileRepository profileRepository;

    @Autowired
    public ProfileService(final ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public Mono<Profile> getProfile(String id){
        return this.profileRepository
                .findById(id);
    }

    public Mono<Profile> saveProfile(ProfileDto profile){
        Profile toSave = new ModelMapper().map(profile, Profile.class);
        return this.profileRepository.save(toSave);

    }

    public Flux<Profile> findAll() {
        return this.profileRepository.findAll();
    }
}
