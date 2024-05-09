package com.sonphattran.resumeportal.services.user;

import com.sonphattran.resumeportal.models.Experience;
import com.sonphattran.resumeportal.repositories.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceService implements IExperienceService {
    @Autowired
    private ExperienceRepository experienceRepository;

    @Override
    public void deleteExperienceByUserId(Long userId) {
        experienceRepository.deleteExperienceByUserId(userId);
    }

    @Override
    public void deleteExperienceById(Long expId) {
        experienceRepository.deleteExperienceById(expId);
    }

    @Override
    public void saveAll(List<Experience> experiences) {
        experienceRepository.saveAll(experiences);
    }
}
