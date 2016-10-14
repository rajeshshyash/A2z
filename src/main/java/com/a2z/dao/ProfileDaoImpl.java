package com.a2z.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.a2z.model.Address;
import com.a2z.model.AgencyProfilePersonalInfo;
import com.a2z.model.PhysicalDetails;
import com.a2z.model.ProfessinalWorkExp;
import com.a2z.model.UserProfilePersonalInfo;

@Repository("profileDao")
@Transactional
public class ProfileDaoImpl extends AbstractDao<Integer, UserProfilePersonalInfo> implements ProfileDao {

	public void saveUserProfilePersonalInfo(UserProfilePersonalInfo userProfilePersonalInfo) {
		getSession().saveOrUpdate(userProfilePersonalInfo);
	}

	public PhysicalDetails saveUserPhysicalDetails(PhysicalDetails physicalDetails) {
		getSession().saveOrUpdate(physicalDetails);
		return physicalDetails;
	}

	public Address saveUserAddressDetails(Address address) {
		getSession().saveOrUpdate(address);
		return address;
	}

	public ProfessinalWorkExp saveUserProWorkExp(ProfessinalWorkExp professinalWorkExp) {
		getSession().saveOrUpdate(professinalWorkExp);
		return professinalWorkExp;
	}

	public AgencyProfilePersonalInfo saveAgencyProfilePersonalInfo(AgencyProfilePersonalInfo agencyProfilePersonalInfo) {
		getSession().saveOrUpdate(agencyProfilePersonalInfo);
		return agencyProfilePersonalInfo;
	}

	public List<?> getProfileDetailsById(long userId) {
		List<?> updata = null;
		String query=" SELECT pd.father_name,pd.gender,pd.dob," +
				     " pd.age,pd.whatsup_no,pd.landline_no," +
				     " pd.education_qualification,pd.course_related_profession,pd.language " +
				     " FROM profile_details pd WHERE pd.user_id = ?";

		updata = this.getSession().createSQLQuery(query)
		    .setParameter(0, userId)
		    .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		  // System.out.println("********** data "+updata);
		   return updata;
		}
	
	public List<?> getPhysicalDetailsById(long userId) {
		List<?> uphdata = null;
		String query=" SELECT pd.complexion,pd.skin_quality,pd.eye_color, " +
				     " pd.height_unit,pd.weight_unit,pd.physique, " +
				     " pd.facial_hair,pd.hair_style,pd.hair_color,pd.hair_length " +
				     " FROM physical_details pd WHERE pd.user_id = ?";

		uphdata = this.getSession().createSQLQuery(query)
		    .setParameter(0, userId)
		    .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		   //System.out.println("********** uphdata "+uphdata);
		   return uphdata;
		}

	public List<?> getAddressDetailsById(long userId) {
		List<?> addata = null;
		String query=" SELECT a.pr_address,a.pr_country,a.pr_state,a.pr_district,a.pr_zip_postal, " +
					 " a.pm_address,a.pm_country,a.pm_state,a.pm_district,a.pm_zip_postal " +
				     " FROM address a WHERE a.user_id = ?";

		addata = this.getSession().createSQLQuery(query)
		    .setParameter(0, userId)
		    .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		  // System.out.println("********** uphdata "+addata);
		   return addata;
		}

	public List<?> getExpDetailsById(long userId) {
		List<?> pfdata = null;
		String query=" SELECT pd.previous_work_indusry,pd.name_worked_with_director, " +
				     " pd.name_worked_film,pd.name_worked_production_house, " +
				     " pd.film_industry_intrested,pd.reason " +
				     " FROM professional_details pd WHERE pd.user_id = ?";

		pfdata = this.getSession().createSQLQuery(query)
		    .setParameter(0, userId)
		    .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		   //System.out.println("********** uphdata "+pfdata);
		   return pfdata;
		}
	
	public List<?> getAgnProfileDetailsById(long userId) {
		List<?> agndata = null;
		String query=" SELECT pda.name_of_agency,pda.office_contact_no, " +
				     " pda.website,pda.service " +
				     " FROM profile_details_agency pda WHERE pda.user_id = ?";

		agndata = this.getSession().createSQLQuery(query)
		    .setParameter(0, userId)
		    .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		   //System.out.println("********** uphdata "+agndata);
		   return agndata;
		}
	
}
	


