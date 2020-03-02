package com.example.management;

import com.example.dao.BDao;
import com.example.dto.BDto;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ManagementBook extends Management {
    BDao bDao = new BDao(DBm);
    public void Run(){
        int action =10;

        while(true){
            System.out.println("[도서관리] 실행하실 명령 번호를 입력하세요.");
            System.out.println("[1] 도서 목록 보기");
            System.out.println("[2] 도서 정보 추가");
            System.out.println("[3] 도서 정보 삭제");
            System.out.println("[4] 도서 입고");
            System.out.println("[0] 뒤로");

            try{
                 action = sc.nextInt();
            } catch (InputMismatchException e){
                System.out.println("명령 리스트에 존재하는 정수를 입력해주세요");
                sc = new Scanner(System.in);
            }

            switch (action) {
                case 1:
                    List<BDto> bDtoL = bDao.list();
                    printBookList(bDtoL);
                    break;
                case 2:
                    System.out.println("[도서 정보 추가] 도서 제목 입력");
                    String book_name = sc.next();
                    System.out.println("[도서 정보 추가] 도서 츌판사 입력");
                    String book_publisher = sc.next();
                    System.out.println("[도서 정보 추가] 도서 가격 입력");
                    int book_price = sc.nextInt();

                    bDao.add(new BDto(book_name, book_publisher, book_price));
                    break;
                case 3:
                    System.out.println("[도서 정보 삭제] 도서 번호 입력");
                    int book_id = sc.nextInt();

                    bDao.delete(book_id);
                    break;
                case 4:
                    System.out.println("[도서 수량 입고] 도서 번호 입력");
                    int book_id2 = sc.nextInt();
                    System.out.println("[도서 수량 입고] 입고 수량 입력");
                    int book_stock = sc.nextInt();

                    bDao.receiving(new BDto(book_id2, book_stock));
                    break;
                case 0:
                    return;
                default:
                    System.out.println("잘못된 입력입니다.");
                    break;

            }
        }
    }

    private static void printBookList(List<BDto> bdtoL){
        bdtoL.forEach(bdto->{
            System.out.println(
                    String.format("%-4s",     bdto.get_bookid())
                            + String.format("%-20s",    bdto.get_bookname())
                            + String.format("%-15s",    bdto.get_publisher())
                            + String.format("%-10s",    bdto.get_price())
                            + String.format("%4s",      bdto.get_stock()) );
        });
    }

}
