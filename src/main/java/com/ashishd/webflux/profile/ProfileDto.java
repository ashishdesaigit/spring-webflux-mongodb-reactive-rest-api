package com.ashishd.webflux.profile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDto {
    String id;
    String firstName;
    String middleName;
    String lastName;
    String email;
    String education;
    String nativePlace;
    String occPlace;
    Boolean disability;
    LocalDateTime birthDateTime;
}
