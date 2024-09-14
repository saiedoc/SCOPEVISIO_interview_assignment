package com.interview.scopevisio.Regionalzuordnung;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionalzuordnungRepository extends JpaRepository<Regionalzuordnung, Long> {

}
