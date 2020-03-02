package com.example.management;

import com.example.command.CAddCommand;
import com.example.command.CListCommand;
import com.example.command.CModifyCommand;
import com.example.dao.CDao;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ManagementCustomer extends Management  {
    CDao cDao = new CDao(DBm);
    public void Run(){
        int action =10;

        while(true){
            System.out.println("[고객관리] 실행하실 명령 번호를 입력하세요.");
            System.out.println("[1] 고객 정보 리스트");
            System.out.println("[2] 고객 정보   생성");
            System.out.println("[3] 고객 정보   수정");
            System.out.println("[4] 고객 포인트 관리");
            System.out.println("[0] 뒤로");

            try{
                action = sc.nextInt();
            } catch (InputMismatchException e){
                System.out.println("명령 리스트에 존재하는 정수를 입력해주세요");
                sc = new Scanner(System.in);
            }

            switch (action) {
                case 1:
                    new CListCommand(cDao).execute();
                    break;
                case 2:
                    new CAddCommand(cDao).execute();
                    break;
                case 3:
                    new CModifyCommand(cDao).execute();
                    break;
                case 4:
                    System.out.println("[고객 포인트 관리] 고객 포인트 관리 미구현");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("잘못된 입력입니다.");
                    break;
            }
        }
    }

}


