package com.amdevelop.awsimageupload.datastore;

import com.amdevelop.awsimageupload.profile.UserProfile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class FakeUserProfileDataStore {

    private static final List<UserProfile> USER_PROFILES = new ArrayList<>();

    static {
        USER_PROFILES.add(new UserProfile(UUID.fromString("f60a993c-1ca5-488f-812f-5732eae49b5c"), "Janet Jones", null));
        USER_PROFILES.add(new UserProfile(UUID.fromString("a13bc1db-d48f-4731-ad21-d1b471476fdf"), "Antonio Junior", null));
        USER_PROFILES.add(new UserProfile(UUID.fromString("e9cfbb78-4eb6-45b7-a401-7b17c8604af4"), "Alex Rodriguez", null));
        USER_PROFILES.add(new UserProfile(UUID.fromString("405b2cb5-d749-4991-a1b3-9f15d77441a4"), "Silvia Rufete", null));
    }

    public List<UserProfile> getUserProfiles() {
        return USER_PROFILES;
    }
}
