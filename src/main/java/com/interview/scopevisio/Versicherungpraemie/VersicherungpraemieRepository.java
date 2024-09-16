package com.interview.scopevisio.Versicherungpraemie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VersicherungpraemieRepository extends JpaRepository<Versicherungpraemie,Long> {
}
