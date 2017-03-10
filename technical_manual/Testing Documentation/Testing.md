# POS App - Testing

Date:               
* 30th November 2016
 
Student Names:      
* Finnian O’Neill 
* Ian Kelly

Supervisor:           
* Dr.David Sinclair

Co-ordinator:           
* Dr.David Sinclair

##Table of Contents             
1. Unit Tests 
2. Known Bugs and Issues
3. Appendices

## Unit Tests

## Known Bugs and Issues

### Android Application
1. An internet connection is required to use the app, could be solved by >>>>>>
2. If you have a connection and input the wrong username or password, it will print the "Oops! Something went wrong, check your connection" instead of printing the correct "Incorrect username or password".
3. The price, table number and Person who created the order are not being sent or stored in the database with the current version of the application due to time constraints and as a result the price of each order, the table number the order came from and who sent the order are not accessable in received orders.
4. When in the Item detail view, it will only display the first 15 characters of a menu item, pending the size of your device.
5. If you rotate the screen, the Item name will revert back to the default "Food Description".
6. When you add multiple orders in a session, the Menu item number to the left of the menu item name, when on the total/current order will keep increasing and not reset correctly until the application is closed or you log out.
7.  After sending an order, to get back to the home screen to be able to view the received orders, you have to press back multiple times to go back through the total order,then menu, then table list, then back to the home screen.
8.  Received orders currently only display the order number, which is a string representation of dd/mm/yyyy/hh/mm/ss as a result of Bug 3, mentioned above.
9.  When you press the remove/complete order button, it doesn't yet return you to the list of received orders
10.  There is no check or login status for accounts which means you can login on all devices using one account. 
11. Pressing the back button in the top left while in menu details send you back to the table list instead of the menu list. Pressing back on your phone sends you back to the main menu.
12. Viewing received orders may inexplicably cause the app to crash.

### Website
1. When using the website on a mobile device and you press the menu button to drop down the navbar, it pushes down the Text.
2. When logging in on a mobile device, the close button for the login modal is pushed to a new line.
3. On a mobile device, the sidebar on the employer admin page won't display.
4. If you try to remove an employee and input either the wrong PPS number or wrong name, it won't give an error message and nothing will happen, this is also the case for removing a menu item. 
5. Item price will accept a string.

## Cognitive Walkthrough

#### User

* College student in his late teens.
* Working part time on the weekends for extra money.
* Busy day at the restaurant, is a little stressed and tired.
* Comfortable with android phones. Moderately tech savvy.

#### Goal

* To order a Caesar salad for a customer.

#### Optimum task structure

* Log in -> Select Table -> Select Salad -> Add Salad To Order -> Shortcut To Order -> Send Order

***Task One: Log In***

The user loads into the app and is faced with the login screen, they notice the screen contains a box labelled 'menu' and another labelled 'password'. They are familiar with login screens and enter the email address and password they were given when they began working at the restaurant.

***Task Two: Select Table***

The user loads into the table list screen and without confusing knows that each table number represents the tables in the restaurant. They select the correct table for the order.

***Task Three: Select Salad***

Like the table list, there is little ambiguity in the menu list. The user selects the item that says 'Caesar Salad'.

***Task Four: Select Salad***

The user is taken to the menu detail screen, they read the price and description of the salad. They notice a green button on the right hand side and assume that that button is to add it to the menu. They press the button and are sent back to the menu list. There was no indication that the salad was added to the order so they go and check the order. 

***Task Five: Shortcut To Order***

The user is unaware that the green button in the bottom right hand corner of the menu is a shortcut to the order so they instead back all the way to the main menu. They notice the sidebar in the top left and corner and open it. The select total order and are sent to the order page.

***Task Six: Send Order***

On the order page, the user notices another green button in the lower right sand side of the screen with a tick on it. Assuming it has a similar function to the other green buttons on the app, they think that it will send the app. They press the button and a small message at the botton of the screen pops up to notify them that their order has been sent.

#### User task structure

* Log in -> Select Table -> Select Salad -> Add Salad To Order -> Back To Table List -> Back To Main Menu  -> Open Sidebar -> Select Total Order -> Send Order


## Appendices


