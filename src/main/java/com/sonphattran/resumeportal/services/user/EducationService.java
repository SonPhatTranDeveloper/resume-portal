package com.sonphattran.resumeportal.services.user;

import com.sonphattran.resumeportal.models.Education;
import com.sonphattran.resumeportal.repositories.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationService implements IEducationService{
    @Autowired
    private EducationRepository educationRepository;

    @Override
    public void deleteEducationByUserId(Long userId) {
        educationRepository.deleteEducationByUserId(userId);
    }

    @Override
    public void deleteEducationById(Long educationId) {
        educationRepository.deleteEducationById(educationId);
    }

    @Override
    public void saveAll(List<Education> educations) {
        educationRepository.saveAll(educations);
    }
}
