package com.example.command;

import com.example.dao.CDao;
import com.example.dto.CDto;

import java.util.List;

public class CListCommand implements ICommand{
    CDao cDao;
    public CListCommand(CDao cDao){
        this.cDao=cDao;
    }
    @Override
    public void execute(){
        List<CDto> cdtoL = cDao.list();
        printCustomerList(cdtoL);
    }

    private void printCustomerList(List<CDto> cdtoL){
        cdtoL.forEach(cdto->{
            System.out.println(
                    String.format("%-4s",     cdto.get_custid())
                            + String.format("%-20s",    cdto.get_name())
                            + String.format("%-15s",    cdto.get_address())
                            + String.format("%-10s",    cdto.get_phone())
                            + String.format("%4s",      cdto.get_point()) );
        });
    }
}
