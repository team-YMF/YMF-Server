package project.ymf.src.singingMate.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import project.ymf.common.result.ResultCode;
import project.ymf.src.singingMate.dto.SingingMateApplyDTO;
import project.ymf.src.singingMate.dto.SingingMateDTO;

import java.util.List;

@Getter
@ApiModel(description = "노래방 메이트 신청자 리스트 응답 모델")
public class SingingMateApplyListResponse {

    @ApiModelProperty(value = "Http 상태 코드")
    private final int status;
    @ApiModelProperty(value = "Business 상태 코드")
    private final String code;
    @ApiModelProperty(value = "응답 메세지")
    private final String message;
    @ApiModelProperty(value = "응답 데이터")
    private final List<SingingMateApplyDTO> data;


    public SingingMateApplyListResponse(ResultCode resultCode, List<SingingMateApplyDTO> data) {
        this.status = resultCode.getStatus();
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = data;
    }

    public static SingingMateApplyListResponse of(ResultCode resultCode, List<SingingMateApplyDTO> data) {
        return new SingingMateApplyListResponse(resultCode, data);
    }

}
