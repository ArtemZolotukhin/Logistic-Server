package kpfu.logistic.server.repository;

import kpfu.logistic.server.entity.AcceptorInfo;
import kpfu.logistic.server.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findOneByEmailAndPasswordCrypted(String email, String passwordCrypted);

    User findOneByEmail(String email);

    User findOneByPhoneNumberAndPasswordCrypted(String phoneNumber, String passwordCrypted);

    User findOneByPhoneNumber(String phoneNumber);

    @Query(value = "SELECT a FROM AcceptorInfo a WHERE a.user=?1")
    AcceptorInfo acceptorInfoByUser(User user);

}
