package shopping;

import java.io.*;
import java.util.HashSet;

public class ProductSet {

    HashSet<Product> items = new HashSet<>();

    // 생성자: CSV 파일로부터 상품 목록을 불러와 초기화합니다.
    public ProductSet() {
        loadProductsFromCSV();
    }
    // CSV 파일에서 상품 목록을 불러오는 메소드
    private void loadProductsFromCSV() {
        try (BufferedReader br = new BufferedReader(new FileReader("products.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String productName = values[0].trim();
                int quantity = Integer.parseInt(values[1].trim());
                items.add(new Product(productName, quantity));
            }
        } catch (FileNotFoundException e) {
            System.out.println("products.csv 파일을 찾을 수 없습니다.");
        } catch (IOException e) {
            System.out.println("파일 읽기 중 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }

    // 상품 목록을 콘솔에 출력하는 메소드
    public void showItems() {
        System.out.println("--------------product--------------");
        for (Product item : items) {
            System.out.println(item.getName() + " : " + item.getPrice());
        }
    }

    // 상품을 추가하는 메소드
    public boolean addProduct(Product product) throws IOException {
        for(Product pro : items){
            if(pro.equals(product)) return false;
        }
        items.add(product);
        writeProductsToCSV();
        return true;
    }
    // 상품을 삭제하는 메소드
    public boolean deleteProduct(String name) throws IOException {
        boolean success = false;
        for(Product pro : items){
            if(pro.getName().equals(name)){
                items.remove(pro);
                success = true;
                break;
            }
        }
        if(success) {
            writeProductsToCSV();
        }
        return success;
    }


    // 특정 상품이 존재하는지 검사하는 메소드

    public boolean containsProduct(String name){
        for(Product product : items){
            if(name.equals(product.getName())){
                return true;
            }
        }

        return false;
    }

    // CSV 파일에 상품 목록을 저장하는 메소드
    private void writeProductsToCSV() {
        try (FileWriter fw = new FileWriter("products.csv", false);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            for (Product product : items) {
                out.println(product.getName() + "," + product.getPrice());
            }
        } catch (IOException e) {
            System.out.println("CSV 파일 쓰기 중 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }


}
