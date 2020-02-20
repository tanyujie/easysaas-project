package org.easymis.easysaas.crm.entitys.vo;

import java.util.List;

import org.easymis.easysaas.crm.entitys.mybatis.dto.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author ard333
 */
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {

	private static final long serialVersionUID = 1L;

	private String username;

	private String password;

	@Getter
	@Setter
	private Boolean enabled;

	@Getter
	@Setter
	private List<Role> roles;

}