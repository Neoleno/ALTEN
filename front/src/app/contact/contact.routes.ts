import { Routes } from "@angular/router";
import { ContactListComponent } from "./features/contact-form/contact-form.component";

export const CONTACT_ROUTES: Routes = [
	{ path: "**", component: ContactListComponent },
];
