package com.example;

import com.example.management.ManagementBook;
import com.example.management.ManagementCustomer;
import com.example.management.ManagementOrder;

import java.util.Scanner;

public class Madang {
    static Scanner sc = new Scanner(System.in);
    static DBManager DBm = new DBManager();

    public static void main (String[] args){
        MainLoop:
        while(true){

            System.out.println("[Main] 실행하실 명령 번호를 입력하세요.");
            System.out.println("[1] 도서 관리");
            System.out.println("[2] 고객 관리");
            System.out.println("[3] 판매 관리");
            System.out.println("[0] 종료");

            int action = sc.nextInt();

            switch (action){
                case 1:
                    ManagementBook.Run();
                    break;
                case 2:
                    ManagementCustomer.Run();
                    break;
                case 3:
                    try{
                        ManagementOrder.Run();
                    }catch(Exception e){
                        e.printStackTrace();
                    }
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
