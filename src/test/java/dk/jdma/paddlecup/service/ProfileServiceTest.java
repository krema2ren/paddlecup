package dk.jdma.paddlecup.service;

import dk.jdma.paddlecup.domain.entity.Address;
import dk.jdma.paddlecup.domain.entity.Profile;
import dk.jdma.paddlecup.domain.enums.ProfileRole;
import dk.jdma.paddlecup.domain.enums.ProfileStatus;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@ContextConfiguration(locations = {"classpath:/META-INF/spring/applicationContext.xml","classpath:/META-INF/spring/applicationContext-persistence.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ProfileServiceTest {

    @Autowired
    ProfileService profileService;

    @Autowired
    AuditHistoryService auditHistoryService;

    @Test
    public void testCreatingProfile(){

        Profile user = profileService.createProfile();
        user.setFirstName("Anders");
        user.setLastName("Nielsen");
        user.setUserName("arne");
        user.setPassword("hemligt");
        user.setProfileRole(ProfileRole.ADMINISTRATOR);
        user.setPhoneMobile("+45 2948 2539");
        user.setStatus(ProfileStatus.ACTIVE);
        user.setUserHash("password");
        user.setDob(new Date());
        user.setEmail("anders@jdma.dk");
        Address address = new Address();
        address.setCity("Karise");
        address.setCountry("DK");
        address.setNumber("15");
        address.setStreet("Prins Buris Vej");
        address.setZip("4653");
        user.setAddress(address);

        profileService.saveProfile(user);

        Long id = user.getId();

        Profile foundUser = profileService.findProfile(id);
        Assert.assertEquals("Anders", user.getFirstName());
        System.out.println(foundUser.toString());
        Assert.assertNotNull(user.getCreatedDate());

        foundUser.setEmail("anders@jdma.dk");
        profileService.saveProfile(foundUser); // Should create a history record

        Profile auditUser = auditHistoryService.findAuditByRevision(Profile.class,2l,1);
        Assert.assertNotNull(auditUser);
        Profile found = profileService.findProfile(auditUser.getId());
        System.out.println(found.toString());


    }
}
