package org.uengine.process.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.uengine.process.domain.Activity;
import org.uengine.process.repository.ActivityRepository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ActivityServiceTest {

    @Autowired
    private ActivityService activityService;

    @Autowired
    private ActivityRepository activityRepository;

    @Test
    public void testActivityCreation() {
        Activity activity = new Activity();
        activity.setName("Test Activity");
        activity = activityRepository.save(activity);

        assertNotNull(activity.getId());
    }
}