package org.easymis.easysaas.gateway.controller;

import org.easymis.easysaas.common.result.RestResult;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

/**
 *
 * @author ardiansyah
 */
@RestController
public class ResourceController {
	
	@RequestMapping(value = "/resource/user", method = RequestMethod.GET)
	public Mono<ResponseEntity<?>> user() {
		return Mono.just(ResponseEntity.ok(RestResult.buildSuccess("Content for user")));
	}
	
	@RequestMapping(value = "/resource/admin", method = RequestMethod.GET)
	public Mono<ResponseEntity<?>> admin() {
		return Mono.just(ResponseEntity.ok(RestResult.buildSuccess("Content for admin")));
	}
	
	@RequestMapping(value = "/resource/user-or-admin", method = RequestMethod.GET)
	public Mono<ResponseEntity<?>> userOrAdmin() {
		return Mono.just(ResponseEntity.ok(RestResult.buildSuccess("Content for user or admin")));
	}
}
