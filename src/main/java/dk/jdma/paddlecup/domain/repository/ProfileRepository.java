package dk.jdma.paddlecup.domain.repository;

import dk.jdma.paddlecup.domain.entity.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends CrudRepository<Profile,Long> {

    Profile findByUserName(String userName);

}
