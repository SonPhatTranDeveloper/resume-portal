package com.sonphattran.resumeportal.services.user;

import com.sonphattran.resumeportal.models.Education;

import java.util.List;

public interface IEducationService {
    void deleteEducationByUserId(Long userId);
    void saveAll(List<Education> educations);
}
