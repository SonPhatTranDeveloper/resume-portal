package com.sonphattran.resumeportal.repositories;

import com.sonphattran.resumeportal.models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("DELETE FROM Skill skill WHERE skill.user.id = :userId")
    void deleteSkillByUserId(@Param("userId") long userId);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("DELETE FROM Skill skill WHERE skill.id = :skillId")
    void deleteSkillById(@Param("skillId") long skillId);
}
