package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_shop_discount")
public class ShopDiscount extends AbstractEntity {

    @Column(nullable = false, length = 12)
    private String discountCode;
    @Column(nullable = false, length = 5)
    private String discountRate;
    @ManyToOne
    @JoinColumn(name = "shop_affiliate_id", nullable = false)
    private ShopAffiliate shopAffiliate;

    public ShopDiscount() {
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public String getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(String discountRate) {
        this.discountRate = discountRate;
    }

    public ShopAffiliate getShopAffiliate() {
        return shopAffiliate;
    }

    public void setShopAffiliate(ShopAffiliate shopAffiliate) {
        this.shopAffiliate = shopAffiliate;
    }

}
