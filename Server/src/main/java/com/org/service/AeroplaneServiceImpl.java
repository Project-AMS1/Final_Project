package com.org.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.dao.AeroplaneDao;
import com.org.model.Aeroplane;

@Service
@Transactional
public class AeroplaneServiceImpl implements AeroplaneService{

	@Autowired
	private AeroplaneDao aeroplaneDao;
	
	@Override
	public String createAeroplane(Aeroplane aeroplane) {
		aeroplaneDao.save(aeroplane);
		return "1 Aeroplane is added in inventory";
	}
	
	@Override
	public String removeAeroplane(Aeroplane aeroplane) {
		Optional<Aeroplane> aeroplane1=aeroplaneDao.findById(aeroplane.getPlane_code());
		if(aeroplane1.isPresent())
		{
			aeroplaneDao.delete(aeroplane);
		return "Aeroplane is removed in inventory";
		}
		else
			return "Aeroplane does not exist";
	}
	

}
