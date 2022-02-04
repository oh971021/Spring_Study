package com.js.ajax;

import java.util.List;

public interface BuildingMapper {

	List<Shop> getAllshop();

	List<Shop> searchShop(FloorSeletor fs);
	
	
}
