import { CommonModule } from "@angular/common";
import { Component, inject, OnInit } from "@angular/core";
import { CartService } from "app/cart/cart.service";
import { Product } from "app/products/data-access/product.model";
import { ProductsService } from "app/products/data-access/products.service";
import { BadgeModule } from "primeng/badge";
import { ButtonModule } from "primeng/button";
import { CardModule } from "primeng/card";
import { DataViewModule } from "primeng/dataview";
import { DialogModule } from "primeng/dialog";
import { Subscription } from "rxjs";

@Component({
    selector: "app-cart-list",
    templateUrl: "./cart-list.component.html",
    styleUrls: ["./cart-list.component.scss"],
    standalone: true,
    imports: [DataViewModule, CardModule, ButtonModule, CommonModule, BadgeModule],
  })
export class CartListComponent implements OnInit{
   
    private readonly productsService = inject(ProductsService);
    private readonly cartService = inject(CartService);

    public cartSubscription = this.cartService.cart$;
    public products: Product[] = [];

    ngOnInit(): void {
        this.cartSubscription.subscribe(cart => {
            this.products = [];
            Object.entries(cart).forEach(value => {
                console.log(value);
                
                var test = this.productsService.getById(value[0]).subscribe(data => {
                    data.quantity = value[1];
                    this.products.push(data);
                });
                
            });
        });   
    }

    public onRemove(product: Product) {
        this.cartService.removeFromCart(product)
    }

    onImageError(event: Event) {
        const target = event.target as HTMLImageElement;
        target.src = 'https://img-cdn.pixlr.com/image-generator/history/65bb506dcb310754719cf81f/ede935de-1138-4f66-8ed7-44bd16efc709/medium.webp';
    }
}