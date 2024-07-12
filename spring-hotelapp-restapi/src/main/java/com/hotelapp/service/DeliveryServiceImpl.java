package com.hotelapp.service;



import org.springframework.beans.factory.annotation.Autowired;

import com.hotelapp.models.Delivery;
import com.hotelapp.repository.DeliveryRepository;

public class DeliveryServiceImpl implements DeliveryService {

	@Autowired
	DeliveryRepository deliveryrepo; 
	
	@Override
	public void updateDelivery(Delivery delivery) {
		deliveryrepo.save(delivery);
		
		
	}

	@Override
	public void deleteDelivery(int delid) {
		deliveryrepo.deleteById(delid);
		
	}

	@Override
	public Delivery getDeliveryByid(int delid) {
		
		return  deliveryrepo.findById(delid).get();
	}

	

}
