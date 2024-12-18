package com.solum.aims.msp.persistence.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solum.aims.msp.persistence.core.entity.Station;

@Repository
public interface StationRepository extends JpaRepository<Station, Long> {

	Station findByCode(String stationCode);
}
