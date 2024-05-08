package com.sonphattran.resumeportal.services.user;

import com.sonphattran.resumeportal.models.Skill;
import com.sonphattran.resumeportal.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService implements ISkillService{
    @Autowired
    private SkillRepository skillRepository;

    public void deleteSkillById(long skillId) {
        skillRepository.deleteSkillById(skillId);
    }

    public void deleteSkillByUserId(long userId) {
        skillRepository.deleteSkillByUserId(userId);
    }

    public void saveAll(List<Skill> skills) {
        skillRepository.saveAll(skills);
    }
}
