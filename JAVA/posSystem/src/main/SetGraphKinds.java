package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.jdatepicker.JDatePicker;

import dao.DAO;
import dao.MybatisConnection;
import dto.ClientDTO;
import dto.ProductDTO;

public class SetGraphKinds extends JFrame implements ActionListener {
	private ClientDTO client;
	private ButtonGroup graphGroup, optionGroup;
	private JButton btnOk, btnCancel;
	private JPanel graphPanel, optionPanel, btnPanel;
	private JRadioButton rdbtnGraph[] = new JRadioButton[2];
	private JRadioButton rdbtnOption[] = new JRadioButton[3];
	private JComboBox<String> comboBox;
	private JLabel dateLabel;
	private String name[] = { "��ǰ�� �Һ�", "������" };
	private String option[] = { "�ð�", "��", "��" };
	private int nameY[] = { 6, 31 };
	private int optionX[] = { 8, 145, 281 };
	private int graphCheck, optionCheck;
	private DAO dao;
	private List<ProductDTO> pvo;
	private JDatePicker datePicker;

	private GetGraphFrame getGraphFrame;
	private MainProcess main;

	public SetGraphKinds(ClientDTO client) {
		// �� ���� ���
		this.client = client;

		// JFrame ����
		setTitle("�׷��� ����");
		setBounds(832, 180, 450, 400);
		setResizable(false);

		// ���� �ǳ� ����
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		placeOptionPanel(contentPane);
		add(contentPane);
		setVisible(true);
	}

	public void placeOptionPanel(JPanel contentPane) {
		// �׷��� ���� ���� â
		graphPanel = new JPanel();
		graphPanel.setBackground(Color.DARK_GRAY);
		graphPanel.setBorder(new LineBorder(Color.WHITE, 3));
		graphPanel.setBounds(12, 10, 410, 60);
		contentPane.add(graphPanel);
		graphPanel.setLayout(null);

		/*
		 * 1. ���� ��ư �׷� ���� 2. ���� ��ư ����
		 */
		graphGroup = new ButtonGroup();
		for (int i = 0; i < rdbtnGraph.length; i++) {
			rdbtnGraph[i] = new JRadioButton(name[i]);
			rdbtnGraph[i].setFont(new Font("����", Font.BOLD, 15));
			rdbtnGraph[i].setForeground(Color.WHITE);
			rdbtnGraph[i].setBackground(Color.DARK_GRAY);
			rdbtnGraph[i].addActionListener(this);
			rdbtnGraph[i].setBounds(144, nameY[i], 121, 23);
			graphGroup.add(rdbtnGraph[i]);
			graphPanel.add(rdbtnGraph[i]);
		}

		// �ð�, ��, �� �� ��¥ ���� ��� â
		optionPanel = new JPanel();
		optionPanel.setBackground(Color.DARK_GRAY);
		optionPanel.setBorder(new LineBorder(Color.WHITE, 3));
		optionPanel.setBounds(12, 93, 410, 166);
		contentPane.add(optionPanel);
		optionPanel.setLayout(null);

		dao = new DAO(MybatisConnection.getSqlSessionFactory());
		try {
			pvo = dao.getProductName(11);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dao = null;
		}
		comboBox = new JComboBox<String>();
		comboBox.addItem("=====��⼱��=====");
		for (int i = 0; i < pvo.size(); i++) {
			comboBox.addItem(pvo.get(i).getName());
		}
		comboBox.setFont(new Font("����", Font.BOLD, 15));
		comboBox.setBounds(100, 25, 218, 23);
		comboBox.setVisible(false);
		optionPanel.add(comboBox);

		/*
		 * 1. ���� ��ư �׷� ���� 2.���� ��ư ����
		 */
		optionGroup = new ButtonGroup();
		for (int i = 0; i < rdbtnOption.length; i++) {
			rdbtnOption[i] = new JRadioButton(option[i]);
			rdbtnOption[i].setBackground(Color.DARK_GRAY);
			rdbtnOption[i].setFont(new Font("����", Font.BOLD, 15));
			rdbtnOption[i].setForeground(Color.WHITE);
			rdbtnOption[i].addActionListener(this);
			rdbtnOption[i].setBounds(optionX[i], 71, 121, 23);
			optionGroup.add(rdbtnOption[i]);
			optionPanel.add(rdbtnOption[i]);
		}

		/*
		 * 1. ��¥ �Է� ���� 2. ��¥ �۾� ��
		 */
		datePicker = new JDatePicker();
		datePicker.setBounds(123, 118, 193, 21);
		optionPanel.add(datePicker);

		dateLabel = new JLabel("��¥");
		dateLabel.setForeground(Color.WHITE);
		dateLabel.setFont(new Font("����", Font.BOLD, 15));
		dateLabel.setBounds(72, 122, 57, 15);
		optionPanel.add(dateLabel);
		optionPanel.setVisible(false);

		// ��ư ������ â
		btnPanel = new JPanel();
		btnPanel.setBackground(Color.DARK_GRAY);
		btnPanel.setBounds(12, 302, 410, 49);
		contentPane.add(btnPanel);
		btnPanel.setLayout(null);

		/*
		 * 1. Ȯ�� ��ư 2. ��� ��ư
		 */
		btnOk = new JButton("Ȯ��");
		btnOk.setFont(new Font("����", Font.BOLD, 15));
		btnOk.setBounds(192, 10, 97, 29);
		btnOk.addActionListener(this);
		btnPanel.add(btnOk);

		btnCancel = new JButton("���");
		btnCancel.setFont(new Font("����", Font.BOLD, 15));
		btnCancel.setBounds(301, 10, 97, 29);
		btnCancel.addActionListener(this);
		btnPanel.add(btnCancel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String action = e.getActionCommand();

		if (action.equals(rdbtnGraph[0].getText())) {
			optionPanel.setVisible(true);
			comboBox.setVisible(true);
			graphCheck = 0;
		} else if (action.equals(rdbtnGraph[1].getText())) {
			optionPanel.setVisible(true);
			comboBox.setVisible(false);
			graphCheck = 1;
		} else if (action.equals(rdbtnOption[0].getText())) {
			optionCheck = 0;
		} else if (action.equals(rdbtnOption[1].getText())) {
			optionCheck = 1;
		} else if (action.equals(rdbtnOption[2].getText())) {
			optionCheck = 2;
		} else if (action.equals(btnOk.getText())) {
			main = new MainProcess();
			main.getGraph(graphCheck, optionCheck, (String) comboBox.getSelectedItem(),
					datePicker.getFormattedTextField().getText().replace(". ", "-"), client.getStoreId());
		} else if (action.equals(btnCancel.getText())) {
			dispose();
		}

	}
}
