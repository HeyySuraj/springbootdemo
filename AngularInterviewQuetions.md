
# Data Binding in Angular – Complete Guide with Clear Examples

## What is Data Binding?

**Data binding** in Angular is the process of connecting the **component (TypeScript logic)** with the **view (HTML template)** so data can flow between them automatically.

> In simple terms: **data binding keeps your UI and data in sync.**

---

## Why Data Binding is Important?

Without data binding:
- You would manually manipulate the DOM
- Write more boilerplate JavaScript
- Handle UI updates yourself

With Angular data binding:
- UI updates automatically
- Code becomes cleaner and readable
- Application becomes reactive

---

## Types of Data Binding in Angular

Angular provides **4 types of data binding**:

1. Interpolation  
2. Property Binding  
3. Event Binding  
4. Two-Way Binding  

---

## 1️⃣ Interpolation (`{{ }}`)

### What it does
- Displays data from **component → view**
- One-way data binding

### Syntax
```html
{{ expression }}
````

### Example

**Component**

```ts
export class AppComponent {
  username = 'Suraj';
}
```

**Template**

```html
<p>Hello {{ username }}</p>
```

### Output

```
Hello Suraj
```

### Notes

* Only expressions allowed
* No loops, conditions, or assignments

---

## 2️⃣ Property Binding (`[property]`)

### What it does

* Binds a component value to an **HTML element property**
* One-way: **component → view**

### Syntax

```html
[property]="expression"
```

### Example

**Component**

```ts
export class AppComponent {
  isDisabled = true;
}
```

**Template**

```html
<button [disabled]="isDisabled">Submit</button>
```

### Result

* Button is disabled

### Important Difference

```html
disabled="false"   ❌ (still disabled)
[disabled]="false" ✅ (enabled)
```

---

## 3️⃣ Event Binding (`(event)`)

### What it does

* Sends data from **view → component**
* Used to handle user actions (click, input, submit, etc.)

### Syntax

```html
(event)="method()"
```

### Example

**Component**

```ts
export class AppComponent {
  count = 0;

  increment() {
    this.count++;
  }
}
```

**Template**

```html
<button (click)="increment()">+</button>
<p>Count: {{ count }}</p>
```

### Flow

```
User Action → Event → Component Logic → UI Update
```

---

## 4️⃣ Two-Way Data Binding (`[(ngModel)]`)

### What it does

* Syncs data **both ways**
* Combines property binding + event binding

### Syntax

```html
[(ngModel)]="property"
```

### Example

**Component**

```ts
export class AppComponent {
  name = '';
}
```

**Template**

```html
<input [(ngModel)]="name">
<p>Hello {{ name }}</p>
```

### Behavior

* Typing in input updates `name`
* Updating `name` updates the input

---

## How Two-Way Binding Works Internally

```html
[(ngModel)]="name"
```

Is equivalent to:

```html
[ngModel]="name"
(ngModelChange)="name = $event"
```

---

## Required Module for ngModel

```ts
import { FormsModule } from '@angular/forms';

@NgModule({
  imports: [FormsModule]
})
export class AppModule {}
```

---

## Summary Table

| Binding Type     | Syntax        | Direction        |
| ---------------- | ------------- | ---------------- |
| Interpolation    | `{{ value }}` | Component → View |
| Property Binding | `[property]`  | Component → View |
| Event Binding    | `(event)`     | View → Component |
| Two-Way Binding  | `[(ngModel)]` | Both             |

---

## Real-World Example (Login Form)

```html
<input [(ngModel)]="email" placeholder="Email">
<input [(ngModel)]="password" type="password">
<button (click)="login()">Login</button>
```

```ts
login() {
  console.log(this.email, this.password);
}
```

---

## Common Mistakes ❌

* Forgetting to import `FormsModule`
* Mixing `ngModel` with Reactive Forms
* Using interpolation for HTML properties

---

## Interview Tip 🔥

Angular follows **unidirectional data flow**.
Two-way binding is just a **combination of two one-way bindings**.

---

## One-Line Summary

> **Data binding in Angular connects the component and the view using interpolation, property binding, event binding, and two-way binding.**

```
Great catch 👀 — you’re **100% right**, and this confusion happens a lot in Angular learning.

### Short answer first

👉 **Attribute binding and class/style binding are NOT separate data-binding types.**
They are **special cases of *property binding***.

That’s why they’re often *not listed separately* when people say “4 types of data binding”.

Now let’s make this **crystal clear** 👇

---

## The 4 REAL data-binding directions (Angular core concept)

Angular officially categorizes data binding by **direction of data flow**, not by syntax.

1. **Interpolation** → Component ➜ View
2. **Property Binding** → Component ➜ View
3. **Event Binding** → View ➜ Component
4. **Two-Way Binding** → Both directions

👉 **Attribute, class, and style bindings all fall under #2 (Property Binding)**

---

## Why Attribute Binding exists

Some HTML attributes **do not have DOM properties**.

Example:

* `colspan`
* `aria-label`
* `role`
* `data-*`

This ❌ does NOT work:

```html
<td [colspan]="2"></td>
```

Because `colspan` is **not a DOM property**.

### So Angular gives us **attribute binding**

```html
<td [attr.colspan]="2"></td>
```

✔ Now Angular sets the HTML attribute directly.

---

## Attribute Binding Example

```html
<button [attr.aria-label]="label">
  Save
</button>
```

```ts
label = 'Save button';
```

---

## Class Binding (still property binding)

Classes are part of the element’s **`class` property**.

### Single class

```html
<div [class.active]="isActive"></div>
```

### Multiple classes

```html
<div [class]="className"></div>
```

```ts
className = 'card highlighted';
```

### Using `ngClass`

```html
<div [ngClass]="{ active: isActive, disabled: isDisabled }"></div>
```

---

## Style Binding (also property binding)

Styles are part of the element’s **`style` property**.

### Single style

```html
<div [style.color]="color"></div>
```

### With units

```html
<div [style.width.px]="200"></div>
```

### Using `ngStyle`

```html
<div [ngStyle]="{ color: color, fontSize: size + 'px' }"></div>
```

---

## Correct Mental Model (VERY IMPORTANT 🔥)

```
DATA BINDING (4)
│
├── Interpolation
├── Property Binding
│     ├── Property
│     ├── Attribute
│     ├── Class
│     └── Style
├── Event Binding
└── Two-Way Binding
```

---

## Why most tutorials “miss” them

Because:

* Interviewers expect **4 types**
* Attribute/Class/Style are **syntax variations**
* Conceptually they’re still **one-way: component ➜ view**

---

## Interview-ready answer ✅

> Angular has four types of data binding: interpolation, property binding, event binding, and two-way binding.
> Attribute, class, and style bindings are specialized forms of **property binding**, used when normal property binding is not sufficient.

---



# What is a service in Angular?

An **Angular service** is a **class used to hold reusable business logic or shared data** that can be used across multiple components.

In simple words:

> **A service is where you put logic that does NOT belong to the UI.**

---

## Why do we need services?

Components should mainly:

* Handle UI
* Handle user interaction
* Display data

Services are used to:

* Fetch data from APIs
* Share data between components
* Write business logic
* Handle authentication, logging, caching, etc.

This follows **Separation of Concerns** 👍

---

## Basic Example of a Service

### Create a service

```bash
ng generate service user
```

---

### Service file (`user.service.ts`)

```ts
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  getUser() {
    return { name: 'Suraj', role: 'Developer' };
  }
}
```

---

### Use service in a component

```ts
import { Component } from '@angular/core';
import { UserService } from './user.service';

@Component({
  selector: 'app-profile',
  template: `<p>{{ user.name }}</p>`
})
export class ProfileComponent {
  user: any;

  constructor(private userService: UserService) {
    this.user = this.userService.getUser();
  }
}
```

---

## What does `@Injectable()` do?

`@Injectable()` tells Angular:

* This class can be **injected** into other classes
* Angular can manage its **dependencies**

```ts
@Injectable({ providedIn: 'root' })
```

Means:

* One **singleton instance**
* Available application-wide

---

## Dependency Injection (DI)

Angular uses **Dependency Injection** to provide services.

```ts
constructor(private userService: UserService) {}
```

Angular:

* Creates the service instance
* Injects it into the component
* Reuses it where needed

---

## Common Use Cases of Services

* API calls (`HttpClient`)
* Authentication & authorization
* State management
* Utility/helper functions
* Shared data between components

---

## Service vs Component

| Component                   | Service              |
| --------------------------- | -------------------- |
| UI logic                    | Business logic       |
| Has HTML & CSS              | No UI                |
| Created/destroyed with view | Usually singleton    |
| Handles user events         | Handles data & logic |

---

## Real-world Example

```ts
login(username: string, password: string) {
  return this.http.post('/login', { username, password });
}
```

This logic belongs in a **service**, not a component.

---

## One-line summary (Interview-ready)

> **A service in Angular is a reusable class used to encapsulate business logic or shared data and is injected into components using dependency injection.**


# What is dependency injection in Angular?

**Dependency Injection (DI)** in Angular is a **design pattern** where a class does **not create its own dependencies**.
Instead, Angular **creates and provides** those dependencies from the outside.

In simple terms:

> **Angular gives a class what it needs, instead of the class creating it itself.**

---

## Why Dependency Injection is needed

Without DI ❌:

```ts
export class ProfileComponent {
  userService = new UserService(); // tightly coupled ❌
}
```

Problems:

* Hard to test
* Hard to replace logic
* Tight coupling

With DI ✅:

```ts
constructor(private userService: UserService) {}
```

Angular:

* Creates `UserService`
* Manages its lifecycle
* Injects it automatically

---

## How Dependency Injection works in Angular

Angular DI has **3 main steps**:

1. **Provider** – tells Angular *how to create* a dependency
2. **Injector** – creates and stores instances
3. **Consumer** – class that needs the dependency

---

## Example: Dependency Injection in Action

### Service

```ts
@Injectable({
  providedIn: 'root'
})
export class UserService {
  getUser() {
    return 'Suraj';
  }
}
```

---

### Component (Consumer)

```ts
@Component({
  selector: 'app-profile',
  template: `<p>{{ name }}</p>`
})
export class ProfileComponent {
  name = '';

  constructor(private userService: UserService) {
    this.name = this.userService.getUser();
  }
}
```

Angular:

* Finds the provider
* Creates one instance
* Injects it into the constructor

---

## What is a Provider?

A **provider** tells Angular **how to create a dependency**.

### Common ways to provide a service

#### 1️⃣ `providedIn: 'root'` (Recommended)

```ts
@Injectable({ providedIn: 'root' })
```

* Singleton
* Tree-shakable
* App-wide

---

#### 2️⃣ Module-level provider

```ts
@NgModule({
  providers: [UserService]
})
```

---

#### 3️⃣ Component-level provider

```ts
@Component({
  providers: [UserService]
})
```

* New instance per component

---

## Injector Hierarchy (IMPORTANT 🔥)

Angular has a **hierarchical injector system**:

```
Root Injector
 └── Module Injector
      └── Component Injector
```

* Child injectors can override parents
* Closest provider wins

---

## Benefits of Dependency Injection

✅ Loose coupling
✅ Easier testing (mock services)
✅ Reusability
✅ Better architecture

---

## Dependency Injection vs Dependency Creation

| Without DI       | With DI             |
| ---------------- | ------------------- |
| `new Service()`  | Injected by Angular |
| Tight coupling   | Loose coupling      |
| Hard to test     | Easy to mock        |
| Manual lifecycle | Angular-managed     |

---

## Real-world Example (HttpClient)

```ts
constructor(private http: HttpClient) {}
```

You didn’t create `HttpClient` — Angular injected it.

---

## Interview One-liner 💡

> **Dependency Injection in Angular is a mechanism where Angular provides required dependencies to a class instead of the class creating them, improving modularity and testability.**



# What is a Router & Router service in Angular?

## What is a Router in Angular?

The **Angular Router** is a module that enables **navigation between different views (components)** in a **Single Page Application (SPA)** **without reloading the page**.

> It maps **URL paths → components**.

---

## What is the Router service?

The **`Router` service** is a class provided by Angular that allows you to **navigate programmatically** and **control routing behavior in code**.

---

## Simple Example

### Route configuration

```ts
const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'dashboard', component: DashboardComponent }
];
```

---

### Router outlet

```html
<router-outlet></router-outlet>
```

This is where routed components are displayed.

---

### Using Router service

```ts
constructor(private router: Router) {}

this.router.navigate(['/dashboard']);
```

---

## Key Responsibilities

### Router

* Matches URL to a route
* Loads the corresponding component
* Updates browser history
* Handles guards, lazy loading, redirects

### Router service

* Navigates using `navigate()` / `navigateByUrl()`
* Accesses current route state
* Handles navigation events

---

## Router vs RouterLink

| RouterLink                | Router service               |
| ------------------------- | ---------------------------- |
| Template-based navigation | Code-based navigation        |
| `<a routerLink="/home">`  | `router.navigate(['/home'])` |
| Used in HTML              | Used in TypeScript           |

---

## One-line Interview Summary 🎯

> **The Angular Router handles navigation and URL-to-component mapping in an SPA, while the Router service allows programmatic navigation and route control from code.**


---

# What is a Pipe in Angular?

A **pipe** in Angular is a **simple way to transform data in the template** before displaying it in the UI.

> Pipes take data as input and return **formatted or transformed output**.

---

## Basic Example

```html
<p>{{ name | uppercase }}</p>
```

```ts
name = 'suraj';
```

### Output

```
SURAJ
```

---

## Why Pipes are used

* Keep templates clean
* Avoid logic in HTML
* Reuse data-transformation logic
* Improve readability

---

## Built-in Pipes (Common)

* `uppercase` / `lowercase`
* `date`
* `currency`
* `decimal`
* `percent`
* `slice`
* `async`

Example:

```html
<p>{{ today | date:'shortDate' }}</p>
```

---

## Custom Pipe Example

```ts
@Pipe({ name: 'shortText' })
export class ShortTextPipe implements PipeTransform {
  transform(value: string, limit: number): string {
    return value.length > limit ? value.slice(0, limit) + '...' : value;
  }
}
```

```html
<p>{{ description | shortText:20 }}</p>
```

---

## Pure vs Impure Pipes

| Pure Pipe             | Impure Pipe                 |
| --------------------- | --------------------------- |
| Default               | Runs every change detection |
| Faster                | Slower                      |
| Input change required | Runs on every check         |

```ts
@Pipe({ name: 'myPipe', pure: false })
```

---

## One-line Interview Summary 🎯

> **A pipe in Angular is a feature used to transform data in templates without changing the original data, making templates clean and readable.**


---

# What is the `async` pipe in Angular?

The **`async` pipe** is a built-in Angular pipe that **automatically subscribes to and unsubscribes from asynchronous data sources** like **Observables** and **Promises**, and renders their latest values in the template.

> It handles async data **without manual subscription**.

---

## Why use the `async` pipe?

* No `subscribe()` in component code
* Automatically updates the UI
* Prevents memory leaks
* Cleaner and safer templates

---

## Basic Example (Observable)

```ts
data$ = this.service.getData(); // Observable
```

```html
<p>{{ data$ | async }}</p>
```

---

## Promise Example

```ts
userPromise = fetchUser();
```

```html
<p>{{ userPromise | async }}</p>
```

---

## How it works internally

* Subscribes when component loads
* Updates view when new value arrives
* Unsubscribes automatically when component is destroyed

---

## Common Real-World Use Case

```html
<div *ngIf="user$ | async as user">
  <p>{{ user.name }}</p>
</div>
```

---

## async pipe vs manual subscribe

| async pipe                 | Manual subscribe     |
| -------------------------- | -------------------- |
| Auto subscribe/unsubscribe | Must unsubscribe     |
| Cleaner template           | More code            |
| Safer                      | Risk of memory leaks |

---

## One-line Interview Summary 🎯

> **The async pipe simplifies working with Observables and Promises by automatically handling subscription, unsubscription, and UI updates in Angular templates.**


---- 

Here’s a **short, sweet, but complete** explanation 👌

---

## What is an Observable in Angular?

An **Observable** is a **data stream** that can emit **multiple values over time** and allows you to **react to asynchronous events** like HTTP calls, user actions, or real-time updates.

> Angular uses Observables (from **RxJS**) to handle async data.

---

## Simple Example

```ts
import { of } from 'rxjs';

data$ = of(1, 2, 3);
```

```ts
data$.subscribe(value => console.log(value));
```

### Output

```
1
2
3
```

---

## Why Angular uses Observables

* Handle async operations
* Support multiple values (not just one)
* Cancel requests easily
* Powerful operators (`map`, `filter`, `switchMap`)
* Works perfectly with `async` pipe

---

## Observable vs Promise

| Observable               | Promise        |
| ------------------------ | -------------- |
| Multiple values          | Single value   |
| Lazy (runs on subscribe) | Eager          |
| Cancelable               | Not cancelable |
| RxJS operators           | No operators   |

---

## Real-world Angular Example (HTTP)

```ts
getUsers() {
  return this.http.get<User[]>('/api/users');
}
```

```ts
this.getUsers().subscribe(users => console.log(users));
```

---

## Cold vs Hot Observables (quick idea)

* **Cold**: starts on subscribe (HTTP)
* **Hot**: already emitting (Events, Subjects)

---

## One-line Interview Summary 🎯

> **An Observable in Angular is a stream of asynchronous data that can emit multiple values over time and is used to handle async operations using RxJS.**


----



# What is RxJS in Angular?

**RxJS (Reactive Extensions for JavaScript)** is a **library for reactive programming** that provides **Observables and operators** to handle **asynchronous and event-based data streams** in Angular.

> Angular uses RxJS to manage async operations like HTTP calls, user events, and real-time data.

---

## Why RxJS is used in Angular

* Handle async data streams
* Compose complex async logic cleanly
* Cancel and retry requests
* Transform data using operators
* Works seamlessly with `async` pipe

---

## Simple Example

```ts
import { of } from 'rxjs';
import { map } from 'rxjs/operators';

of(2, 4, 6)
  .pipe(map(x => x * 2))
  .subscribe(console.log);
```

### Output

```
4, 8, 12
```

---

## Common RxJS Operators

* `map` – transform data
* `filter` – filter values
* `switchMap` – switch streams (HTTP calls)
* `mergeMap` – parallel streams
* `debounceTime` – delay emissions
* `catchError` – handle errors

---

## RxJS in Angular (Real Use)

```ts
this.http.get('/api/users')
  .pipe(
    map(res => res.data),
    catchError(err => of([]))
  );
```

---

## RxJS vs Normal Callbacks

| RxJS         | Callbacks      |
| ------------ | -------------- |
| Declarative  | Imperative     |
| Cancelable   | Hard to cancel |
| Composable   | Hard to manage |
| Stream-based | One-time       |

---

## One-line Interview Summary 🎯

> **RxJS is a reactive programming library used in Angular to work with Observables and operators for handling asynchronous and event-based data streams efficiently.**

----


## What is AOT in Angular?

**AOT (Ahead-of-Time compilation)** is an Angular process where **HTML templates and TypeScript code are compiled into efficient JavaScript at build time**, **before the application runs in the browser**.

> Angular compiles the app **before deployment**, not in the browser.

---

## Why AOT is used

* Faster app startup 🚀
* Smaller bundle size
* Better performance
* Detects template errors at build time
* More secure (no template compilation in browser)

---

## AOT vs JIT

| AOT                   | JIT                  |
| --------------------- | -------------------- |
| Compile at build time | Compile in browser   |
| Faster load           | Slower startup       |
| Errors caught early   | Errors at runtime    |
| Production-ready      | Development-friendly |

---

## Example

```bash
ng build --aot
```

(Enabled by default in production builds)

---

## One-line Interview Summary 🎯

> **AOT in Angular compiles templates and TypeScript code at build time, resulting in faster, smaller, and more secure applications.**



---

# What is the `Subscription` class in RxJS?

The **`Subscription`** class represents an **active execution of an Observable**.
It allows you to **manage and cancel (unsubscribe from) an Observable stream**.

> A Subscription is what you get when you subscribe to an Observable.

---

## Simple Example

```ts
const sub = observable$.subscribe(value => {
  console.log(value);
});
```

```ts
sub.unsubscribe();
```

---

## Why Subscription is important

* Stops receiving values
* Cancels ongoing work (like HTTP, timers)
* Prevents memory leaks
* Controls observable lifecycle

---

## Real Angular Example

```ts
subscription!: Subscription;

ngOnInit() {
  this.subscription = this.service.getData().subscribe();
}

ngOnDestroy() {
  this.subscription.unsubscribe();
}
```

---

## Multiple Subscriptions

```ts
const sub = new Subscription();

sub.add(obs1.subscribe());
sub.add(obs2.subscribe());

sub.unsubscribe(); // cancels all
```

---

## Subscription vs async pipe

| Subscription       | async pipe        |
| ------------------ | ----------------- |
| Manual unsubscribe | Auto unsubscribe  |
| More control       | Cleaner templates |
| Used in TS         | Used in HTML      |

---

## One-line Interview Summary 🎯

> **The Subscription class in RxJS represents an active Observable execution and provides the ability to cancel it using `unsubscribe()`.**
