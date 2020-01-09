package org.easymis.easysaas.gateway.security.userdetail;

import java.io.Serializable;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Permit implements Serializable{

    private String userNo;

    private String  phoneNumber;
}
