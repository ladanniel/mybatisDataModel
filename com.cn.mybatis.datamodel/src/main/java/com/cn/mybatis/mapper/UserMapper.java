package com.cn.mybatis.mapper;

import java.util.List;

import com.cn.mybatis.pojo.User;
import com.cn.mybatis.pojo.UserCustom;
import com.cn.mybatis.pojo.UserQueryVo;

public interface UserMapper {
	public User findUserByIdResultMap(int id);
	
	public User selectUserById(int id);
	/**
	 * �û���Ϣ�ۺϲ�ѯ
	 * ����������ͣ�UserQueryVo
	 * @param userQueryVo
	 * @return
	 */
	public List<UserCustom> findUserList(UserQueryVo userQueryVo);
	/**
	 * �û���Ϣ�ۺ�������ѯ
	 * @param userQueryVo
	 * @return
	 */
	public int findUserCount(UserQueryVo userQueryVo);
	/**
	 * ����id��ѯ�û���Ϣ
	 * @param id
	 * @return
	 */
	public User findUserById(int id);
	/**
	 * �����û�����ѯ�б�
	 * @param userQueryVo
	 * @return
	 */
	public List<User> findUserByName(UserQueryVo userQueryVo);

}
