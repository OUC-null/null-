package dao;

import org.junit.Test;

import po.Stuff;

public class StuffDaoTest {
	private StuffDao stuffDao= new StuffDao();
	@Test
	public void testChg() {
		Stuff stuff =new Stuff() ;
		stuff.setStuffname("木偶猫");
		stuff.setPrice("48");
		stuff.setStuffimg("暂无");
		stuff.setInfo("木雕，招财猫，带不走出置");
		stuff.setId(1);
		System.out.println(stuffDao.chg(1, stuff));
	}

}
