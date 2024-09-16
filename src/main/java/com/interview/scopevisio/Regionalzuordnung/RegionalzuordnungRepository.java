package com.interview.scopevisio.Regionalzuordnung;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionalzuordnungRepository extends JpaRepository<Regionalzuordnung, Long> {
    // repository method to find Regionalzuordunung entries based on the postcode
    List<Regionalzuordnung> findByPostleitzahl(String postleitzahl);
}
