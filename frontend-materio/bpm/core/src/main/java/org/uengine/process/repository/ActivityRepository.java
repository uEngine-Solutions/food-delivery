package org.uengine.process.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.uengine.process.domain.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}