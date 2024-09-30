import {
  Component,
  inject,
  OnDestroy,
  OnInit
} from "@angular/core";
import { Router, RouterModule } from "@angular/router";
import { SplitterModule } from 'primeng/splitter';
import { ToolbarModule } from 'primeng/toolbar';
import { PanelMenuComponent } from "./shared/ui/panel-menu/panel-menu.component";
import { BadgeModule } from 'primeng/badge';
import { CartService } from "./cart/cart.service";
import { Subscription } from "rxjs";
import { CartListComponent } from "./cart/features/cart-list/cart-list.component";
import { DialogModule } from "primeng/dialog";


@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.scss"],
  standalone: true,
  imports: [RouterModule, SplitterModule, ToolbarModule, PanelMenuComponent, BadgeModule, CartListComponent, DialogModule],
})
export class AppComponent implements OnInit, OnDestroy {
  isDialogVisible = true;
  private readonly cartService = inject(CartService);
  total = 0;
  cartSubscription!: Subscription;
  title = "ALTEN SHOP";
  router: Router = new Router;

  ngOnInit() {
    this.cartSubscription = this.cartService.cart$.subscribe(cart => {
        this.total = this.cartService.countProductsInCart();
    });
  }

  ngOnDestroy(): void {
    if (this.cartSubscription) {
      this.cartSubscription.unsubscribe();
    }
  }

  public onCancel() {
    this.isDialogVisible = false;
  }

  public onClick() {
    this.isDialogVisible = true;
  }
}
