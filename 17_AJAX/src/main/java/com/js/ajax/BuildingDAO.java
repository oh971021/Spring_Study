package com.js.ajax;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildingDAO {

	@Autowired
	private SqlSession ss;
	
	public Building getAllshop() {

		// 객체로 가게들을 싸메서 한꺼번에 보여준다.
		return new Building(ss.getMapper(BuildingMapper.class).getAllshop());
	}

}
