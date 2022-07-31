package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_shop_item_image")
public class ShopItemImage extends AbstractEntity {

    @Column(length = 255)
    private String image;
    private String description;
    @Column(nullable = false)
    private int listOrder;
    @ManyToOne
    @JoinColumn(name = "shop_item_id", nullable = false)
    private ShopItem shopItem;

    public ShopItemImage() {
    }

    public ShopItem getShopItem() {
        return this.shopItem;
    }

    public void setShopItem(ShopItem shopItem) {
        this.shopItem = shopItem;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getListOrder() {
        return this.listOrder;
    }

    public void setListOrder(int listOrder) {
        this.listOrder = listOrder;
    }

}
