package com.a2z.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.a2z.model.User;
@Repository("usersDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {
	
	public User findUserByUserName(String userName) {
		
		Query query = this.getSession().createQuery(" from User u where u.userName=:username");
		query.setParameter("username", userName);
		User user = (User) query.uniqueResult();
		
		return user;
	}
	
	public Long findUserIdByUserName(String userName) {
		return (Long) this.getSession()
				.createQuery("SELECT u.user_id FROM user u WHERE u.username=?")
				.setParameter(0,userName).uniqueResult();
	}
	
	public void saveUser(User users) {
		getSession().saveOrUpdate(users);
	}
	
	

	public List<?> findAllUsers() {
		List<?> userdata = null;
		
		String query = " SELECT u.user_id,u.profession,u.first_name,u.last_name, "+ 
				" pd.language,pd1.previous_work_indusry,pd.age,pd1.film_industry_intrested, "+
				" a.pm_district,a.pm_state "+
				" FROM user u "+
				" LEFT OUTER JOIN profile_details pd ON u.user_id = pd.user_id "+
				" LEFT OUTER JOIN professional_details pd1 ON u.user_id = pd1.user_id "+
				" LEFT OUTER JOIN address a ON u.user_id = a.user_id ";
		
		userdata = this.getSession().createSQLQuery(query)
				.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
	    return userdata;
	}

	
	public List<?> getUserDetailsProfile(long userId) {
		List<?> userDetailsdata = null;
		String query=" SELECT "+ 
				" u.first_name,u.last_name,pd.gender,u.email_id,"+
				" pd.language,u.contact_no,pd.father_name,pd.age,"+
				" phd.complexion,phd.skin_quality,phd.height_unit,"+
				" phd.weight_unit,phd.physique,phd.facial_hair,phd.hair_style,"+
				" phd.hair_color,phd.eye_color,phd.hair_length,"+
				" prd.previous_work_indusry,prd.name_worked_with_director,"+
				" prd.name_worked_film,prd.name_worked_production_house,prd.film_industry_intrested,prd.reason"+
				" FROM user u"+
				" LEFT OUTER JOIN profile_details pd ON u.user_id = pd.user_id"+
				" LEFT OUTER JOIN physical_details phd ON u.user_id = phd.user_id"+
				" LEFT OUTER JOIN professional_details prd ON u.user_id = prd.user_id"+
				" WHERE u.user_id = ?";
		
		userDetailsdata = this.getSession().createSQLQuery(query)
				.setParameter(0, userId)
				.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		//System.out.println("********** data "+userDetailsdata);
		return userDetailsdata;
	}
	
	public User findUserByUserId(long userId) {
		return (User) getSession().get(User.class, userId);
	}
	
	
	
}
