package web.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.boot.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {

}
