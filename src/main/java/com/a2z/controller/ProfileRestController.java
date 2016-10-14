package com.a2z.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.a2z.model.Address;
import com.a2z.model.AgencyProfilePersonalInfo;
import com.a2z.model.PhysicalDetails;
import com.a2z.model.ProfessinalWorkExp;
import com.a2z.service.ProfileService;
import com.a2z.to.AddressTo;
import com.a2z.to.AgencyProfilePersonalInfoTo;
import com.a2z.to.PhysicalDetailsTo;
import com.a2z.to.ProfessinalWorkExpTo;
import com.a2z.to.UserProfilePersonalInfoTo;

@RestController
public class ProfileRestController {
	@Autowired
	ProfileService profileService;

	// @Autowired
	// private FileUploadDAO fileUploadDao;

	@RequestMapping(value = "/profile/", method = RequestMethod.POST)
	public ResponseEntity<Void> userProfilePersonalInfo(
			@RequestBody UserProfilePersonalInfoTo userProfilePersonalInfoTo, UriComponentsBuilder ucBuilder) {
		profileService.saveUserProfilePersonalInfo(userProfilePersonalInfoTo);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/profile/{profileDetailsId}")
				.buildAndExpand(userProfilePersonalInfoTo.getProfileDetailsId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/physicalDetails/", method = RequestMethod.POST)
	public PhysicalDetails userPhysicalDetails(@RequestBody PhysicalDetailsTo physicalDetailsTo,
			UriComponentsBuilder ucBuilder) {
		PhysicalDetails uphydetails = profileService.saveUserPhysicalDetails(physicalDetailsTo);
		return uphydetails;
	}

	@RequestMapping(value = "/userAddress/", method = RequestMethod.POST)
	public Address userAddressDetails(@RequestBody AddressTo addressTo, UriComponentsBuilder ucBuilder) {
		Address uaddres = profileService.saveUserAddressDetails(addressTo);
		return uaddres;
	}

	@RequestMapping(value = "/userProExp/", method = RequestMethod.POST)
	public ProfessinalWorkExp userProfessinalExpDetails(@RequestBody ProfessinalWorkExpTo professinalWorkExpTo,
			UriComponentsBuilder ucBuilder) {
		ProfessinalWorkExp prowrkex = profileService.saveUserProWorkExp(professinalWorkExpTo);
		return prowrkex;
	}

	@RequestMapping(value = "/agencyprofileinfo/", method = RequestMethod.POST)
	public AgencyProfilePersonalInfo userAgencyProfilePersonalInfo(
			@RequestBody AgencyProfilePersonalInfoTo agencyProfilePersonalInfoTo, UriComponentsBuilder ucBuilder) {
		System.out.println("getOfficeContNo :" + agencyProfilePersonalInfoTo.getOfficeContNo() + "," + "getService:"
				+ agencyProfilePersonalInfoTo.getService() + "," + "getWebsite:"
				+ agencyProfilePersonalInfoTo.getWebsite());
		AgencyProfilePersonalInfo appinfo = profileService.saveAgencyProfilePersonalInfo(agencyProfilePersonalInfoTo);
		return appinfo;
	}

	@RequestMapping(value = "/getProfileDetailsById/{userId}", method = RequestMethod.GET)
	public ResponseEntity<List<?>> getProfileDetailsById(@PathVariable("userId") long userId) {
		UserProfilePersonalInfoTo uses = new UserProfilePersonalInfoTo();
		uses.setUserId(userId);
		// System.out.println("Fetching User with id " + uses.getUserId());
		List<?> user = (List<?>) profileService.getProfileDetailsById(uses.getUserId());
		// System.out.println("getUserDetailsProfile :"+user);
		return new ResponseEntity<List<?>>(user, HttpStatus.OK);
	}

	/*
	 * ==============================All get type
	 * method=================================
	 */

	@RequestMapping(value = "/getPhysicalDetailsById/{userId}", method = RequestMethod.GET)
	public ResponseEntity<List<?>> getPhysicalDetailsById(@PathVariable("userId") long userId) {
		PhysicalDetailsTo uses = new PhysicalDetailsTo();
		uses.setUserId(userId);
		// System.out.println("Fetching User with id " + uses.getUserId());
		List<?> user = (List<?>) profileService.getPhysicalDetailsById(uses.getUserId());
		// System.out.println("getPhysicalDetailsById :"+user);
		return new ResponseEntity<List<?>>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/getAddressDetailsById/{userId}", method = RequestMethod.GET)
	public ResponseEntity<List<?>> getAddressDetailsById(@PathVariable("userId") long userId) {
		AddressTo addr = new AddressTo();
		addr.setUserId(userId);
		// System.out.println("Fetching User with id " + addr.getUserId());
		List<?> addrs = (List<?>) profileService.getAddressDetailsById(addr.getUserId());
		// System.out.println("getPhysicalDetailsById :"+addrs);
		return new ResponseEntity<List<?>>(addrs, HttpStatus.OK);
	}

	@RequestMapping(value = "/getExpDetailsById/{userId}", method = RequestMethod.GET)
	public ResponseEntity<List<?>> getExpDetailsById(@PathVariable("userId") long userId) {
		ProfessinalWorkExpTo pfwork = new ProfessinalWorkExpTo();
		pfwork.setUserId(userId);
		// System.out.println("Fetching User with id " + pfwork.getUserId());
		List<?> pfworkex = (List<?>) profileService.getExpDetailsById(pfwork.getUserId());
		// System.out.println("getExpDetailsById :"+pfworkex);
		return new ResponseEntity<List<?>>(pfworkex, HttpStatus.OK);
	}

	@RequestMapping(value = "/getAgnProfileDetailsById/{userId}", method = RequestMethod.GET)
	public ResponseEntity<List<?>> getAgnProfileDetailsById(@PathVariable("userId") long userId) {
		AgencyProfilePersonalInfoTo agpinfo = new AgencyProfilePersonalInfoTo();
		agpinfo.setUserId(userId);
		// System.out.println("Fetching User with id " + agpinfo.getUserId());
		List<?> agpinfolist = (List<?>) profileService.getAgnProfileDetailsById(agpinfo.getUserId());
		// System.out.println("getExpDetailsById :"+agpinfolist);
		return new ResponseEntity<List<?>>(agpinfolist, HttpStatus.OK);
	}

	/*
	 * ==============================Picture upload
	 * Profile=================================
	 */

	/*
	 * @RequestMapping(value="/newDocument", headers =
	 * "'Content-Type': 'multipart/form-data'", method = RequestMethod.POST)
	 * public void UploadFile(MultipartHttpServletRequest request,
	 * HttpServletResponse response) {
	 * 
	 * Iterator<String> itr=request.getFileNames();
	 * 
	 * MultipartFile file=request.getFile(itr.next());
	 * 
	 * String fileName=file.getOriginalFilename(); System.out.println(fileName);
	 * }
	 */

	/*
	 * @RequestMapping(value = "/doUpload/", method = RequestMethod.POST) public
	 * ResponseEntity<Void> doUpload(@RequestBody UploadFile
	 * uploadFile,CommonsMultipartFile[] fileUpload,UriComponentsBuilder
	 * ucBuilder) throws Exception { System.out.println("Saving file: "); if
	 * (fileUpload != null && fileUpload.length > 0) { for (CommonsMultipartFile
	 * aFile : fileUpload){ System.out.println("Saving file: " +
	 * aFile.getOriginalFilename());
	 * uploadFile.setFileName(aFile.getOriginalFilename());
	 * uploadFile.setData(aFile.getBytes()); fileUploadDao.save(uploadFile); } }
	 * 
	 * HttpHeaders headers = new HttpHeaders();
	 * headers.setLocation(ucBuilder.path("/doUpload/{id}").buildAndExpand(
	 * uploadFile.getId()).toUri()); return new ResponseEntity<Void>(headers,
	 * HttpStatus.CREATED); }
	 */
}
