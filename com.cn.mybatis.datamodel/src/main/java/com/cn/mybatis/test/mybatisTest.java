package com.cn.mybatis.test;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;





import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.lf5.util.Resource;
import org.junit.Test;

import com.cn.mybatis.mapper.OrderMapperCustom;
import com.cn.mybatis.mapper.UserMapper;
import com.cn.mybatis.pojo.OrderCustom;
import com.cn.mybatis.pojo.Orders;
import com.cn.mybatis.pojo.User;
import com.cn.mybatis.pojo.UserCustom;
import com.cn.mybatis.pojo.UserQueryVo;
import com.cn.mybatis.pojo.Users;


public class mybatisTest{
	@Test
	public void findOrderUserLazyLoading(){
		String config = "sqlMapConfig.xml";
		InputStream ips = Resource.class.getClassLoader().getResourceAsStream(config);
		SqlSessionFactory sql = new SqlSessionFactoryBuilder().build(ips);
		SqlSession session =sql.openSession();
		OrderMapperCustom mapper = session.getMapper(OrderMapperCustom.class);
		List<Orders> oc = mapper.findOrderUserLazyLoading();
		for(Orders order:oc){
			Users users = order.getUsers();
			System.out.println(users);
		}
	}
	
	@Test
	public void findOrderUserAndOrderDetail(){
		String config = "sqlMapConfig.xml";
		InputStream ips = Resource.class.getClassLoader().getResourceAsStream(config);
		SqlSessionFactory sql = new SqlSessionFactoryBuilder().build(ips);
		SqlSession session =sql.openSession();
		OrderMapperCustom mapper = session.getMapper(OrderMapperCustom.class);
		List<Orders> oc = mapper.findOrderUserAndOrderDetail();
		for(Orders order:oc){
			System.out.println("���ԣ�"+order);
		}
	}
	@Test
	public void findOrderUserResultMap(){
		String config = "sqlMapConfig.xml";
		InputStream ips = Resource.class.getClassLoader().getResourceAsStream(config);
		SqlSessionFactory sql = new SqlSessionFactoryBuilder().build(ips);
		SqlSession session =sql.openSession();
		OrderMapperCustom mapper = session.getMapper(OrderMapperCustom.class);
		List<Orders> oc = mapper.findOrderUserResultMap();
		for(Orders order:oc){
			System.out.println("���ԣ�"+order);
		}
		
		session.close();
	}
	@Test
	public void findOrderUser(){
		String config = "sqlMapConfig.xml";
		InputStream ips = Resource.class.getClassLoader().getResourceAsStream(config);
		SqlSessionFactory sql = new SqlSessionFactoryBuilder().build(ips);
		SqlSession session =sql.openSession();
		OrderMapperCustom mapper = session.getMapper(OrderMapperCustom.class);
		List<OrderCustom> oc = mapper.findOrderUser();
		for(OrderCustom order:oc){
			System.out.println("���ԣ�"+order);
		}
		
		session.close();
	}
	@Test
	public void findUserByIdResultMap(){
		String config = "sqlMapConfig.xml";
		InputStream ips = Resource.class.getClassLoader().getResourceAsStream(config);
		SqlSessionFactory sql = new SqlSessionFactoryBuilder().build(ips);
		SqlSession session =sql.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		User count = mapper.findUserByIdResultMap(1);
		System.out.println("���ԣ�"+count);
		session.close();
	}
	/**
	 * ����ӳ�� �û���Ϣ�ۺϲ�ѯsqlƬ�� ��̬sql
	 */
	@Test
	public void findUserList(){
		String config = "sqlMapConfig.xml";
		InputStream ips = Resource.class.getClassLoader().getResourceAsStream(config);
		SqlSessionFactory sql = new SqlSessionFactoryBuilder().build(ips);
		SqlSession session =sql.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		//��Ϊʹ���˶�̬sql ,���������ֵ����������ƴ�ӵ�sql��
		//userCustom.setSex(2);
//		userCustom.setUsername("��һ��");
//		userQueryVo.setUserCustom(userCustom);
		
		//������id
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(10);
		ids.add(12);
		userQueryVo.setIds(ids);
		userQueryVo.setUserCustom(userCustom);
		List<UserCustom> list = mapper.findUserList(userQueryVo);
		for(UserCustom str :list){
			System.out.println("sql foreachƴ�ӣ�"+str);
		}
		
//		System.out.println("���ԣ�"+list);
		session.close();
	}
	/**�û���Ϣ�����б��ѯ  ͨ����������û�������ѯ�б�ſ���ʵ�ַ�ҳ
	 * ������:�����ֻ��һ����һ��
	 * resutlType �����Ҫ���ѯ������������pojo�е�������һ�²ſ���ӳ��ɹ�
	 */
	@Test
	public void ResultTypefindUserCount(){
		String config = "sqlMapConfig.xml";
		InputStream ips = Resource.class.getClassLoader().getResourceAsStream(config);
		SqlSessionFactory sql = new SqlSessionFactoryBuilder().build(ips);
		SqlSession session =sql.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setSex(2);
		userCustom.setUsername("��һ��");
		userQueryVo.setUserCustom(userCustom);
		int count = mapper.findUserCount(userQueryVo);
		System.out.println("���ԣ�"+count);
		session.close();
	}
	/**
	 * ������������б���mapper.xml��resultTypeָ����������һ����
	 * ��mapper.java��ָ���ķ�������ֵ���Ͳ�ͬ
	 * 1���������������ص�����������
	 * 2�������� ����list
	 */
	@Test
	public void ResultTypefindUserByName(){
		String config = "sqlMapConfig.xml";
		InputStream ips = Resource.class.getClassLoader().getResourceAsStream(config);
		SqlSessionFactory sql = new SqlSessionFactoryBuilder().build(ips);
		SqlSession session =sql.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setUsername("��");
		userQueryVo.setUserCustom(userCustom);
		List<User> list = mapper.findUserByName(userQueryVo);
		for(User str :list){
			System.out.println("���ԣ�"+str);
		}
		
		session.close();
	}
	@Test
	public void selectById()throws IOException {
		//mybatis �����ļ�
				String config = "sqlMapConfig.xml";
				//��ȡ�����ļ���
				InputStream ips = Resource.class.getClassLoader().getResourceAsStream(config);
				//�����ػ�����������mybatis�����ļ���Ϣ
				SqlSessionFactory sql = new SqlSessionFactoryBuilder().build(ips);
				//ͨ�������õ�session
				SqlSession session =sql.openSession();
				
				//ͨ��sqlsession�������ݿ� statement = namespace.statement��id paramenterType
				User user = session.selectOne("com.cn.mybatis.mapper.UserMapper.selectUserById", 1);
				System.out.println(user);
				session.close();
				System.out.println(user.getId());
	}
	
		//ģ�����Բ�ѯ�û��б�
	@Test
	public void selectByName()throws IOException {
		//mybatis �����ļ�
				String config = "sqlMapConfig.xml";
				//��ȡ�����ļ���
				InputStream ips = Resource.class.getClassLoader().getResourceAsStream(config);
				//�����ػ�����������mybatis�����ļ���Ϣ
				SqlSessionFactory sql = new SqlSessionFactoryBuilder().build(ips);
				//ͨ�������õ�session
				SqlSession session =sql.openSession();
				
				//ͨ��sqlsession�������ݿ� statement = namespace.statement��id paramenterType
				User user = session.selectOne("test.selectByName", "%��һ��%");
				System.out.println(user);
				session.close();
				
		
	}	
	
	@Test
	public void insertByUserName()throws IOException {
		//mybatis �����ļ�
				String config = "sqlMapConfig.xml";
				//��ȡ�����ļ���
				InputStream ips = Resource.class.getClassLoader().getResourceAsStream(config);
				//�����ػ�����������mybatis�����ļ���Ϣ
				SqlSessionFactory sql = new SqlSessionFactoryBuilder().build(ips);
				//ͨ�������õ�session
				SqlSession session =sql.openSession();
				
				User user = new User();
				user.setId(31);
				user.setUsername("����");
				user.setPassword("654321");
				user.setSex(1);
				user.setBirthday(new Date());
				user.setIsAdmin(1);
				session.insert("test.insertByUserName",user);
				session.commit();
				//��������
				Integer id = user.getId();
				System.out.println(id);
				session.close();
				
		
	}
	
	//����һ������
	@Test
	public void testCache(){
		
	}
		
	

}
