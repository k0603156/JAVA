package com.example.command;

import com.example.dao.CDao;
import com.example.dto.CDto;

import java.util.Scanner;

public class CAddCommand implements ICommand{
    Scanner sc = new Scanner(System.in);
    CDao cDao;
    public CAddCommand(CDao cDao){
        this.cDao=cDao;
    }
    @Override
    public void execute() {
        System.out.println("[고객 정보 추가] 고객 이름 입력");
        String name = sc.next();
        System.out.println("[고객 정보 추가] 고객 주소 입력");
        String address = sc.next();
        System.out.println("[고객 정보 추가] 고객 핸드폰 번호 입력");
        String phone = sc.next();

        cDao.add(new CDto(name, address, phone));
    }
}
