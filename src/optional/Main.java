package optional;

import bt_Product.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Product> readFile(String path) {
        List<Product> products = new ArrayList<>();

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            products = (List<Product>) ois.readObject();
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    private static void copyFile(String path, List<Product> products) throws IOException {
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(products);
        oos.close();
        fos.close();
    }

    public static void main(String[] args) {
        try {
            copyFile("copyProduct.txt", readFile("product.txt"));
            System.out.printf("Copy completed");
        } catch (IOException ioe) {
            System.out.printf("Can't copy that file");
            System.out.printf(ioe.getMessage());
        }
    }
}
