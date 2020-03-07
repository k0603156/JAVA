package com.example.command;

import com.example.dao.ODao;
import com.example.dto.ODto;

import java.util.List;

public class OListCommand implements ICommand{
    ODao oDao;
    public OListCommand(ODao oDao){
        this.oDao=oDao;
    }
    @Override
    public void execute(){
        System.out.println("[도서 판매 기록]");
        List<ODto> oDtoL = oDao.list();
        printSaleRecord(oDtoL);
    }
    private void printSaleRecord(List<ODto> oDtoL){
        oDtoL.forEach(oDto -> {
            System.out.println("["+oDto.get_orderid()
                    +"]"
                    +oDto.get_custid()
                    +"번 "
                    +oDto.get_name()
                    +"님 "
                    +oDto.get_bookid()
                    +"번 도서 "
                    +oDto.get_saleprice()
                    +"원에 판매 | "
                    +oDto.get_orderdate()+" |");
        });
    }
}
