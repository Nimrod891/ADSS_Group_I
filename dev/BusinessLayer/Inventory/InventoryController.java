package BusinessLayer.Inventory;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class InventoryController {
    List<Product> products;
    List<Category> categories;

    public InventoryController () {
        this.products = new LinkedList<>();
        this.categories = new LinkedList<>();
        Category subCategory1 = new Category("Low-fat", new LinkedList<>());
        Category subCategory2 = new Category("Milk", new LinkedList<>());
        Category subCategory3 = new Category("Dairy-free", new LinkedList<>());
        Category mainCategory = new Category("Dairy", new LinkedList<>());
        mainCategory.addSub(subCategory1);
        mainCategory.addSub(subCategory2);
        mainCategory.addSub(subCategory3);
        Product p = new Product("milk",mainCategory,"Maabarot",2.90,4.10,20);
        Product p1 = new Product("milk low fat",subCategory2,"Maabarot",2.90,4.10,20);
        categories.add(subCategory1);
        categories.add(subCategory2);
        categories.add(subCategory3);
        categories.add(mainCategory);
        products.add(p);
        products.add(p1);

    }
    public Category addCategory(String name, List<String> subCatName){
        List<Category> mySub = new LinkedList<>();
        for(String s : subCatName){
            Category subC = new Category(s,new LinkedList<>());
            mySub.add(subC);
            categories.add(subC);
        }
        Category cat = new Category(name,mySub);
        if(!categories.contains(cat))
            categories.add(cat);
        return cat;
    }
    public Product getProduct (String name) {
        for (Product p : products) {
            if (p.getName().equals(name))
                return p;
        }
        return null;
    }

    public Category getCategory (String name){
        for (Category c : categories){
            if (c.getName().equals(name))
                return c;
        }
        return null;
    }

    public void addProduct (String name,Category category, String manufacture, double priceFromSupplier, double priceToCustomer, int minimum) {
        Product p = new Product(name,category,manufacture,priceFromSupplier,priceToCustomer,minimum);
        if (!products.contains(p))
            products.add(p);
    }

//    public void addCategory (String name, List<Category> subCategories) {
//        Category c = new Category(name,subCategories);
//        if (!categories.contains(c))
//            categories.add(c);
//    }
    public void setManufacture(String name, String manu){
        Product p = getProduct(name);
        p.setManufacture(manu);
    }

    public void setPriceFromSupplier(String name,double priceFromSupplier) {
        Product p = getProduct(name);
        p.setPriceFromSupplier(priceFromSupplier);
    }

    public void setPriceToCustomer(String name , double priceToCustomer) {
        Product p = getProduct(name);
        p.setPriceToCustomer(priceToCustomer);
    }

    public void setProdDiscount(String name,int discount, Date discountDate) {
        Product p = getProduct(name);
        p.setDiscount(discount,discountDate);
    }
    public void setDefectiveItems (String name, int def){
        Product p = getProduct(name);
        p.setDefectiveItem(def);
    }
    public void setMinimum(String name , int minimum) {
        Product p = getProduct(name);
        p.setMinimum(minimum);
    }

    public void addStoreQuantity(String name, int add){
        Product p = getProduct(name);
        p.addStoreQuantity(add);
    }

    public void reduceStoreQuantity(String name, int reduce){
        Product p = getProduct(name);
        p.reduceStoreQuantity(reduce);
    }

    public void addStorageQuantity(String name, int add){
        Product p = getProduct(name);
        p.addStorageQuantity(add);
    }

    public boolean reduceStorageQuantity(String name, int reduce){
        Product p = getProduct(name);
        return p.reduceStorageQuantity(reduce);
    }

    public void setStoreQuantity(String name, int storeQuantity){
        Product p = getProduct(name);
        p.setStoreQuantity(storeQuantity);
    }

    public boolean setStorageQuantity(String name, int storageQuantity){
        Product p = getProduct(name);
       return p.setStorageQuantity(storageQuantity);
    }

    public String printProduct(String name){
        Product p = getProduct(name);
        return p.printProduct();

    }
    public void addSub(String name,Category c){
        Category cat = getCategory(name);
        cat.addSub(c);
    }
    public void deleteSubCat(String name, Category subC){
        Category cat = getCategory(name);
        cat.deleteSubCat(subC);
    }
    public void deleteProd(String name ,Product p){
        Category cat = getCategory(name);
        cat.deleteProd(p);
    }
    public void setCatDiscount(String name, int discount,Date discountDate){
        Category cat = getCategory(name);
        cat.setDiscount(discount,discountDate);
    }
    public void setCatDiscountDate(String name, Date discountDate){
        Category cat = getCategory(name);
        cat.setDiscountDate(discountDate);
    }
    public String printCategory(String name){
        Category cat = getCategory(name);
        return cat.printCategory();
    }
    public String displayPFSHistory(String prodName){
        Product p = getProduct(prodName);
       return p.displayPriceFromSupHistory();
    }
    public String displayPTCHistory(String prodName){
        Product p = getProduct(prodName);
        return p.displayPriceToCusHistory();
    }

}