package com.canpepfrit.apicanpepfrit.repositories;

import com.canpepfrit.apicanpepfrit.models.Accommodation;
import com.canpepfrit.apicanpepfrit.models.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface RepoActivityLog extends JpaRepository<ActivityLog, Long> {
    List<ActivityLog> findActivityLogByAccommodation(Long id);
}
