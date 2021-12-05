package com.oxbey.footballManager.repository;

import com.oxbey.footballManager.entity.ClubEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRepository extends JpaRepository<ClubEntity, Long> {
}
