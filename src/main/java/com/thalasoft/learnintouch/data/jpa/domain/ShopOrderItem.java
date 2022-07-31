package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_shop_order_item")
public class ShopOrderItem extends AbstractEntity {

    @Column(length = 50)
    private String name;
    private String shortDescription;
    @Column(length = 30)
    private String reference;
    @Column(nullable = false)
    private String price;
    @Column(length = 5)
    private String vatRate;
    private String shippingFee;
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private boolean isGift;
    private String options;
    private String imageUrl;
    @ManyToOne
    @JoinColumn(name = "shop_item_id")
    private ShopItem shopItem;
    @ManyToOne
    @JoinColumn(name = "shop_order_id", nullable = false)
    private ShopOrder shopOrder;

    public ShopOrderItem() {
    }

    public ShopItem getShopItem() {
        return this.shopItem;
    }

    public void setShopItem(ShopItem shopItem) {
        this.shopItem = shopItem;
    }

    public ShopOrder getShopOrder() {
        return this.shopOrder;
    }

    public void setShopOrder(ShopOrder shopOrder) {
        this.shopOrder = shopOrder;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return this.shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getReference() {
        return this.reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getVatRate() {
        return vatRate;
    }

    public void setVatRate(String vatRate) {
        this.vatRate = vatRate;
    }

    public String getShippingFee() {
        return this.shippingFee;
    }

    public void setShippingFee(String shippingFee) {
        this.shippingFee = shippingFee;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean getIsGift() {
        return this.isGift;
    }

    public void setIsGift(boolean isGift) {
        this.isGift = isGift;
    }

    public String getOptions() {
        return this.options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
