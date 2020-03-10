package org.easymis.easysaas.crm.service;

import org.easymis.easysaas.crm.entitys.dto.Member;
import org.easymis.easysaas.crm.entitys.vo.User;

import reactor.core.publisher.Mono;

public interface MemberService {
	public Mono<User> findByUsername(String username);

	public Member findById(String memberId);

	public Member findByMobile(String mobile);

	Member findByEmail(String email);

	Member saveQuickRegister(String phoneNumber);
}
