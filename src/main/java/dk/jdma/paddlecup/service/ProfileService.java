package dk.jdma.paddlecup.service;

import dk.jdma.paddlecup.domain.entity.Profile;

import java.util.List;


public interface ProfileService {

	public abstract long countAllProfiles();


	public abstract void deleteProfile(Profile profile);


	public abstract Profile findProfile(Long id);


	public abstract List<Profile> findAllProfiles();


	public abstract List<Profile> findProfileEntries(int firstResult, int maxResults);


	public abstract Profile saveProfile(Profile profile);


	public abstract Profile updateProfile(Profile profile);

    public abstract Profile createProfile();



}
