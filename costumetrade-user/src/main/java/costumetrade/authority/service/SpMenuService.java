package costumetrade.authority.service;

import java.util.List;

import costumetrade.user.domain.SpEmployee;
import costumetrade.user.domain.SpMenu;


public interface SpMenuService {
	/*
	 * 获取权限信息
	 * 
	 * */
	public List<SpMenu> getAllMenus();

}
