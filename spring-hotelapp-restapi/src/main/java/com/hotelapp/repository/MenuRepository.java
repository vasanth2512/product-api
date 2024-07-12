package com.hotelapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hotelapp.models.Menu;

@Repository
public interface MenuRepository extends  JpaRepository<Menu, Integer>{

	
	
	@Query("FROM Menu m INNER JOIN m.hotel h WHERE h.hotelname=?1 ")
	List<Menu> findMenuBYHotel(String hotelname);
	
	
}
