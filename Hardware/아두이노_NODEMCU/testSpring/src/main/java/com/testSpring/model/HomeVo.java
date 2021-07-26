/**
 * 
 */
package com.testSpring.model;

/**
 * @author ASUS UX534FTC
 *
 */
// HomeVo�� ��/ ���� ����� �ִ� ���� -> ���⿡ �����͸� ��Ƽ� ������ ���̽��� ���� ���ϰԲ� �����ְų�, ������ ���̽����� ����� ���⿡ ��Ƽ� �����´�.
public class HomeVo {

	private int id;
	private String name;
	private String location;
	private String datetime;
	private float temp;
	private float humid;
	private String electric;

	
	//�Ķ���� ���� ������   alt + shift + s -> Generate Constructer using field -> ��� deselect all �ؼ� generate
	public HomeVo() {
		super(); // ��� Ŭ������ Object��� ��ü���� ����� �޴´�. -> ��� ���� �ִ� ������ �����ڿ��� ��(������ִ� ���� �����ڸ� �����ؾ� �Ѵ�.)�� �ִ� �����ڱ��� �ö󰡾� �Ѵ�.
		// -> super(); �� ���ϴ°� ->������� �ٷ� ���� ��ü�� �����ڸ� �ǹ�(�ᱹ���� �ٷ����� �ǳ� �ǳ� �ö� �ᱹ���� object�� �����ڷ� �����ϰ� �ȴ�.)(�ᱹ���� Object�� �����ڸ� ����)
	}



	//�Ķ���� �ִ� ������ alt + shift + s -> Generate Constructer using field -> ��� select all �ؼ� generate ��� �Ķ���Ͱ� �ִ� �����ڸ� �����.
	public HomeVo(int id, String name, String location, String datetime, float temp, float humid, String electric) {
		super();
		this.id = id; // this�� ���� private int id; �� id id�� ������ ������ �� �ִ�. �Ķ�/����
		this.name = name;
		this.location = location;
		this.datetime = datetime;
		this.temp = temp;
		this.humid = humid;
		this.electric = electric;
	}

	//getter and setter -> generate
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public float getTemp() {
		return temp;
	}

	public void setTemp(float temp) {
		this.temp = temp;
	}

	public float getHumid() {
		return humid;
	}

	public void setHumid(float humid) {
		this.humid = humid;
	}

	public String getElectric() {
		return electric;
	}

	public void setElectric(String electric) {
		this.electric = electric;
	}

	@Override
	public String toString() {
		return "HomeVo [id=" + id + ", name=" + name + ", location=" + location + ", datetime=" + datetime + ", temp="
				+ temp + ", humid=" + humid + ", electric=" + electric + "]";
	}// ũ�� �߿��� �� �ƴ� ctrl + shift + s -> generate toString() ������ ��ü�� ->
		// System.out.println(��ü) -> ;#$%234126481 -> ��ä{id = 3, name = ������

}
