package com.solum.aims.msp.persistence.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.solum.aims.msp.persistence.core.entity.Accesspoint;

@Repository("accesspointRepository")
public interface AccesspointRepository extends JpaRepository<Accesspoint, Long> {

	@Query(nativeQuery = true, value = "select e.code as labelId from accesspoint a join enddevice e ON e.accesspoint_id = a.id where e.state = 'TIMEOUT' and a.id = ?1")
	Object[] getErrorLabelByGw(long gw);

	@Query(nativeQuery = true, value = "select e.code as labelId from accesspoint a join enddevice e ON e.accesspoint_id = a.id where e.state = 'TIMEOUT'")
	Object[] getErrorLabelByGw();
	@Query(nativeQuery = true, value = "select e.accesspoint_id as id, a.name as name from accesspoint a join enddevice e ON e.accesspoint_id = a.id where e.state = 'TIMEOUT' or a.state = 'DISCONNECTED' group by e.accesspoint_id, a.name")
	List<Object[]> getGwList(String stationCode);
	@Query(nativeQuery = true,value = "select name from accesspoint where id= ?1")
	String findNameById(long gw);

}