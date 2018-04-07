package kpfu.logistic.server.repository;

import kpfu.logistic.server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findOneByEmailAndPasswordCrypted(String email, String passwordCrypted);

    User findOneByPhoneNumberAndPasswordCrypted(String phoneNumber, String passwordCrypted);

}
