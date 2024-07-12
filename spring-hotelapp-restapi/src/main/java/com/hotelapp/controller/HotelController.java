package com.hotelapp.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelapp.models.Hotel;
import com.hotelapp.service.HotelService;

@RestController
@RequestMapping("/hotelapi/v1")
public class HotelController {
	
	@Autowired
	HotelService hotelservice;
	
     @PostMapping("/hotels")
	  ResponseEntity<Hotel> addHotel( @RequestBody Hotel hotel) {
	       Hotel nhotel = hotelservice.addHotel(hotel);
	        HttpHeaders header = new HttpHeaders();
	        header.add("desc", " A NEW HOTEL ADDED");
	        return  ResponseEntity.ok().headers(header).body(nhotel) ;
		
	}
     
     @PutMapping("/hotels")
	  ResponseEntity<String> updateHotel( @RequestBody  Hotel hotel) {
    	 hotelservice.updateHotel(hotel);
    	 return ResponseEntity.ok("UPDATE");
    	 
     }
	 
     @GetMapping("/hotels/getbyid/{id}")
   ResponseEntity< Hotel> getHotelbyId( @PathVariable("id") int hotelid) {
		Hotel hotel = hotelservice.getHotelbyId(hotelid);
		HttpHeaders header = new HttpHeaders();
		header.add("desc", "GETING HOTEL BY THE ID");
    	  return  ResponseEntity.ok().headers(header) .body(hotel);
	}
     
     @DeleteMapping("/hotels/deletebyid/{hid}")
     ResponseEntity< Void> DeleteHotel( @PathVariable("hid")  int hotelid) {
	      hotelservice.DeleteHotel(hotelid);
	     return ResponseEntity.ok().build();
   }
  
     @GetMapping("/hotels/getbycity/{city}")
      ResponseEntity<List<Hotel>>getByCity(@PathVariable("city") String city){
	       HttpHeaders header = new HttpHeaders();
	       header.add("desc", "GET HOTELS BY THE CITY");
	       return ResponseEntity.ok().headers(header).body( hotelservice.getByCity(city)) ;
   }
      
     @GetMapping("/hotels/getbymenu/{menu}")
      ResponseEntity<List<Hotel>>getByMenu(@PathVariable("menu") String menuname){
    	
        return ResponseEntity.ok().body(hotelservice.getByMenu(menuname));
    }
	
	

}
