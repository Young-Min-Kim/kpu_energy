package com.testSpring.dao;

import java.util.List;

import com.testSpring.model.HomeVo;

//dao�� ������ ���̽��� �������ִ� �Լ����� ��´�.
public interface HomeDao {
	public List<HomeVo> test();
	//public HomeVo test(); // ��ȯ���� HomeVo
	
	public List<HomeVo> getElec();
}
