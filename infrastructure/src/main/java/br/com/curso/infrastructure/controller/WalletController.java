package br.com.curso.infrastructure.controller;

import br.com.curso.infrastructure.dto.request.TransferRequest;
import br.com.curso.infrastructure.dto.response.BaseResponse;
import br.com.curso.infrastructure.dto.response.ConsultBalanceResponse;
import br.com.curso.usecase.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/wallet")
public class WalletController {

    final private ConsultBalanceUseCase consultBalanceUseCase;
    final private TransferUseCase transferUseCase;
    final private CreateTransactionUseCase createTransactionUseCase;
    final private FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase;
    final private TransactionValidateUseCase transactionValidateUseCase;
    final private TransactionPinValidateUseCase transactionPinValidateUseCase;
    final private UserNotificationUseCase userNotificationUseCase;

    public WalletController(ConsultBalanceUseCase consultBalanceUseCase, TransferUseCase transferUseCase, CreateTransactionUseCase createTransactionUseCase, FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase, TransactionValidateUseCase transactionValidateUseCase, TransactionPinValidateUseCase transactionPinValidateUseCase, UserNotificationUseCase userNotificationUseCase) {
        this.consultBalanceUseCase = consultBalanceUseCase;
        this.transferUseCase = transferUseCase;
        this.createTransactionUseCase = createTransactionUseCase;
        this.findWalletByTaxNumberUseCase = findWalletByTaxNumberUseCase;
        this.transactionValidateUseCase = transactionValidateUseCase;
        this.transactionPinValidateUseCase = transactionPinValidateUseCase;
        this.userNotificationUseCase = userNotificationUseCase;
    }

    @GetMapping("/consultBalance/{taxNumber}")
    public BaseResponse<ConsultBalanceResponse> consultBalance(@PathVariable String taxNumber) throws Exception {
        var balance = consultBalanceUseCase.consult(taxNumber);
        return BaseResponse.<ConsultBalanceResponse>builder().success(true).result(new ConsultBalanceResponse(balance)).build();
    }

    @PostMapping("/transfer")
    public BaseResponse<String> transfer(@RequestBody TransferRequest transferRequest) throws Exception {
        var from = findWalletByTaxNumberUseCase.findByTaxNumber(transferRequest.fromTaxNumber());
        transactionPinValidateUseCase.validate(from.getTransactionPin(), transferRequest.pin());
        var to = findWalletByTaxNumberUseCase.findByTaxNumber(transferRequest.toTaxNumber());
        var transaction = createTransactionUseCase.create(from, to, transferRequest.value());
        transactionValidateUseCase.validate(transaction);
        transferUseCase.transfer(transaction);
        userNotificationUseCase.notificate(transaction, from.getUser().getEmain());
        return BaseResponse.<String>builder().success(true).message("Transferência realizada com sucesso").build();
    }
}
