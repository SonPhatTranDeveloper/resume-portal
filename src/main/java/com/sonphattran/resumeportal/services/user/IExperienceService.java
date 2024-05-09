package com.sonphattran.resumeportal.services.user;

import com.sonphattran.resumeportal.models.Experience;

import java.util.List;

public interface IExperienceService {
    void deleteExperienceByUserId(Long userId);
    void deleteExperienceById(Long expId);
    void saveAll(List<Experience> experiences);
}
