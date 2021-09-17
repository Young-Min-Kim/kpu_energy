package main;

import dto.ClientDTO;
import mqtt.MyMqttClient;

public class MainProcess {
	private LoginFrame loginFrame;
	private MainFrame mainFrame;
	private SetGraphKinds setGraphFrame;
	private GetGraphFrame getGraphFrame;
	private NoticeFrame noticeFrame;
	private ControlFrame controlFrame;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainProcess main = new MainProcess();
		main.loginFrame = new LoginFrame(main); // �α���â ���̱�

	}

	public void showFrameMain(ClientDTO client, String store) {
		loginFrame.dispose(); // �α���â�ݱ�
		mainFrame = new MainFrame(client, store); // �׽�Ʈ������ ����
	}

	public void setGraph(ClientDTO client) {
		setGraphFrame = new SetGraphKinds(client);
	}

	public void getGraph(int graphCheck, int optionCheck, String product, String date, int store_id) {
		getGraphFrame = new GetGraphFrame(graphCheck, optionCheck, product, date, store_id);
	}

	public void showNotice(int store_id) {
		noticeFrame = new NoticeFrame(store_id);
	}
	
	public void control(MyMqttClient mClient) {
		controlFrame=new ControlFrame(mClient);
	}

}
