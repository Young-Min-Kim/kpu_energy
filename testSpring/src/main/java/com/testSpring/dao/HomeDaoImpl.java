package com.testSpring.dao;

import java.util.List;

//import org.apache.ibatis.session.SqlSessionFactory;  �̰� �Ⱦ��ٰ� ��� �༭ �ϴ� �ּ�, ���� ���� �� ����
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.testSpring.model.HomeVo;
//Repository -> ����Ҷ�� ��

@Repository						// �������͸��� �� ������ �ٿ���� ���� �νĽ����ֱ� ���� ǥ���ϴ� ������̼�
public class HomeDaoImpl implements HomeDao{
//impl > implements(�����ϴ�)�� ���
// ���� �������̽������� �̷� �̷��� ���� ������ ���̴� ��� ���� ���� ��
//���� ������ ���÷���Ʈ Ŭ���� �ȿ��� ����

	 @Autowired SqlSessionTemplate sqlSession; 		// ���ۿ� �������ֱ� ���� Ŭ������ �������� SqlSessionTemplate sqlSession;
	 // SqlSessionFactory�� Autowired ���ָ� �˾Ƽ� �ڵ����� �������ֵ��� �����ϴ� ��
	
	 @Override
	 public List<HomeVo> test() {
		 return sqlSession.selectList("com.testSpring.homeTest");
		 //sqlSession.selectOne -> sqlSession(mapper�� �����ϴ� ��ü)���� mapper�� ������ ��  ���� selectOne -> ����� �ϳ� �� �� �� �ϳ��� �����´�. ����� �������� ���� selectList
		 // com.testSpring -> �̰Ŵ� home_mapper.xml�� namespace�� �����ؾ� �Ѵ�. , home_mapper���� homeTest�� ����
		 
	 }

		/*
		 * public HomeVo test() { return
		 * sqlSession.selectOne("com.testSpring.homeTest");
		 *  //sqlSession.selectOne -> sqlSession(mapper�� �����ϴ� ��ü)���� mapper�� ������ �� ���� selectOne -> ����� �ϳ� �� �� �� �ϳ��� �����´�. 
		 *  ����� �������� ���� selectList // com.testSpring -> �̰Ŵ� home_mapper.xml�� namespace�� �����ؾ� �Ѵ�. , home_mapper���� homeTest�� ����
		 * 
		 * }
		 */
	 @Override
	 public List<HomeVo> getElec() { // List -> ���� ������ ����, � object�� �� �ֱ� ���� ��� ��� ���� List���� �˷� ��� �� -> <HomeVo> : HomeVo�� ���� ����Ʈ
		return sqlSession.selectList("com.testSpring.getElecStat");
		}

	
}
