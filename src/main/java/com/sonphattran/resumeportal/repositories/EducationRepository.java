package com.sonphattran.resumeportal.repositories;

import com.sonphattran.resumeportal.models.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("DELETE FROM Education education WHERE education.user.id = :userId")
    void deleteEducationByUserId(@Param("userId") Long userId);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("DELETE FROM Education education WHERE education.id = :educationId")
    void deleteEducationById(@Param("educationId") Long educationId);
}
