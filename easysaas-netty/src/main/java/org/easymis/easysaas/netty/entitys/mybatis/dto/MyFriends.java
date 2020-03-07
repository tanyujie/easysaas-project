package org.easymis.easysaas.netty.entitys.mybatis.dto;

public class MyFriends {
	private String id;

	private String myUserId;
	private String myFriendUserId;

	/**
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 *
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return my_user_id
	 */
	public String getMyUserId() {
		return myUserId;
	}

	/**
	 *
	 */
	public void setMyUserId(String myUserId) {
		this.myUserId = myUserId;
	}

	/**
	 * @return my_friend_user_id
	 */
	public String getMyFriendUserId() {
		return myFriendUserId;
	}

	/**
	 *
	 */
	public void setMyFriendUserId(String myFriendUserId) {
		this.myFriendUserId = myFriendUserId;
	}
}
