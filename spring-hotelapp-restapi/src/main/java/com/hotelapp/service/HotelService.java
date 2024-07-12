package com.hotelapp.service;

import java.util.List;

import com.hotelapp.exception.HotelNotFoundException;
import com.hotelapp.exception.IDNotFoundException;
import com.hotelapp.models.Hotel;

public interface HotelService {
	
	
	Hotel addHotel(Hotel hotel);
	void updateHotel(Hotel hotel);
	Hotel getHotelbyId( int hotelid) throws IDNotFoundException;
   void DeleteHotel(int hotelid) throws IDNotFoundException;
  
   List<Hotel>getByCity(String city)throws HotelNotFoundException;
    List<Hotel>getByMenu(String menuname)throws HotelNotFoundException;
    



}
