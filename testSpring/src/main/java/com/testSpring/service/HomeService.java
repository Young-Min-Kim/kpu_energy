package com.testSpring.service;

import java.util.List;

import com.testSpring.model.HomeVo;

public interface HomeService {
	// service ��Ű���� �״��� �߿����� ����
	// �״��� �߿������� ���� ����
	//controller �� dao�� �̾��ִ� �ٸ� ����
	
	//Model
	public List<HomeVo> test();
	//public HomeVo test();
	
	public List<HomeVo> getElec();
}
