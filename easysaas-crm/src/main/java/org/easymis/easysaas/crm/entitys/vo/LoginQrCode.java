package org.easymis.easysaas.crm.entitys.vo;

import lombok.Builder;
import lombok.Data;

/**
 * 二维码 token与二维码的对应关系
 *
 * @author wangkai  2019/7/20
 */
@Data
@Builder
public class LoginQrCode {

    String token;
    String image;
}
