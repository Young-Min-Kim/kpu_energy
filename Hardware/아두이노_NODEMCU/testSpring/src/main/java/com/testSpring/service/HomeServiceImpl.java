package com.testSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testSpring.dao.HomeDao;// ctrl + shift + O -> �ڵ����� Ŭ������ import ���ִ� ����Ű [�ſ� �߿�]
import com.testSpring.model.HomeVo;

@Service			// ���񽺶�� �˷��ִ� ������̼�    ���񽺿� : ��Ʈ�ѷ� ���� �ٿ��� �ְ� ���� ���񽺴� ��Ʈ�ѷ��� �ٿ��� �������ִ� �� �� ������̼��� �� ������ ���񽺶�� �ν� �����ֱ� ���� ǥ���ϴ� ��
public class HomeServiceImpl implements HomeService{

	
	@Autowired
	HomeDao homeDao;
	@Override
	public List<HomeVo> test() {
		return homeDao.test();
	}
	/*
	 * public HomeVo test() { // ��ȯ���� HomeVo �� �� (public int amm(){ ... }) return   -> �� �Ѱ� �ҷ��ö� ����ϴ� ��
	 * homeDao.test(); }
	 */

	@Override
	public List<HomeVo> getElec() { // List -> ���� ������ ����, � object�� �� �ֱ� ���� ��� ��� ���� List���� �˷� ��� �� -> <HomeVo> : HomeVo�� ���� ����Ʈ
		return homeDao.getElec();	// arrayList -> arrayList�� List�� ��� �ް� ����, �� ���̴� ����.
	}
}
