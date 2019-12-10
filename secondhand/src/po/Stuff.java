package po;
//表示二手物品的实体类
public class Stuff {
	private int id;//和user的id对应
	private int stuffid;//标记物品
	private String stuffimg;
	private String info;
	private int price;
	private String stuffname;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStuffid() {
		return stuffid;
	}
	public void setStuffid(int stuffid) {
		this.stuffid = stuffid;
	}
	public String getStuffimg() {
		return stuffimg;
	}
	public void setStuffimg(String stuffimg) {
		this.stuffimg = stuffimg;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getStuffname() {
		return stuffname;
	}
	public void setStuffname(String stuffname) {
		this.stuffname = stuffname;
	}
	@Override
	public String toString() {
		return "Stuff [id=" + id + ", stuffid=" + stuffid + ", stuffimg=" + stuffimg + ", info=" + info + ", price="
				+ price + ", stuffname=" + stuffname + "]";
	}
	
}
