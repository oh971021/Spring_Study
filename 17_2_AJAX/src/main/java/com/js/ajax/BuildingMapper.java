package com.js.ajax;

import java.util.List;

public interface BuildingMapper {

	List<Shop> getAllShop();

	List<Shop> searchShop(FloorSelector fs);

}
