package com.android.example.mimercado;

public class ProductData {


        private String ProductName;
        private String ProductDescription;
        private int ProductImage;

        public ProductData(String ProductName, String ProductDescription, int ProductImage) {
            this.ProductName = ProductName;
            this.ProductDescription = ProductDescription;
            this.ProductImage = ProductImage;
        }

        public String getProductName() {
            return ProductName;
        }

        public String getProductDescription() {
            return ProductDescription;
        }

        public int getProductImage() {
            return ProductImage;
        }
}
