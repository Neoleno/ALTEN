import { Injectable, inject, signal } from "@angular/core";
import { Product } from "../products/data-access/product.model";
import { BehaviorSubject } from "rxjs";

@Injectable({
    providedIn: "root"
}) export class CartService{
    private cartSubject = new BehaviorSubject<{ [productId: number]: number }>({});
    cart$ = this.cartSubject.asObservable();

    public addToCart(product: Product) {
        const currentCart = { ...this.cartSubject.getValue() };
        if (currentCart[product.id]) {
            currentCart[product.id] += 1;
        } else {
            currentCart[product.id] = 1;
        }

        this.cartSubject.next(currentCart);
    }

    public removeFromCart(product: Product) {
        const currentCart = { ...this.cartSubject.getValue() };
        if (currentCart[product.id]) {
            delete currentCart[product.id];
        }

        this.cartSubject.next(currentCart);
    }

    public countProductsInCart(){
        const currentCart = { ...this.cartSubject.getValue() };
        var result = 0;

        Object.values(currentCart).forEach(quantity => result += quantity);        
        return result;
    }
}