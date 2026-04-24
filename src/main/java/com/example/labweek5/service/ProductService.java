package com.example.labweek5.service;

import com.example.labweek5.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> productList = new ArrayList<>();

    public Product addNewProduct(Product product){
        productList.add(product);
        return product;
    }

    public List<Product> getAllProducts(){
        return productList;
    }

    public Product getProductByName(String name) {
        for (Product product : productList) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    public Product updateProduct (String name, Product updatedProduct){
        for (Product product : productList ){
            if (product.getName().equalsIgnoreCase(name)){
                product.setPrice(updatedProduct.getPrice());
                product.setCategory(updatedProduct.getCategory());
                product.setQuantity(updatedProduct.getQuantity());
                product.setName(updatedProduct.getName());
                return product;
            }
        }
        return null;
    }

    public void deleteProduct(String name){
        productList.remove(name);
    }

    public List<Product> getProductByCategory(String requestedCategory){
        List<Product> foundProduct = new ArrayList<>();
        for (Product product : productList){
            if (product.getCategory().equalsIgnoreCase(requestedCategory)){
                foundProduct.add(product);
            }
        }
        return foundProduct;
    }

    public List<Product> getProductsByPriceRange(long minPrice, long maxPrice){
        List<Product> resultList=new ArrayList<>();
        for(Product product: productList){
            if(product.getPrice()>=minPrice && product.getPrice()<=maxPrice){
                resultList.add(product);
            }
        }
        return resultList;
    }

}
