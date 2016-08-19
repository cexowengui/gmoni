package angus.gmoni.dao;

import org.springframework.data.repository.CrudRepository;

import angus.gmoni.domain.local.Deployment;

public interface DeploymentRepo extends CrudRepository<Deployment, String>{

}
