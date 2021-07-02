package com.gihanz.repositories;

import com.gihanz.entities.Duration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DurationRepository extends JpaRepository<Duration,Long> {
    Duration findByDegree_Id(Long id);
}
