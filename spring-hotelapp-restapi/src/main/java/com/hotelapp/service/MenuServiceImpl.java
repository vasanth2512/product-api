package com.hotelapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hotelapp.models.Menu;
import com.hotelapp.repository.MenuRepository;

public class MenuServiceImpl implements MenuService {

	
	@Autowired
	MenuRepository menurepo;
	
	
	@Override
	public List<Menu> getHotelByMenu(String hotelname) {
		
		return menurepo.findMenuBYHotel(hotelname); 
	}



}
