package com.cn.mybatis.pojo;

import java.util.List;

//vo����ʾ��ͼ�����vo(��ͼ�����)/po(�־ò����)/pojo(�Զ������)
/**
 * User�İ�װ��
 * @author Administrator
 *
 */
public class UserQueryVo {
	//���id��ѯ
	private List<Integer> ids;
	
	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	//��װ����Ҫ��ѯ�����������װuserCustom�൱�ڰ�װUser,����ཨ�鲻Ҫ�������Ҫ��չ���Խ���һ����չ��
	private UserCustom userCustom;

	public UserCustom getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}
	

}
