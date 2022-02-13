package co.com.poli.tallerpds2.serviceuser.repository;

import co.com.poli.tallerpds2.serviceuser.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
