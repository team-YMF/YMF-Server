package project.ymf.src.purchaseMate;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.ymf.common.result.ResultCode;
import project.ymf.common.result.ResultResponse;
import project.ymf.src.purchaseMate.dto.*;
import project.ymf.src.purchaseMate.response.PurchaseMateApplyListResponse;
import project.ymf.src.purchaseMate.response.PurchaseMateInfoResponse;
import project.ymf.src.purchaseMate.response.PurchaseMateListResponse;

import java.util.List;

@Api(tags = "PurchaseMate")
@RestController
@RequestMapping("/purchase")
@RequiredArgsConstructor
public class PurchaseMateController {
    private final PurchaseMateService purchaseMateService;
    @ApiOperation(value = "공동구매 메이트 모집글 등록하기")
    @PostMapping()
    public ResponseEntity<ResultResponse> postPurchase(@RequestBody PurchaseMateRequest request){
        purchaseMateService.postPurchase(request);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.POST_STUDY_MATE_SUCCESS));
    }

    @ApiOperation(value = "공동구매 메이트 모집글 수정하기")
    @PutMapping("/{purchaseId}")
    public ResponseEntity<ResultResponse> editPurchase(@PathVariable Long purchaseId,
                                                      @RequestBody PurchaseMateRequest request){
        purchaseMateService.editPurchase(purchaseId, request);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.PUT_PURCHASE_MATE_SUCCESS));
    }

    @ApiOperation(value = "공동구매 메이트 모집글 자세히보기")
    @GetMapping("/{purchaseId}")
    public ResponseEntity<PurchaseMateInfoResponse> getPurchaseInfo(@PathVariable Long purchaseId){
        PurchaseMateInfoDTO data = purchaseMateService.getPurchaseInfo(purchaseId);
        return ResponseEntity.ok(PurchaseMateInfoResponse.of(ResultCode.GET_PURCHASE_MATE_INFO_SUCCESS, data));
    }

    @ApiOperation(value = "공동구매 메이트 신청/취소하기")
    @PostMapping("/apply/{purchaseId}")
    public ResponseEntity<ResultResponse> applyPurchase(@PathVariable Long purchaseId,
                                                       @RequestBody PurchaseMateApplyRequest request){
        ResultCode result = purchaseMateService.applyPurchase(purchaseId,request);
        return ResponseEntity.ok(ResultResponse.of(result));
    }

    @ApiOperation(value = "공동구매 메이트 모집글 삭제하기")
    @DeleteMapping("/{purchaseId}")
    public ResponseEntity<ResultResponse> deletePurchase(@PathVariable Long purchaseId){
        purchaseMateService.deletePurchase(purchaseId);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.DELETE_PURCHASE_MATE_SUCCESS));
    }

    @ApiOperation(value = "공동구매 메이트 모집 완료하기")
    @PostMapping("/complete/{purchaseId}")
    public ResponseEntity<ResultResponse> completePurchase(@PathVariable Long purchaseId){
        purchaseMateService.completePurchase(purchaseId);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.COMPLETE_PURCHASE_MATE_SUCCESS));
    }

    @ApiOperation(value = "공동구매 메이트 신청자목록 조회하기")
    @GetMapping("/apply/{purchaseId}")
    public ResponseEntity<PurchaseMateApplyListResponse> getPurchaseApplies(@PathVariable Long purchaseId){
        List<PurchaseMateApplyDTO> data = purchaseMateService.getPurchaseApplies(purchaseId);
        return ResponseEntity.ok(PurchaseMateApplyListResponse.of(ResultCode.GET_PURCHASE_MATE_APPLIES_SUCCESS, data));
    }

    @ApiOperation(value = "공동구매 메이트 신청자 수락/취소하기")
    @PostMapping("/accept/{purchaseId}")
    public ResponseEntity<ResultResponse> acceptPurchase(@PathVariable Long purchaseId,
                                                        @RequestBody PurchaseMateAcceptRequest request){
        ResultCode result = purchaseMateService.acceptPurchase(purchaseId,request);
        return ResponseEntity.ok(ResultResponse.of(result));

    }

    @ApiOperation(value = "공동구매 메이트 모집글 조회하기(전체)")
    @GetMapping()
    public ResponseEntity<PurchaseMateListResponse> getAllPurchase(){
        List<PurchaseMateDTO>data = purchaseMateService.getAllPurchase();
        return ResponseEntity.ok(PurchaseMateListResponse.of(ResultCode.GET_MY_PURCHASE_MATE_LIST_SUCCESS, data));
    }

    @ApiOperation(value = "공동구매 메이트 모집글 검색하기")
    @GetMapping("/search")
    public ResponseEntity<PurchaseMateListResponse> getSearchedPurchase(@RequestParam String keyword){
        List<PurchaseMateDTO>data = purchaseMateService.getSearchedPurchase(keyword);
        return ResponseEntity.ok(PurchaseMateListResponse.of(ResultCode.GET_SEARCHED_PURCHASE_MATE_LIST_SUCCESS,data));
    }

    @ApiOperation(value = "나의 공동구매 메이트 조회하기")
    @GetMapping("/mine")
    public ResponseEntity<PurchaseMateListResponse> getMyPurchase(){
        List<PurchaseMateDTO>data = purchaseMateService.getMyPurchase();
        return ResponseEntity.ok(PurchaseMateListResponse.of(ResultCode.GET_MY_PURCHASE_MATE_LIST_SUCCESS,data));
    }
}
