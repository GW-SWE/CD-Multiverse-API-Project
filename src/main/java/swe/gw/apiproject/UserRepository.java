package swe.gw.apiproject;
import org.springframework.data.repository.CrudRepository;
import swe.gw.apiproject.User;

public interface UserRepository extends CrudRepository<User, Integer>
{}
