

ȱ�㣺
1��ServiceImpl��������Dao��Ľӿڣ���������ʵ�֣���ȻΥ����OOP�ġ������ӿڣ�������ʵ�֡���ԭ��
	//ʵ����Daoʵ��
	private Dao dao = new Dao4MySqlImpl();  

	@Override
	public void serviceMethod() {
		//����Daoʵ�ֵķ���
		dao.daoMethod();
	}