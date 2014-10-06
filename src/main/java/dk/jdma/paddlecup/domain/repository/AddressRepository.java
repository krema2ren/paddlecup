package dk.jdma.paddlecup.domain.repository;

import dk.jdma.paddlecup.domain.entity.Address;
import dk.jdma.paddlecup.domain.entity.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address,String> {

}
