package one.digitalinnovation.UserAPI.repository;

import one.digitalinnovation.UserAPI.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
