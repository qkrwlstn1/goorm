package shopping;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ProductSet ps = new ProductSet();
        Cart cart = new Cart();
        Kiosk kiosk = new Kiosk();
        String[] input;
        do {

            System.out.println("상품 추가 : addProduct 상품이름 가격\n" +
                    "상품 삭제 : deleteProduct 상품이름\n" +
                    "상품 목록 : showProduct\n" +
                    "카트 추가 : addCart 상품이름 수량\n" +
                    "카트 삭제 : deleteCart 상품이름 수량\n" +
                    "카트 목록 : showCart\n" +
                    "종료 : exit");
            input = br.readLine().split(" ");
            kiosk.order(input);
        }while (!input[0].equals("exit"));




    }
}
