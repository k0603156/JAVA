package com.example.management;

import com.example.command.OListCommand;
import com.example.command.OSaleCommand;
import com.example.dao.ODao;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ManagementOrder extends Management  {
    ODao oDao = new ODao(DBm);
    public void Run(){
        int action =10;

        while(true) {
            System.out.println("[판매관리] 실행하실 명령 번호를 입력하세요.");
            System.out.println("[1] 도서 판매");
            System.out.println("[2] 판매 기록");
            System.out.println("[0] 뒤로");

            try{
                action = sc.nextInt();
            } catch (InputMismatchException e){
                System.out.println("명령 리스트에 존재하는 정수를 입력해주세요");
                sc = new Scanner(System.in);
                action=10;
            }

            switch (action) {
                case 1:
                    try{
                    new OSaleCommand(oDao).execute();
                    } catch (Exception e){ System.out.println(e.getMessage());}
                    break;
                case 2:
                    new OListCommand(oDao).execute();
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
