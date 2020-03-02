package com.example.command;

import com.example.dao.ODao;
import com.example.dto.ODto;

import java.sql.SQLException;
import java.util.Scanner;

public class OSaleCommand implements ICommand{
    Scanner sc = new Scanner(System.in);
    ODao oDao;
    public OSaleCommand(ODao oDao){
        this.oDao= oDao;
    }
    @Override
    public void execute() throws Exception {
        System.out.println("[도서 판매] 구매 고객 번호 입력");
        int cust_id = sc.nextInt();
        System.out.println("[도서 판매] 판매 도서 번호 입력");
        int book_id = sc.nextInt();

        ODto oDto = oDao.getBookPrice(cust_id, book_id);

        if(oDto ==null) throw new Exception("존재하지 않는 도서, 혹은 고객번호를 입력 하셨습니다.");

        printPriceByCustomer(oDto);

        System.out.println("[도서 판매] 구매? 승인 Y / 취소 as AnyKEY");
        String InputBuyCheck = sc.next();

        if(InputBuyCheck.equals("Y")||InputBuyCheck.equals("y")){
            saleByCheckPoint(cust_id, book_id, oDto);
        }else {
            System.out.println("[도서 판매] 구매가 취소되었습니다.");
            return;
        }
    }

    private void printPriceByCustomer(ODto oDto){

        System.out.println(oDto.get_name()
                +"님의 포인트는 "
                +oDto.get_point()
                +"Point 이며 "
                +oDto.get_bookid()
                +"번 "
                +oDto.get_bookname()
                +"의 가격은 "
                +oDto.get_price()
                +"원 입니다."  );
        System.out.println("포인트 차감시 "
                + (oDto.get_price() - oDto.get_point())
                +"원으로 구매 가능합니다.");
    }

    private void saleByCheckPoint (int cust_id, int book_id, ODto oDto){
        System.out.println("[도서 판매] 구매 Y - 포인트사용?  승인 Y 사용하지 않음 N 취소 as AnyKEY");
        String InputUsePoint = sc.next();
        try{
            if(InputUsePoint.equals("Y")||InputUsePoint.equals("y")){
                oDao.sale(cust_id,book_id,oDto.get_price()-oDto.get_point());
            }
            else if(InputUsePoint.equals("N")||InputUsePoint.equals("n")){
                oDao.sale(cust_id,book_id,oDto.get_price());
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return;
    }
}
