package com.cn.mybatis.dao;

import com.cn.mybatis.pojo.User;

public interface UserDao {
	//��ѯ�û���Ϣ
	public User findUserById(int id);
	//����û���Ϣ
	public void insertUser(User user);
	//ɾ���û���Ϣ
	public void deleteUser(int id);

}
