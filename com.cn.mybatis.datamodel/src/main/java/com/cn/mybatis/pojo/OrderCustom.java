package com.cn.mybatis.pojo;
/**
 * ������չ�࣬ͨ������ӳ�䶩�����û���ѯ�Ľ�����ø���̳а����ֶν϶��pojo��
 * @author Administrator
 *ӳ������po����ӳ��
 */
public class OrderCustom extends Orders{
	//����û�����
	private Integer id;
	private String username;
	private String sex;
	private String address;
	private String age;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}

}
