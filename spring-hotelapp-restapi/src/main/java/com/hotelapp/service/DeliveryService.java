package com.hotelapp.service;

import com.hotelapp.models.Delivery;

public interface DeliveryService {
	
	void updateDelivery(Delivery delivery);
	void deleteDelivery(int delid);
	Delivery getDeliveryByid(int delid);
	
}
