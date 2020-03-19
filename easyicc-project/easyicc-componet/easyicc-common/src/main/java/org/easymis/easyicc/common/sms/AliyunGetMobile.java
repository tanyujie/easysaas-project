package org.easymis.easyicc.common.sms;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dypnsapi.model.v20170525.GetMobileRequest;
import com.aliyuncs.dypnsapi.model.v20170525.GetMobileResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class AliyunGetMobile {
	private final static DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4Fc9wsW19HcYANExisGc", "u1OqkUUPJC3KY48qFM8D6d1SLBax1S");

	public static GetMobileResponse get(String accessToken) {
		IAcsClient client = new DefaultAcsClient(profile);
		GetMobileRequest request = new GetMobileRequest();
		request.setAccessToken(accessToken);
		GetMobileResponse response = new GetMobileResponse();
		try {
			response = client.getAcsResponse(request);
			log.debug(new Gson().toJson(response));
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (ClientException e) {
			log.info("ErrCode:" + e.getErrCode());
			log.info("ErrMsg:" + e.getErrMsg());
			log.info("RequestId:" + e.getRequestId());
		}

		return response;

	}
    public static void main(String[] args) {
    	String accessToken="eyJjIjoiYlZ1dDExWU9nTWRUZEtrQjRPOWJSMHRST2YvL1djZXB3UkszMGh3M0FodWFvYlNzSVJMNUV0QmlqUEYzIFVGbGpSSG56c0hWOFZHZFlBZUhwQk1RbXBWRWN5YUh4ejNkK1NDZFd2NzlLdXZKZkRqZVc4Nng4OXdGeSBObFRoUWJJdnR3bG4zb3ljZFJNa2pEZkdOTVVrSUdqdUdXZDVXSGlNV3djek1yT2U0VEYyMTZjZGV2K2UgVlhyT2RqUEFLWi9GZTJSU3BnMk9SY3hSRGJiRk5uRXFweGR5d09wV3hLaUp6ZjZSQlYzeWtKOG9jbDMrIHFkMkpPRXJZTERRRHc0WldNYi93QU1xRnROcFFjWkdFR1c4Q0tLY3JRSm9aZUN2V2V6T1JkREFjZWQ0MyBVRk1lcmdxdHpUZ1hMWXlpMGxlVXJNamlTbkZ4dzJnbGRrVFJubFh2aXlINFZVcFBQaUlUWng5V2ZaOWkgcUFBYk9kR29TUDJsZSt3Q0hPV1dMdmlUOGVMTEZoclY0MVBEQ0lYWmZHb2ZsVXJyTVB4RWViTldKdUorIHZUMnpQK0pVbEJoSlZsdUVwRVRLZ09MSDFQMlpEY0ZWcENyRUg1YnJPVWQ4aDJWVTV0MlZTNkdZSmxCdCByZlA5WE1Xc2NmNlN3WTFtU3FyVnloemxrTmRvZG5XSmplSm9kYlVra0ZJNTFFeFArZG1mbi9QdUtjUnEgK2o2dmNTcDdKT21rc0hHVmtKNGQ0S1NhWHNkeXlyN0pRT2RmZFhiVmI3cG5LcjEydjNXMG9oeXl6NGVHIGRWUXVFRHhrN1hXMUxiczRhb0lKbFBhL2Eyd0tma3RDOXB2a296VVIiLCJrIjoicEh2UFJsOTN3cU9KQ3FqbmNrTmd3Uy9NbmpMVDdMWGJHZENLZGNKUkJwSFJsZGVVNlpZK28rN0U4cC9BRnpuNnBuWkljNUJlR3RLMXY2T1pvZHkxUTlHeGQyNG5IN2NpL29jREdaUHF1STJET0M1dkxaUXl3SjI4cEsvL1ZZbW9nWXkrbWdIay9TRzRHRWsyVm5qVEhhcnk3UDE0ZTBOSEhRMW1UNCtKcStMYkk4UE1mZnB6QXdSWnB2SyttQ0hNakdUcXlmc2tNYXhpY3lJUlpzVkRnRGFzcnQrUzc3UENCUDBDNmgwSmlhMTFiMTNMWXpsb0NZYy91eGozbDlNTWlrWkJ4dnFYcTNDN0pGTjNQWXRZZldCTWd0emNKY0ZXbWMzQWNnd3FleXYzY2srSmhqRGpaZXd6b05MOFJsQWdYcnpKSExlVU5vN0RoKzlsSmVHazJBPT0iLCJvIjoiQW5kcm9pZCJ9";
    	System.out.print(accessToken.length());
    	System.out.println(AliyunGetMobile.get(accessToken).getCode());
    }

}
