package project.ymf.src.purchaseMate.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import project.ymf.common.result.ResultCode;
import project.ymf.src.purchaseMate.dto.PurchaseMateDTO;

@Getter
@ApiModel(description = "공동구매 메이트 게시글 응답 모델")
public class PurchaseMateResponse {

    @ApiModelProperty(value = "Http 상태 코드")
    private final int status;
    @ApiModelProperty(value = "Business 상태 코드")
    private final String code;
    @ApiModelProperty(value = "응답 메세지")
    private final String message;
    @ApiModelProperty(value = "응답 데이터")
    private final PurchaseMateDTO data;


    public PurchaseMateResponse(ResultCode resultCode, PurchaseMateDTO data) {
        this.status = resultCode.getStatus();
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = data;
    }

    public static PurchaseMateResponse of(ResultCode resultCode, PurchaseMateDTO data) {
        return new PurchaseMateResponse(resultCode, data);
    }
}
