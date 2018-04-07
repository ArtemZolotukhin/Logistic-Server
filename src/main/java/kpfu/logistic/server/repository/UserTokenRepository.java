package kpfu.logistic.server.repository;

import kpfu.logistic.server.entity.UserToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTokenRepository extends JpaRepository<UserToken, Long> {

    UserToken findOneByToken(String token);

}
