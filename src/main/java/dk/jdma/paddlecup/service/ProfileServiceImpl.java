package dk.jdma.paddlecup.service;

import dk.jdma.paddlecup.domain.entity.Profile;
import dk.jdma.paddlecup.domain.enums.ProfileStatus;
import dk.jdma.paddlecup.domain.repository.AddressRepository;
import dk.jdma.paddlecup.domain.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;


@Service("profileService")
@Transactional
public class ProfileServiceImpl implements ProfileService, Serializable, UserDetailsService {

    private static final long serialVersionUID = -8001719142592674152L;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private AddressRepository addressRepository;

	public long countAllProfiles() {
        throw new UnsupportedOperationException("Implement me!");
    }

	public void deleteProfile(Profile profile) {
        throw new UnsupportedOperationException("Implement me!");
    }

	public Profile findProfile(Long id) {
        return profileRepository.findOne(id);
    }

	public List<Profile> findAllProfiles() {
        throw new UnsupportedOperationException("Implement me!");
    }

	public List<Profile> findProfileEntries(int firstResult, int maxResults) {
        throw new UnsupportedOperationException("Implement me!");
    }

	public Profile saveProfile(Profile profile) {
       if(profile.getAddress() != null) {
           addressRepository.save(profile.getAddress());
       }
       return profileRepository.save(profile);
    }

	public Profile updateProfile(Profile profile) {
        throw new UnsupportedOperationException("Implement me!");
    }

    @Override
    public Profile createProfile() {
        Profile user = new Profile();
        user.setStatus(ProfileStatus.ACTIVE);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return profileRepository.findByUserName(userName);
    }
}