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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
    private MemberService userService;
	@Autowired
	private FastDFSClient fastDFSClient;
	
    @Autowired
    private Sid sid;

    @PostMapping("/registOrLogin")
    public RestResult registOrLogin(@RequestBody Member user) throws NoSuchAlgorithmException {
        if (StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword())) {
        	
            return RestResult.buildError("username or password can't be null");
        }
        boolean usernameIsExist = userService.queryUsernameIsExist(user.getUsername());
        Member userResult = null;
        //存在则登录，否则注册
        if (usernameIsExist) {
            userResult = userService.queryUserForLogin(user.getUsername(), MD5Utils.getMD5Str(user.getPassword()));
            if (userResult == null) {
                return RestResult.buildError("username or password is illegal");
            }
        } else {
            user.setNickname(user.getUsername());
            user.setFaceImage("");
            user.setFaceImageBig("");
            user.setPassword(MD5Utils.getMD5Str(user.getPassword()));
            userResult = userService.saveUser(user);
        }
        MemberVO userVO = new MemberVO();
        BeanUtils.copyProperties(userResult, userVO);
        return RestResult.buildSuccess(userVO);
    }
    /**
	 * @Description: 上传用户头像
	 */
	@PostMapping("/uploadFaceBase64")
	public RestResult uploadFaceBase64(@RequestBody UsersBO userBO) throws Exception {
		
		// 获取前端传过来的base64字符串, 然后转换为文件对象再上传
		String base64Data = userBO.getFaceData();
		String userFacePath = "C:\\" + userBO.getUserId() + "userface64.png";
		FileUtils.base64ToFile(userFacePath, base64Data);
		
		// 上传文件到fastdfs
		MultipartFile faceFile = FileUtils.fileToMultipart(userFacePath);
		String url = fastDFSClient.uploadBase64(faceFile);
		System.out.println(url);
		
//		"dhawuidhwaiuh3u89u98432.png"
//		"dhawuidhwaiuh3u89u98432_80x80.png"
		
		// 获取缩略图的url
		String thump = "_80x80.";
		String arr[] = url.split("\\.");
		String thumpImgUrl = arr[0] + thump + arr[1];
		
		// 更细用户头像
		Member user = new Member();
		user.setId(userBO.getUserId());
		user.setFaceImage(thumpImgUrl);
		user.setFaceImageBig(url);
		
		Member result = userService.updateUserInfo(user);
		
		return RestResult.buildSuccess(result);
	}
	
	/**
	 * @Description: 设置用户昵称
	 */
	@PostMapping("/setNickname")
	public RestResult setNickname(@RequestBody UsersBO userBO) throws Exception {
		
		Member user = new Member();
		user.setId(userBO.getUserId());
		user.setNickname(userBO.getNickname());
		
		Member result = userService.updateUserInfo(user);
		
		return RestResult.buildSuccess(result);
	}
	
	/**
	 * @Description: 搜索好友接口, 根据账号做匹配查询而不是模糊查询
	 */
	@PostMapping("/search")
	public RestResult searchUser(String myUserId, String friendUsername)
			throws Exception {
		
		// 0. 判断 myUserId friendUsername 不能为空
		if (StringUtils.isBlank(myUserId) 
				|| StringUtils.isBlank(friendUsername)) {
			return RestResult.buildError("");
		}
		
		// 前置条件 - 1. 搜索的用户如果不存在，返回[无此用户]
		// 前置条件 - 2. 搜索账号是你自己，返回[不能添加自己]
		// 前置条件 - 3. 搜索的朋友已经是你的好友，返回[该用户已经是你的好友]
		Integer status = userService.preconditionSearchFriends(myUserId, friendUsername);
		if (status == SearchFriendsStatusEnum.SUCCESS.status) {
			Member user = userService.queryUserInfoByUsername(friendUsername);
			MemberVO userVO = new MemberVO();
			BeanUtils.copyProperties(user, userVO);
			return RestResult.buildSuccess(userVO);
		} else {
			String errorMsg = SearchFriendsStatusEnum.getMsgByKey(status);
			return RestResult.buildError(errorMsg);
		}
	}
	
	
	/**
	 * @Description: 发送添加好友的请求
	 */
	@PostMapping("/addFriendRequest")
	public RestResult addFriendRequest(String myUserId, String friendUsername)
			throws Exception {
		
		// 0. 判断 myUserId friendUsername 不能为空
		if (StringUtils.isBlank(myUserId) 
				|| StringUtils.isBlank(friendUsername)) {
			return RestResult.buildError("");
		}
		
		// 前置条件 - 1. 搜索的用户如果不存在，返回[无此用户]
		// 前置条件 - 2. 搜索账号是你自己，返回[不能添加自己]
		// 前置条件 - 3. 搜索的朋友已经是你的好友，返回[该用户已经是你的好友]
		Integer status = userService.preconditionSearchFriends(myUserId, friendUsername);
		if (status == SearchFriendsStatusEnum.SUCCESS.status) {
			userService.sendFriendRequest(myUserId, friendUsername);
		} else {
			String errorMsg = SearchFriendsStatusEnum.getMsgByKey(status);
			return RestResult.buildError(errorMsg);
		}
		
		return RestResult.buildSuccess();
	}
	
	/**
	 * @Description: 发送添加好友的请求
	 */
	@PostMapping("/queryFriendRequests")
	public RestResult queryFriendRequests(String userId) {
		
		// 0. 判断不能为空
		if (StringUtils.isBlank(userId)) {
			return RestResult.buildError("");
		}
		
		// 1. 查询用户接受到的朋友申请
		return RestResult.buildSuccess(userService.queryFriendRequestList(userId));
	}
	
	
	/**
	 * @Description: 接受方 通过或者忽略朋友请求
	 */
	@PostMapping("/operFriendRequest")
	public RestResult operFriendRequest(String acceptUserId, String sendUserId,
												Integer operType) {
		
		// 0. acceptUserId sendUserId operType 判断不能为空
		if (StringUtils.isBlank(acceptUserId) 
				|| StringUtils.isBlank(sendUserId) 
				|| operType == null) {
			return RestResult.buildError("");
		}
		
		// 1. 如果operType 没有对应的枚举值，则直接抛出空错误信息
		if (StringUtils.isBlank(OperatorFriendRequestTypeEnum.getMsgByType(operType))) {
			return RestResult.buildError("");
		}
		
		if (operType == OperatorFriendRequestTypeEnum.IGNORE.type) {
			// 2. 判断如果忽略好友请求，则直接删除好友请求的数据库表记录
			userService.deleteFriendRequest(sendUserId, acceptUserId);
		} else if (operType == OperatorFriendRequestTypeEnum.PASS.type) {
			// 3. 判断如果是通过好友请求，则互相增加好友记录到数据库对应的表
			//	   然后删除好友请求的数据库表记录
			userService.passFriendRequest(sendUserId, acceptUserId);
		}
		
		// 4. 数据库查询好友列表
		List<MyFriendsVO> myFirends = userService.queryMyFriends(acceptUserId);
		
		return RestResult.buildSuccess(myFirends);
	}
	
	/**
	 * @Description: 查询我的好友列表
	 */
	@PostMapping("/myFriends")
	public RestResult myFriends(String memberId) {
		// 0. memberId 判断不能为空
		if (StringUtils.isBlank(memberId)) {
			return RestResult.buildError("");
		}
		
		// 1. 数据库查询好友列表
		List<MyFriendsVO> myFirends = userService.queryMyFriends(memberId);
		
		return RestResult.buildSuccess(myFirends);
	}
	
	/**
	 * 
	 * @Description: 用户手机端获取未签收的消息列表
	 */
	@PostMapping("/getUnReadMsgList")
	public RestResult getUnReadMsgList(String acceptMemberId) {
		// 0. userId 判断不能为空
		if (StringUtils.isBlank(acceptMemberId)) {
			return RestResult.buildError("");
		}
		
		// 查询列表
		List<ChatMsg> unreadMsgList = userService.getUnReadMsgList(acceptMemberId);
		
		return RestResult.buildSuccess(unreadMsgList);
	}
}
