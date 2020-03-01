package com.example.management;

import com.example.DBManager;

import java.util.Scanner;

public class ManagementCustomer {

    static Scanner sc = new Scanner(System.in);
    static DBManager DBm = new DBManager();

    public static void Run(){
        while(true){
            System.out.println("[고객관리] 실행하실 명령 번호를 입력하세요.");
            System.out.println("[1] 고객 정보   생성");
            System.out.println("[2] 고객 정보   관리");
            System.out.println("[3] 고객 포인트 관리");
            System.out.println("[0] 뒤로");
            int sub_action = sc.nextInt();
            switch (sub_action) {
                case 1:
                    break;
                case 0:
                    return;
            }
        }
    }
}
