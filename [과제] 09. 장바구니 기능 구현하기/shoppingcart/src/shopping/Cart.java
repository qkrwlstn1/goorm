package shopping;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Cart {
    private Map<String , Integer> map = new HashMap<>();

    // 생성자: cart.csv 파일에서 상품 목록을 불러옵니다.
    public Cart() {
        try (BufferedReader br = new BufferedReader(new FileReader("cart.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String productName = values[0].trim();
                int quantity = Integer.parseInt(values[1].trim());
                map.put(productName, quantity);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // 상품 추가: 새 상품이면 추가, 이미 있으면 수량을 증가시킵니다.
    public boolean add(String name, int count) {
        map.put(name, map.getOrDefault(name, 0) + count);
        writeCartTOCSV();
        return true;
    }

    // cart.csv 파일에 현재 카트 상태를 저장합니다.
    private void writeCartTOCSV(){
        try (FileWriter fw = new FileWriter("cart.csv",false);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)
        ){
            Set<String> keys = map.keySet();
            for(String a : keys){
                out.println(a +","+map.get(a));
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    // 카트에 담긴 모든 상품을 출력합니다.
    public void showItems(){
        System.out.println("--------------cart--------------");
        for(String key : map.keySet()){
            System.out.println(key +":" +map.get(key));
        }
    }


    // 상품 삭제: 수량을 감소시키고, 수량이 0 이하면 제거합니다.
    public boolean delete(String name,int count){
        if(!map.containsKey(name)) return false;// 상품이 카트에 없는 경우

        map.put(name, map.get(name)-count);
        if(map.get(name) <1){
            map.remove(name);
        }

        writeCartTOCSV();


        return true;
    }

}
