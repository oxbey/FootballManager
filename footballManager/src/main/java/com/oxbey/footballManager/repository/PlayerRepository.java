package com.oxbey.footballManager.repository;

import com.oxbey.footballManager.entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {
    Optional<PlayerEntity> findPlayerEntityById(Long id);
    Optional<PlayerEntity> findPlayerEntityByFirstName(String firstName);
    Optional<PlayerEntity> findPlayerEntityByLastName(String lastName);
    Optional<PlayerEntity> deletePlayerEntityByFirstName(String firstName);
    Optional<PlayerEntity> deletePlayerEntityByLastName(String lastName);
}
