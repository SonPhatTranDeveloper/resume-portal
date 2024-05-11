package com.sonphattran.resumeportal.repositories;

import com.sonphattran.resumeportal.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE User user SET user.firstName = :firstname, user.lastName = :lastname WHERE user.id = :id")
    void updateName(@Param(value = "id") Long id,
                         @Param(value = "firstname") String firstname,
                         @Param(value = "lastname") String lastname);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE User user SET user.visible = :visibility WHERE user.id = :id")
    void updateVisibility(@Param(value = "id") Long id, @Param(value = "visibility") boolean visibility);
}
