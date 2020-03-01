package com.example.management;

import com.example.DBManager;
import com.example.dao.ODao;

import java.util.Scanner;

public class ManagementOrder {

    static Scanner sc = new Scanner(System.in);
    static DBManager DBm = new DBManager();

    public static void Run(){
        ODao oDao = new ODao(DBm);
        while(true) {
            System.out.println("[판매관리] 실행하실 명령 번호를 입력하세요.");
            System.out.println("[1] 도서 판매");
            System.out.println("[2] 판매금액 관리");
            System.out.println("[0] 뒤로");
            int sub_action = sc.nextInt();
            switch (sub_action) {
                case 1:
                    System.out.println("[도서 판매] 구매 고객 번호 입력");
                    int cust_id = sc.nextInt();

                    System.out.println("[도서 판매] 판매 도서 번호 입력");
                    int book_id = sc.nextInt();

                    oDao.getBookPrice(cust_id, book_id);

                    System.out.println("[도서 판매] 구매 Y / N as AnyKEY");
                    String response = sc.next();
                    if(response=="Y"){
                        break;
//                        new ODao(DBm).order(cust_id,book_id,122);
                    }
                    break;
                case 0:
                    return;
            }
        }
    }
}
