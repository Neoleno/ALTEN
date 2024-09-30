import { Component, inject } from "@angular/core";
import { FormsModule } from "@angular/forms";
import { MessageService } from "primeng/api";
import { ButtonModule } from "primeng/button";
import { InputTextModule } from "primeng/inputtext";
import { InputTextareaModule } from "primeng/inputtextarea";
import { ToastModule } from 'primeng/toast';


@Component({
    selector: "app-cart-list",
    template: `
        <p-toast />
        <form #form="ngForm" (ngSubmit)="onSubmit()">
            <div class="form-field">
                <label for="email">Email</label>
                <input pInputText
                    type="email"
                    id="email"
                    name="email"
                    [(ngModel)]="email"
                    email
                    required>
            </div>
            <div class="form-field">
                <label for="message">Message</label>
                <textarea  pInputTextarea
                    id="message"
                    name="message"
                    rows="5" 
                    cols="30"
                    maxlength="300"
                    [(ngModel)]="message"
                    required></textarea>
            </div>
            <div class="flex justify-content-between">
                <p-button type="submit" [disabled]="!form.valid" label="Enregistrer" severity="success"/>
            </div>
        </form>
        `,
    styleUrls: ["./contact-form.component.scss"],
    standalone: true,
    imports: [FormsModule, ButtonModule, InputTextModule, InputTextareaModule, ToastModule],
  })
export class ContactListComponent{
    private readonly messageService = inject(MessageService);
    email = "";
    message = "";

    public onSubmit() {
        this.messageService.add({ severity: 'success', summary: 'Success', detail: 'Demande de contact envoyée avec succès' });
    }
}