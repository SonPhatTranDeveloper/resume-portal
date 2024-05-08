package com.sonphattran.resumeportal.services.user;

import com.sonphattran.resumeportal.models.Skill;

import java.util.List;

public interface ISkillService {
    void deleteSkillById(long skillId);

    void deleteSkillByUserId(long userId);

    void saveAll(List<Skill> skills);
}
