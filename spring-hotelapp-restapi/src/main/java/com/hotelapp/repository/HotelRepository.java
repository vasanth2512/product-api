package com.hotelapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hotelapp.models.Hotel;


@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {

	List<Hotel> findByAddressCity(String city);
	
	
	
	@Query("From Hotel h INNER JOIN h.menulist ml WHERE ml.iname=?1")
	List<Hotel> findByHotelMenu(String menu);
	
}
