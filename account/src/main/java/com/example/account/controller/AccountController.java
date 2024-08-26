package com.example.account.controller;

import com.example.account.service.AccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author : zhaojh
 * @date : 2024-08-08
 * @function :
 */

@RestController
@RequestMapping("/account")
public class AccountController {

    @Resource
    private AccountService accountServiceImpl;

    /**
     * 扣减账户余额
     * @param userId 用户id
     * @param money 金额
     * @return
     */
    @RequestMapping("decrease")
    public String decrease(@RequestParam("userId") Long userId,@RequestParam("money") BigDecimal money){
        accountServiceImpl.decrease(userId,money);
        return "Account decrease success";
    }
}
