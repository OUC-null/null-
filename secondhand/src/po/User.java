package po;
//��ʾ�û���ʵ����
public class User {
	private int stuid;//ѧ��
	private String pwd;//����
	private String name;//����
	private int phone;//��ϵ�绰
	private String payimg;//
	private String img;//��ƷͼƬ
	private int id;//����û�
	
	public int getStuid() {
		return stuid;
	}

	public void setStuid(int stuid) {
		this.stuid = stuid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getPayimg() {
		return payimg;
	}

	public void setPayimg(String payimg) {
		this.payimg = payimg;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [stuid=" + stuid + ", pwd=" + pwd + ", name=" + name + ", phone=" + phone + ", payimg=" + payimg
				+ ", img=" + img + ", id=" + id + "]";
	}
	
}
