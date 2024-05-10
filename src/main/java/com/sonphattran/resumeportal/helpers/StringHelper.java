package com.sonphattran.resumeportal.helpers;
import com.sonphattran.resumeportal.models.Skill;

import java.util.ArrayList;
import java.util.List;

public class StringHelper {
    public List<String> getDetails(String details) {
        String[] detail = details.split("-");
        List<String> result = new ArrayList<>();

        for (String s : detail) {
            if (!s.isBlank()) {
                result.add(s.strip());
            }
        }

        return result;
    }

    public static String joinSkills(List<Skill> skills) {
        StringBuilder builder = new StringBuilder();

        for (Skill skill : skills) {
            builder.append(skill.getName());
            builder.append("; ");
        }

        builder.deleteCharAt(builder.length() - 1);
        builder.deleteCharAt(builder.length() - 1);

        return builder.toString();
    }
}
