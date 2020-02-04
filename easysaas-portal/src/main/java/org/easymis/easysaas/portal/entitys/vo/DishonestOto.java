package org.easymis.easysaas.portal.entitys.vo;

import io.searchbox.annotations.JestId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
public class DishonestOto {
    @ApiModelProperty(value = "id")
    @JestId
    private String id;
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "名称(高亮)")
    private String nameHighlight;
    @ApiModelProperty(value = "身份证号码/公司信用代码")
    private String cardCode;
}
