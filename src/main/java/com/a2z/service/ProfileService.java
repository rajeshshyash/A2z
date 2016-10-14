package com.a2z.service;

import java.util.List;

import com.a2z.model.Address;
import com.a2z.model.AgencyProfilePersonalInfo;
import com.a2z.model.PhysicalDetails;
import com.a2z.model.ProfessinalWorkExp;
import com.a2z.to.AddressTo;
import com.a2z.to.AgencyProfilePersonalInfoTo;
import com.a2z.to.PhysicalDetailsTo;
import com.a2z.to.ProfessinalWorkExpTo;
import com.a2z.to.UserProfilePersonalInfoTo;

public interface ProfileService {
	public void saveUserProfilePersonalInfo(UserProfilePersonalInfoTo userProfilePersonalInfoTo);
	public PhysicalDetails saveUserPhysicalDetails(PhysicalDetailsTo physicalDetailsTo);
	public Address saveUserAddressDetails(AddressTo addressTo);
	public ProfessinalWorkExp saveUserProWorkExp(ProfessinalWorkExpTo professinalWorkExpTo);
	public AgencyProfilePersonalInfo saveAgencyProfilePersonalInfo(AgencyProfilePersonalInfoTo agencyProfilePersonalInfoTo);
	
	public List<?> getProfileDetailsById(long userId);
	public List<?> getPhysicalDetailsById(long userId);
	public List<?> getAddressDetailsById(long userId);
	public List<?> getExpDetailsById(long userId);
	public List<?> getAgnProfileDetailsById(long userId);
	
}
