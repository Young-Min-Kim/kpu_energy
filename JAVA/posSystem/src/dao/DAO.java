package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.ClientDTO;
import dto.EnvDTO;
import dto.InquireDateDTO;
import dto.NoticeDTO;
import dto.ProductDTO;
import dto.SmartPlugDTO;

public class DAO {
	private SqlSessionFactory sqlSessionFactory = null;

	public DAO(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public ClientDTO readClientData(ClientDTO dto) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ClientDTO clientDTO = null;

		try {
			clientDTO = sqlSession.selectOne("client.clientData", dto);
		} catch (Exception e) {
			System.out.println("�� ������ ������ �� �����ϴ�.");
		} finally {
			sqlSession.close();
		}
		return clientDTO;
	}

	public int getStoreId(String name) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int storeNumber = 0;

		try {
			storeNumber = sqlSession.selectOne("client.storeId", name);
		} catch (Exception e) {
			System.out.println("���� ���̵� �ҷ��� �� �����ϴ�.");
		} finally {
			sqlSession.close();
		}
		return storeNumber;
	}

	public List<EnvDTO> readEnvData(InquireDateDTO dto) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<EnvDTO> list = null;

		try {
			list = sqlSession.selectList("env.envData", dto);
		} catch (Exception e) {
			System.out.println("������� ������ �� �����ϴ�.");
		} finally {
			sqlSession.close();
		}
		return list;
	}

	public List<SmartPlugDTO> readSmartPlugHourData(InquireDateDTO dto) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<SmartPlugDTO> list = null;

		try {
			list = sqlSession.selectList("smartPlug.smartPlugHourData", dto);
		} catch (Exception e) {
			System.out.println("��⺰ �ð��� �Һ� �����͸� ������ �� �����ϴ�.");
		} finally {
			sqlSession.close();
		}
		return list;
	}

	public List<SmartPlugDTO> readSmartPlugDayData(InquireDateDTO dto) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<SmartPlugDTO> list = null;

		try {
			list = sqlSession.selectList("smartPlug.smartPlugDayData", dto);
		} catch (Exception e) {
			System.out.println("���� ���� �Һ� �����͸� ������ �� �����ϴ�.");
		} finally {
			sqlSession.close();
		}
		return list;
	}

	public List<SmartPlugDTO> readSmartPlugMonthData(InquireDateDTO dto) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<SmartPlugDTO> list = null;

		try {
			list = sqlSession.selectList("smartPlug.smartPlugMonthData", dto);
		} catch (Exception e) {
			System.out.println("���� �� �Һ� �����͸� ������ �� �����ϴ�.");
		} finally {
			sqlSession.close();
		}
		return list;
	}

	public List<SmartPlugDTO> readTotalHourAmpData(InquireDateDTO dto) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<SmartPlugDTO> list = null;

		try {
			list = sqlSession.selectList("smartPlug.totalHourAmpData", dto);
		} catch (Exception e) {
			System.out.println("�ð��� �� �Һ� �����͸� ������ �� �����ϴ�.");
		} finally {
			sqlSession.close();
		}
		return list;
	}

	public List<SmartPlugDTO> readTotalHourAmpReductionData(InquireDateDTO dto) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<SmartPlugDTO> list = null;

		try {
			list = sqlSession.selectList("smartPlug.totalHourReductionAmpData", dto);
		} catch (Exception e) {
			System.out.println("�ð��� ������ �����͸� ������ �� �����ϴ�.");
		} finally {
			sqlSession.close();
		}
		return list;
	}

	public List<ProductDTO> getProductName(int storeId) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<ProductDTO> list = null;

		try {
			list = sqlSession.selectList("client.selectName", storeId);
		} catch (Exception e) {
			System.out.println("��ǰ ����� ������ �� �����ϴ�.");
		} finally {
			sqlSession.close();
		}
		return list;
	}

	public int getProductId(String pName) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int id = 0;

		try {
			id = sqlSession.selectOne("client.productName", pName);
		} catch (Exception e) {
			System.out.println("��ǰ ���̵� ������ �� �����ϴ�.");
		} finally {
			sqlSession.close();
		}
		return id;
	}

	public List<SmartPlugDTO> readTotalDayAmpData(InquireDateDTO dto) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<SmartPlugDTO> list = null;

		try {
			list = sqlSession.selectList("smartPlug.totalDayAmpData", dto);
		} catch (Exception e) {
			System.out.println("���� �� ���� �Һ� �����͸� ������ �� �����ϴ�.");
		} finally {
			sqlSession.close();
		}
		return list;
	}

	public List<SmartPlugDTO> readTotalDayAmpReductionData(InquireDateDTO dto) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<SmartPlugDTO> list = null;

		try {
			list = sqlSession.selectList("smartPlug.totalDayReductionAmpData", dto);
		} catch (Exception e) {
			System.out.println("���� �� ������ �Һ��� ������ �� �����ϴ�..");
		} finally {
			sqlSession.close();
		}
		return list;
	}

	public List<SmartPlugDTO> readTotalMonthAmpData(InquireDateDTO dto) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<SmartPlugDTO> list = null;

		try {
			list = sqlSession.selectList("smartPlug.totalMonthData", dto);
		} catch (Exception e) {
			System.out.println("�� �� ���� �Һ� �����͸� ������ �� �����ϴ�.");
		} finally {
			sqlSession.close();
		}
		return list;
	}

	public List<SmartPlugDTO> readTotalMonthAmpReductionData(InquireDateDTO dto) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<SmartPlugDTO> list = null;

		try {
			list = sqlSession.selectList("smartPlug.totalMonthReductionAmpData", dto);
		} catch (Exception e) {
			System.out.println("�� �� ������ ���� �Һ� �����͸� ������ �� �����ϴ�.");
		} finally {
			sqlSession.close();
		}
		return list;
	}

	public List<NoticeDTO> readNotice(int store_id) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<NoticeDTO> list = null;
		
		try {
			list = sqlSession.selectList("client.notice", store_id);
		} catch (Exception e) {
			System.out.println("�˸� ����� ������ �� �����ϴ�.");
		} finally {
			sqlSession.close();
		}
		return list;
	}
}
