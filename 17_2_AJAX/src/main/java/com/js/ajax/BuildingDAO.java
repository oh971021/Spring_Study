package com.js.ajax;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildingDAO {

	@Autowired	// 객체 정보가 들어갈 수 있도록 땡겨옴 (콘텍스트에서 가져옴)
	private SqlSession ss;
	
	// 빌딩 객체에 샵 객체들이 있기때문에 그 빌딩객체를 리턴하게 한다.
	public Building getAllShop() {
		
		// 리스트를 감싸서 리턴해준다. (빌딩이라는 인스턴스안에 리스트객체를 인자로 넣어준다.)
		return new Building(ss.getMapper(BuildingMapper.class).getAllShop());
		
	}

	public Building searchShop(FloorSelector fs) {

		// ss로 sql 작성하기
		return new Building(ss.getMapper(BuildingMapper.class).searchShop(fs));
	}

}
