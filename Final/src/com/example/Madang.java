package com.example;

import com.example.management.ManagementBook;
import com.example.management.ManagementCustomer;
import com.example.management.ManagementOrder;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Madang {
    static Scanner sc = new Scanner(System.in);
    static DBManager DBm = new DBManager();
    public static void main (String[] args){
        int action=10;
        MainLoop:

        while(true){
            System.out.println("[Main] 실행하실 명령 번호를 입력하세요.");
            System.out.println("[1] 도서 관리");
            System.out.println("[2] 고객 관리");
            System.out.println("[3] 판매 관리");
            System.out.println("[0] 종료");
            try{
                action = sc.nextInt();
            } catch (Exception e){
                if(e instanceof InputMismatchException)
                    sc = new Scanner(System.in);
                }
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

        System.out.println("종료 됩니다.");
    }

}
