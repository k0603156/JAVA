package com.example.management;

import com.example.dao.CDao;
import com.example.dto.CDto;

import java.util.List;

public class ManagementCustomer extends Management  {
    CDao cDao = new CDao(DBm);
    public void Run(){

        while(true){
            System.out.println("[고객관리] 실행하실 명령 번호를 입력하세요.");
            System.out.println("[1] 고객 정보 리스트");
            System.out.println("[2] 고객 정보   생성");
            System.out.println("[3] 고객 정보   수정");
            System.out.println("[4] 고객 포인트 관리");
            System.out.println("[0] 뒤로");
            int sub_action = sc.nextInt();
            switch (sub_action) {
                case 1:
                    List<CDto> cdtoL = cDao.list();
                    printCustomerList(cdtoL);
                    break;
                case 2:
                    System.out.println("[고객 정보 추가] 고객 이름 입력");
                    String name = sc.next();
                    System.out.println("[고객 정보 추가] 고객 주소 입력");
                    String address = sc.next();
                    System.out.println("[고객 정보 추가] 고객 핸드폰 번호 입력");
                    String phone = sc.next();

                    cDao.add(new CDto(name, address, phone));
                    break;
                case 3:

                    System.out.println("[고객 정보 수정] 고객 번호 입력");
                    int custId = sc.nextInt();
                    System.out.println("[고객 정보 수정] 고객 주소 입력");
                    String address2 = sc.next();
                    System.out.println("[고객 정보 수정] 고객 핸드폰 번호 입력");
                    String phone2 = sc.next();

                    cDao.update(new CDto(custId, address2, phone2));
                    break;
                case 4:
                    System.out.println("[고객 포인트 관리] 고객 포인트 관리");
                    break;
                case 0:
                    return;
            }
        }
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


