

缺点：
1、ServiceImpl不但依赖Dao层的接口，还依赖其实现，显然违背了OOP的“依赖接口，不依赖实现”的原则。
	//实例化Dao实现
	private Dao dao = new Dao4MySqlImpl();  

	@Override
	public void serviceMethod() {
		//调用Dao实现的方法
		dao.daoMethod();
	}