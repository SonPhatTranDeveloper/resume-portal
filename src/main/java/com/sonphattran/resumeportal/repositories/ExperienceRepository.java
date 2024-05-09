package com.sonphattran.resumeportal.repositories;

import com.sonphattran.resumeportal.models.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("DELETE FROM Experience experience WHERE experience.user.id = :userId")
    void deleteExperienceByUserId(@Param("userId") Long userId);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("DELETE FROM Experience experience WHERE experience.id = :expId")
    void deleteExperienceById(@Param("expId") Long expId);
}
