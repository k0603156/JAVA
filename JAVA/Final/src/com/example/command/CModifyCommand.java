package com.example.command;

import com.example.dao.CDao;
import com.example.dto.CDto;

import java.util.Scanner;

public class CModifyCommand implements ICommand{
    Scanner sc = new Scanner(System.in);
    CDao cDao;
    public CModifyCommand(CDao cDao){
        this.cDao=cDao;
    }

    @Override
    public void execute() {
        System.out.println("[고객 정보 수정] 고객 번호 입력");
        int custId = sc.nextInt();
        System.out.println("[고객 정보 수정] 고객 주소 입력");
        String address2 = sc.next();
        System.out.println("[고객 정보 수정] 고객 핸드폰 번호 입력");
        String phone2 = sc.next();

        cDao.modify(new CDto(custId, address2, phone2));
    }
}
