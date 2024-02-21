package shopping;

import java.io.IOException;

public class Kiosk {
    private ProductSet productSet;
    private Cart cart;
    public Kiosk() {
        productSet = new ProductSet();
        cart = new Cart();
    }

    public void order(String[] order) throws IOException {
        switch (order[0]){
            case "addProduct" :
                addProduct(order);
                break;
            case "deleteProduct" :
                deleteProduct(order);
                break;
            case "showProduct" :
                productSet.showItems();
                break;
            case "addCart" :
                addCart(order);
                break;
            case "deleteCart" :
                deleteCart(order);
                break;
            case "showCart" :
                cart.showItems();
                break;
            default:
                System.out.println("없는 명령어 입니다. 다시 작성해 주세요.");




        }

    }


    //상품 추가
    private void addProduct(String[] order)throws IOException{
        if(order.length != 3){
            System.out.println("잘못된 입력 입니다.");
            return;
        }else if(productSet.addProduct(new Product(order[1], Integer.parseInt(order[2])))) System.out.println("성공!");
        else{
            System.out.println("상품이 이미 존재합니다");
        }
        productSet.showItems();
    }

    private void deleteProduct(String[] order) throws IOException {
        if(order.length !=2){
            System.out.println("잘못된 입력입니다.");
            return;
        }
        if(productSet.deleteProduct(order[1])){
            System.out.println("상품 삭제 성공!");
        }else System.out.println("상품 삭제 실패!");

        productSet.showItems();
    }

    private void addCart(String[] order) throws IOException{
        if(order.length !=3 || !productSet.containsProduct(order[1])){
            System.out.println("잘못된 입력입니다. 상품이 존재하기 않거나, 올바른 형식이 아닙니다.");
            return;
        }
        cart.add(order[1], Integer.parseInt(order[2]));
        cart.showItems();
    }
    private void deleteCart(String[] order) throws IOException{
        if(order.length != 3){
            System.out.println("잘못된 입력입니다");
            return;
        }
        if(cart.delete(order[1], Integer.parseInt(order[2]))){
            System.out.println("카트에서 상품 빼기 성공!");
        }else{
            System.out.println("카트에서 상품 빼기 실패!");
        }
        cart.showItems();
    }


}
