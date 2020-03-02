package com.example;

import com.example.management.Management;
import com.example.management.ManagementBook;
import com.example.management.ManagementCustomer;
import com.example.management.ManagementOrder;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Madang extends Management {
    public static void main (String[] args){
        int action=10;
        MainLoop:
        try{
        while(true){
            System.out.println("[Main] 실행하실 명령 번호를 입력하세요.");
            System.out.println("[1] 도서 관리");
            System.out.println("[2] 고객 관리");
            System.out.println("[3] 판매 관리");
            System.out.println("[0] 종료");
            action = sc.nextInt();

                switch (action){
                    case 1:
                        new ManagementBook().Run();
                        break;
                    case 2:
                        new ManagementCustomer().Run();
                        break;
                    case 3:
                        new ManagementOrder().Run();
                        break;
                    case 0:
                        DBm.closeConnection();
                        break MainLoop;
                    default:
                        System.out.println("잘못된 입력입니다.");
                        break;
                }


        }
        } catch (Exception e){
            if(e instanceof InputMismatchException)
                System.out.println("명령 리스트에 존재하는 정수를 입력해주세요");
                sc = new Scanner(System.in);
        }

        System.out.println("종료 됩니다.");
    }

}
