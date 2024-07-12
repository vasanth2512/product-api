package com.hotelapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelapp.exception.HotelNotFoundException;
import com.hotelapp.exception.IDNotFoundException;
import com.hotelapp.models.Hotel;
import com.hotelapp.repository.HotelRepository;


@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	HotelRepository hotelrepo;
	
	
	@Override
	public Hotel addHotel(Hotel hotel) {
		return hotelrepo.save(hotel);
		
	}

	@Override
	public void updateHotel(Hotel hotel) {
		hotelrepo.save(hotel);
		
		
	}

	@Override
	public Hotel getHotelbyId(int hotelid) {
		
		return  hotelrepo.findById(hotelid)
				.orElseThrow(()->  new IDNotFoundException(" id not found"));
	}

	@Override
	public void DeleteHotel(int hotelid) {
		 hotelrepo.deleteById(hotelid);
		
	}

	@Override
	public List<Hotel> getByCity(String city) {
	List<Hotel> listhotel  =	hotelrepo.findByAddressCity(city);
       if(listhotel.isEmpty()){
    	   throw new HotelNotFoundException(" the hotel not avaliable in this city");
		}
	  return listhotel;
	}

	@Override
	public List<Hotel> getByMenu(String menuname) {
	List<Hotel> listhotel =	hotelrepo.findByHotelMenu(menuname);
		 if(listhotel.isEmpty()) {
			 throw new HotelNotFoundException(" the hotel not avaliable ");
		 }
		return listhotel;
	}

}
