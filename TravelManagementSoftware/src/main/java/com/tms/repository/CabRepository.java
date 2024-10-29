package com.tms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tms.entity.Cab;

@Repository
public interface CabRepository extends JpaRepository<Cab,Integer> {

	@Query("Select b from Cab b where b.type = :type and status = \"available\"")
	List<Cab> findAllcabsByType(@Param("type") String type );
	
}
