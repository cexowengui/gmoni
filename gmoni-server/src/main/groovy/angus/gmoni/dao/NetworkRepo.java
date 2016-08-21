package angus.gmoni.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import angus.gmoni.domain.local.Network;


@Repository
public interface NetworkRepo extends CrudRepository<Network, String>{
	
	
	

}
