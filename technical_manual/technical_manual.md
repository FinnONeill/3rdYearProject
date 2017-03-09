# POS App Technical Manual

Date:               
* 30th November 2016
 
Student Names:      
* Finnian O’Neill 
* Ian Kelly

Supervisor:           
* Dr.David Sinclair

Co-ordinator:
* Dr.David Sinclair

## Table of Contents             
1. Introduction. 
2. System Archtiecture 
3. High-Level Design 
4. Problems and Resolution
5. Installation Guide
6. Appendices

We declare that this material, which We now submit for assessment, is entirely our own work and has not been taken from the work of others, save and to the extent that such work has been cited and acknowledged within the text of my/our work. We understand that plagiarism, collusion, and copying are grave and serious offences in the university and accept the penalties that would be imposed should we engage in plagiarism, collusion or copying. We have read and understood the Assignment Regulations. We have identified and included the source of all facts, ideas, opinions, and viewpoints of others in the assignment references. Direct quotations from books, journal articles, Internet sources, module text, or any other source whatsoever are acknowledged and the source cited are identified in the assignment references. This assignment, or any part of it, has not been previously submitted by us or any other person for assessment on this or any other course of study. We have read and understood the referencing guidelines found at: http://www.dcu.ie/info/regulations/plagiarism.shtml 

-------------------------------------------------------------------------------

## Introduction

### Overview
For our Third year project we decided to design a POS Application, which we called Order 66. Order 66 is an application aimed at Resturants,Bars and Cafes that will accompany and in the future replace your current till system. Order 66 uses a website admin interface which will allow an employer create his menu for his resturant/bar/cafe, add all his employee details so he can easily manage their accounts, automatically create reports lastly have access to helpful usage statistics. Employee's can also download our Andoird Application which will allow employee's to create orders using the menu their employer has created and send orders so all other employee's can view them and start preparing them seconds after it has been sent.

Order 66 has many benefits for both the employer and the employee as it can help improve efficency in the workplace which can in turn can provide greater returns for the employer. Not to mention making the employee's life that much easier as they won't have to worry about forgetting what was in each order, what order went to what table and did I tell me co-workers about the last order. 

//FINISH ANOTHER PARAGRAPH

###Glossary

*POS App* - Point Of Sale Application

### Operational Scenarios

##### Registering on the website. 

***Precondition*** --- The company is not registered on the website. 

***Activation*** --- The company wants to sign up on the website.

***Description :***  
* The company owner/ manager goes to the website.
* They press the 'Get Started' or 'Sign Up' buttons.
* They enter the company details.
* They enter the employer's details.
* They click 'Submit' when finished.

***Termination*** --- The company is successfully registered to the website.

##### Adding an employee to the website. 

***Precondition*** --- The employee is not registered on the website. 

***Activation*** --- A new employee has started working at the restaurant.

***Description :***  
* The company owner/manager goes to the website.
* They sign into the company account.
* They click 'Add New Employee' on the left.
* They enter the employee's details.
* They click the green '+ Add Employee' button when finished.

***Termination*** --- The employee is successfully registered to the website.

##### Removing an employee from the website. 

***Precondition*** --- The employee is already registered on the website. 

***Activation*** --- An existing employee has finished working at the restaurant.

***Description :***  
* The company owner/manager goes to the website.
* They sign into the company account.
* They click 'Remove Employee' on the left.
* They enter the employee's PPS number and name.
* They click the red '- Add Employee' button when finished.

***Termination*** --- The employee is successfully removed from the website.

##### Adding a new menu item. 

***Precondition*** --- The menu item is not registered on the website. 

***Activation*** --- A new item is being added to the menu.

***Description :***  
* The company owner/manager goes to the website.
* They sign into the company account.
* They click 'Add Menu Item' on the left.
* They enter the item's name, description, and price
* The select an item category.
* They click the green '+ Add Employee' button when finished.

***Termination*** --- The item is successfully added to the menu.

##### Removing a menu item. 

***Precondition*** --- The item is already on the menu. 

***Activation*** --- The manager/owner wants to remove a menu item.

***Description :***  
* The company owner/manager goes to the website.
* They sign into the company account.
* They click 'Remove Employee' on the left.
* They enter the item's name, and price
* The select an item category.
* They click the red '- Remove Menu Item' button when finished.

***Termination*** --- The item is successfully removed from the menu.

##### Signing in to the app. 

***Precondition*** --- The staff member has not signed into the app. 

***Activation*** --- The user opens the app.

***Description :***  
* The staff member selects the email box.
* They enter in an email address.
* The staff member selects the password box.
* They enter in a password.
* They press the 'Sign In' button.

***Termination*** --- The staff member has logged into the app.

##### Creating an order 

***Precondition*** --- The staff member has not already made an order. 

***Activation*** --- A customer has decided to order a meal.

***Description :***  
* The staff member presses the 'Create an order' button on the main menu or in the sidebar.
* They select the table that the customer is sitting at.
* They select a food item.
* They staff member presses the green button to add the item to the order.
* They are automatically returned to the menu screen.
* They press the green button in the bottom-right of the screen.
* The user is sent to the order screen.
* The staff member presses the button in the bottom-right to send the order.


***Termination*** --- The order has been sent.

##### Receiving an order 

***Precondition*** --- The staff member has not received an order.

***Activation*** --- Another staff member has created and sent an order. 

***Description :***
* The The staff member presses the 'View all Open Orders' button on the main menu or in the sidebar.
* They select an order that they have received.
* They complete the order.
* Once completed, the staff member presses the green button to the delete the order.

***Termination*** --- The order has been deleted. 

<<<<<<< HEAD

=======
*WiFi P2P* - WiFi Peer to Peer


##System Archtiecture
=======
## System Archtiecture
>>>>>>> 62d340a933b1429f66d75fff92a683eed70f7972

-Distribution of functions
-Architectual components that are reused (Data strauctures?)
-3rd party libarys highlighted here.

<<<<<<< HEAD


![System Architecture](./Images/Screenshot_4.PNG)
=======
![System Architecture](./images/Screenshot_4.PNG)
>>>>>>> 62d340a933b1429f66d75fff92a683eed70f7972

![Sequence Diagram](./Images/Screenshot_3.PNG)

## High-Level Design

-System models showing relationships between components & systems
-eg DFD

<<<<<<< HEAD


![App BAM](./Images/Screenshot_1.PNG)
=======
![App BAM](./images/Screenshot_1.PNG)
>>>>>>> 62d340a933b1429f66d75fff92a683eed70f7972

![Website BAM](./Images/Screenshot_5.PNG)

![DFD](./Images/Screenshot_2.PNG)

## Problems and Resolution

-Major problems encountered (WiFi P2P)

### WiFi P2P

After our initial design and research we intended to use android's native WiFi P2P libary, that would allow us to be able to send data between two devices that are connected by a Local Area Network, this can also be achieved by using a mobile devices ability to create a hotspot, which would act as the Local Area Network. The issues we encounterd was that the WiFi P2P libary is a recent addition to the android framework and was previously called Android Beam meaning that only devices from API level 14 or higher would be capable of using the service. 

Another issue we came accross was that the P2P services acts similarly to a bluetooth connection as it uses WPS for security and as a result needs the user to hit accept for each file transfer.

Another issue which was the most major was the once two devices were connected, one device would become the group owner and would act as the server while the rest would act as clients. The problem was that the group owner was only able to receive files and to become the group owner, you would have to disconnect and reconnect, meaing the user would have to accept the connection again which wasn't practical as if a waitress wanted to send an order to the kitchen, she could but then to get any updates on the staus of the order, the waitress would have to accept the connection from the kitchen each time they wanted to change the order status. 

Lastly disconnecting from a group was not very consistant as the group was only destroyed after the group owner disconnected and the connection timeout was reached. This meant that users would may have tried to disconnect to an empty group while the other user may create a new group or their Status would change from available to either busy and wouldn't be able to be found by the searching devices.

Our solution to these issues was to try an alternative method, which resulted in the application requring an Internet connection to be able to function. We used the HTTP POST request to run PHP files on a server that would handle accessing and storing all our data on a MYSQL Server. 

## Installation Guide

- 1/2 page install guide, step by step process.
- detailed description of software neccessary.
- list all software, components, versions, hardware etc.

Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum

## Appendices