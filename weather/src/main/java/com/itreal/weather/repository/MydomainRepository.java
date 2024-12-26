package com.itreal.weather.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.itreal.weather.entity.Mydomain;

@Repository
public interface MydomainRepository extends JpaRepository<Mydomain, Long>{
	
	@Query("SELECT m FROM Mydomain m WHERE m.pincode = :pincode")
	List<Mydomain> findByPincode(@Param("pincode") Long pincode);
	
	@Query("SELECT m FROM Mydomain m WHERE m.userId = :userId")
	List<Mydomain> findByUser(@Param("userId") String userId);
}
