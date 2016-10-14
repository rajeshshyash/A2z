package com.a2z.dao;

import java.util.List;

import com.a2z.model.Address;
import com.a2z.model.AgencyProfilePersonalInfo;
import com.a2z.model.PhysicalDetails;
import com.a2z.model.ProfessinalWorkExp;
import com.a2z.model.UserProfilePersonalInfo;

public interface ProfileDao {
	public void saveUserProfilePersonalInfo(UserProfilePersonalInfo userProfilePersonalInfo);
	public PhysicalDetails saveUserPhysicalDetails(PhysicalDetails physicalDetails);
	public Address saveUserAddressDetails(Address address);
	public ProfessinalWorkExp saveUserProWorkExp(ProfessinalWorkExp professinalWorkExp);
	public AgencyProfilePersonalInfo saveAgencyProfilePersonalInfo(AgencyProfilePersonalInfo agencyProfilePersonalInfo);
	
	public List<?> getProfileDetailsById(long userId);
	public List<?> getPhysicalDetailsById(long userId);
	public List<?> getAddressDetailsById(long userId);
	public List<?> getExpDetailsById(long userId);
	public List<?> getAgnProfileDetailsById(long userId);
}
