package costumetrade.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import costumetrade.domain.SpMenu;
import costumetrade.mapper.SpMenuMapper;
import costumetrade.service.SpMenuService;

@Transactional
@Service
public class SpMenuServiceImpl implements SpMenuService{
	@Autowired
	private SpMenuMapper spMenuMapper;

	@Override
	public List<SpMenu> getAllMenus() {
		// TODO Auto-generated method stub
		return spMenuMapper.getAllMenus();
	}
	
	

}
