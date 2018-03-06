package com.wistron.dao.impl;

import java.text.SimpleDateFormat;

import org.dom4j.Document;
import org.dom4j.Element;

import com.wistron.dao.IUserDao;
import com.wistron.domain.User;
import com.wistron.util.XmlUtils;



public class UserDaoImpl implements IUserDao {

	@Override
	public User find(String userName, String userPwd) {
		try{
			Document document = XmlUtils.getDocument();
			//
			Element e = (Element) document.selectSingleNode("//user[@userName='"+userName+"' and @userPwd='"+userPwd+"']");
			if(e==null){
				return null;
			}
			User user = new User();
			user.setId(e.attributeValue("id"));
			user.setEmail(e.attributeValue("email"));
			user.setUserPwd(e.attributeValue("userPwd"));
			user.setUserName(e.attributeValue("userName"));
			String birth = e.attributeValue("birthday");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			user.setBirthday(sdf.parse(birth));
			
			return user;
		
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		try{
			Document document = XmlUtils.getDocument();
			Element root = document.getRootElement();
			Element user_node = root.addElement("user");  //
			user_node.setAttributeValue("id", user.getId());
			user_node.setAttributeValue("userName", user.getUserName());
			user_node.setAttributeValue("userPwd", user.getUserPwd());
			user_node.setAttributeValue("email", user.getEmail());
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			user_node.setAttributeValue("birthday", sdf.format(user.getBirthday()));
		
			XmlUtils.write2Xml(document);
			
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public User find(String userName) {
		try{
			Document document = XmlUtils.getDocument();
			Element e = (Element) document.selectSingleNode("//user[@userName='"+userName+"']");
			if(e==null){
				return null;
			}
			User user = new User();
			user.setId(e.attributeValue("id"));
			user.setEmail(e.attributeValue("email"));
			user.setUserPwd(e.attributeValue("userPwd"));
			user.setUserName(e.attributeValue("userName"));
			String birth = e.attributeValue("birthday");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			user.setBirthday(sdf.parse(birth));
			
			return user;
		
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
