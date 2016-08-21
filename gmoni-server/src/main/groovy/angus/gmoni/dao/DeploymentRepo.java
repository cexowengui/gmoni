package angus.gmoni.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import angus.gmoni.domain.local.Deployment;

@Repository
public interface DeploymentRepo extends CrudRepository<Deployment, String>{

}
