package org.easymis.easysaas.imserver.controller;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.imserver.config.FastDFSClient;
import org.easymis.easysaas.imserver.entitys.bo.UsersBO;
import org.easymis.easysaas.imserver.entitys.mybatis.dto.ChatMsg;
import org.easymis.easysaas.imserver.entitys.mybatis.dto.Member;
import org.easymis.easysaas.imserver.entitys.vo.MemberVO;
import org.easymis.easysaas.imserver.entitys.vo.MyFriendsVO;
import org.easymis.easysaas.imserver.enums.OperatorFriendRequestTypeEnum;
import org.easymis.easysaas.imserver.enums.SearchFriendsStatusEnum;
import org.easymis.easysaas.imserver.n3r.idworker.Sid;
import org.easymis.easysaas.imserver.service.MemberService;
import org.easymis.easysaas.imserver.utils.FileUtils;
import org.easymis.easysaas.imserver.utils.MD5Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class IndexController {

	@RequestMapping("/index")
	public String index() throws NoSuchAlgorithmException {
		return "/customerService";
	}

}
