package org.example.exam24hbackend.repository;

import org.example.exam24hbackend.entity.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplineRepository extends JpaRepository<Discipline, Integer> {
}
