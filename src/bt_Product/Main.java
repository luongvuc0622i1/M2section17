package bt_Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main implements Serializable {
    public static List<Product> readFile(String path) throws IOException, ClassNotFoundException {
        List<Product> products = new ArrayList<>();

        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);
        products = (List<Product>) ois.readObject();
        ois.close();
        fis.close();

        return products;
    }

    public static void writeFile(String path, List<Product> products) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(products);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
//        List<Product> products = new ArrayList<>();
//        products.add(new Product(01, "asa", "US", 20));
//        products.add(new Product(02, "asa", "US", 20));
//        products.add(new Product(03, "asa", "US", 30));
//        products.add(new Product(04, "asa", "US", 20));
//        products.add(new Product(05, "asa", "US", 20));
//        writeFile("product.txt", products);
//
//        List<Product> productDataFromFile = null;
//        try {
//            productDataFromFile = readFile("product.txt");
//            for (Product product : productDataFromFile) {
//                System.out.println(product);
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }

        System.out.println("Sau khi sửa 30 thành 10");
        List<Product> products = null;
        try {
            products = readFile("product.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        for (Product product : products) {
            if (product.getPrice() == 30) {
                product.setPrice(10);
            }
        }
        writeFile("product.txt", products);

        List<Product> productDataFromFile = null;
        try {
            productDataFromFile = readFile("product.txt");
            for (Product product : productDataFromFile) {
                System.out.println(product);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
