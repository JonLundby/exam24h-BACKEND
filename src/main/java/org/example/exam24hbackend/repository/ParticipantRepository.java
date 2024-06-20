package org.example.exam24hbackend.repository;

import org.example.exam24hbackend.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant, Integer> {
}
