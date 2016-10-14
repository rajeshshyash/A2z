package com.a2z.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.a2z.dao.ProfileDao;
import com.a2z.dao.UserDao;
import com.a2z.model.Address;
import com.a2z.model.AgencyProfilePersonalInfo;
import com.a2z.model.PhysicalDetails;
import com.a2z.model.ProfessinalWorkExp;
import com.a2z.model.User;
import com.a2z.model.UserProfilePersonalInfo;
import com.a2z.to.AddressTo;
import com.a2z.to.AgencyProfilePersonalInfoTo;
import com.a2z.to.PhysicalDetailsTo;
import com.a2z.to.ProfessinalWorkExpTo;
import com.a2z.to.UserProfilePersonalInfoTo;

@Service("profileService")
@Transactional
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private ProfileDao profileDao;
	@Autowired
	private UserDao userDao;
	
	public void saveUserProfilePersonalInfo(UserProfilePersonalInfoTo userProfilePersonalInfoTo) {
		UserProfilePersonalInfo uppI = new UserProfilePersonalInfo();
		uppI.setFatherName(userProfilePersonalInfoTo.getFatherName());
		uppI.setGender(userProfilePersonalInfoTo.getGender());
		uppI.setDob(userProfilePersonalInfoTo.getDob());
		uppI.setAge(userProfilePersonalInfoTo.getAge());
		uppI.setWhatsupNo(userProfilePersonalInfoTo.getWhatsupNo());
		uppI.setLandlineNo(userProfilePersonalInfoTo.getLandlineNo());
		uppI.setEduQualification(userProfilePersonalInfoTo.getEduQualification());
		uppI.setCourseRelatedProfession(userProfilePersonalInfoTo.getCourseRelatedProfession());
		uppI.setLanguage(userProfilePersonalInfoTo.getLanguage());
		User user = userDao.findUserByUserId(userProfilePersonalInfoTo.getUserId());
		user.setUserId(userProfilePersonalInfoTo.getUserId());
		user.setMobile(userProfilePersonalInfoTo.getMobile());
		user.setEmail(userProfilePersonalInfoTo.getEmail());
		uppI.setUser(user);
		user.getUserProfilePersonalInfo().add(uppI);
		profileDao.saveUserProfilePersonalInfo(uppI);
	}
	
	public PhysicalDetails saveUserPhysicalDetails(PhysicalDetailsTo physicalDetailsTo) {
		
		PhysicalDetails upd = new PhysicalDetails();

		upd.setComplexion(physicalDetailsTo.getComplexion());
		upd.setSkinQuality(physicalDetailsTo.getSkinQuality());
		upd.setEyeColor(physicalDetailsTo.getEyeColor());
		upd.setHeightUnit(physicalDetailsTo.getHeightUnit());
		upd.setWeightUnit(physicalDetailsTo.getWeightUnit());
		upd.setPhysique(physicalDetailsTo.getPhysique());
		upd.setFacialHair(physicalDetailsTo.getFacialHair());
		upd.setHairStyle(physicalDetailsTo.getHairStyle());
		upd.setHairColor(physicalDetailsTo.getHairColor());
		upd.setHairLength(physicalDetailsTo.getHairLength());
		
		User user = userDao.findUserByUserId(physicalDetailsTo.getUserId());
		System.out.println("physicalDetailsTo.getUserId() :"+physicalDetailsTo.getUserId());
		user.setUserId(physicalDetailsTo.getUserId());
		upd.setUser(user);
		
		return profileDao.saveUserPhysicalDetails(upd);
	}


	public Address saveUserAddressDetails(AddressTo addressTo) {
		Address addm = new Address();
		
		addm.setPrAddress(addressTo.getPrAddress());
		addm.setPrCountry(addressTo.getPrCountry());
		addm.setPrState(addressTo.getPrState());
		addm.setPrDistrict(addressTo.getPrDistrict());
		addm.setPrZipPostal(addressTo.getPrZipPostal());
		
		addm.setPmAddress(addressTo.getPmAddress());
		addm.setPmCountry(addressTo.getPmCountry());
		addm.setPmState(addressTo.getPmState());
		addm.setPmDistrict(addressTo.getPmDistrict());
		addm.setPmZipPostal(addressTo.getPmZipPostal());
		
		User user = userDao.findUserByUserId(addressTo.getUserId());
		System.out.println("addressTo.getUserId() :"+addressTo.getUserId());
		user.setUserId(addressTo.getUserId());
		addm.setUser(user);
		
		return profileDao.saveUserAddressDetails(addm);
	}

	public ProfessinalWorkExp saveUserProWorkExp(ProfessinalWorkExpTo professinalWorkExpTo) {
		ProfessinalWorkExp proWorkExp = new ProfessinalWorkExp();
		
		proWorkExp.setPreWorkInd(professinalWorkExpTo.getPreWorkInd());
		proWorkExp.setNameWorkWithDir(professinalWorkExpTo.getNameWorkWithDir());
		proWorkExp.setNameWorkFilm(professinalWorkExpTo.getNameWorkFilm());
		proWorkExp.setNameWorkProHouse(professinalWorkExpTo.getNameWorkProHouse());
		proWorkExp.setFileIndIntreste(professinalWorkExpTo.getFileIndIntreste());
		proWorkExp.setReason(professinalWorkExpTo.getReason());
		
		User user = userDao.findUserByUserId(professinalWorkExpTo.getUserId());
		System.out.println("addressTo.getUserId() :"+professinalWorkExpTo.getUserId());
		user.setUserId(professinalWorkExpTo.getUserId());
		proWorkExp.setUser(user);
		
		return profileDao.saveUserProWorkExp(proWorkExp);
		
	}

	public AgencyProfilePersonalInfo saveAgencyProfilePersonalInfo(AgencyProfilePersonalInfoTo agencyProfilePersonalInfoTo) {
		
		AgencyProfilePersonalInfo appI = new AgencyProfilePersonalInfo();
		
		appI.setNameOfAgency(agencyProfilePersonalInfoTo.getNameOfAgency());
		appI.setOfficeContNo(agencyProfilePersonalInfoTo.getOfficeContNo());
		appI.setWebsite(agencyProfilePersonalInfoTo.getWebsite());
		appI.setService(agencyProfilePersonalInfoTo.getService());
		
		User user = userDao.findUserByUserId(agencyProfilePersonalInfoTo.getUserId());
		System.out.println("agencyProfilePersonalInfoTo.getUserId() :"+agencyProfilePersonalInfoTo.getUserId());
		user.setUserId(agencyProfilePersonalInfoTo.getUserId());
		appI.setUser(user);
		
		return profileDao.saveAgencyProfilePersonalInfo(appI);
	}

	public List<?> getProfileDetailsById(long userId) {
		return profileDao.getProfileDetailsById(userId);
	}

	public List<?> getPhysicalDetailsById(long userId) {
		return profileDao.getPhysicalDetailsById(userId);
	}

	public List<?> getAddressDetailsById(long userId) {
		return profileDao.getAddressDetailsById(userId);
	}

	public List<?> getExpDetailsById(long userId) {
		return profileDao.getExpDetailsById(userId);
	}
	public List<?> getAgnProfileDetailsById(long userId) {
		return profileDao.getAgnProfileDetailsById(userId);
	}
}
