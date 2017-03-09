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

##Table of Contents             
1. Introduction. 
2. System Archtiecture 
3. High-Level Design 
4. Problems and Resolution
5. Installation Guide
6. Appendices

We declare that this material, which We now submit for assessment, is entirely our own work and has not been taken from the work of others, save and to the extent that such work has been cited and acknowledged within the text of my/our work. We understand that plagiarism, collusion, and copying are grave and serious offences in the university and accept the penalties that would be imposed should we engage in plagiarism, collusion or copying. We have read and understood the Assignment Regulations. We have identified and included the source of all facts, ideas, opinions, and viewpoints of others in the assignment references. Direct quotations from books, journal articles, Internet sources, module text, or any other source whatsoever are acknowledged and the source cited are identified in the assignment references. This assignment, or any part of it, has not been previously submitted by us or any other person for assessment on this or any other course of study. We have read and understood the referencing guidelines found at: http://www.dcu.ie/info/regulations/plagiarism.shtml 

-------------------------------------------------------------------------------

##Introduction

###Overview
For our Third year project we decided to design a POS Application, which we called Order 66. Order 66 is an application aimed at Resturants,Bars and Cafes that will accompany and in the future replace your current till system. Order 66 uses a website admin interface which will allow an employer create his menu for his resturant/bar/cafe, add all his employee details so he can easily manage their accounts, automatically create reports lastly have access to helpful usage statistics. Employee's can also download our Andoird Application which will allow employee's to create orders using the menu their employer has created and send orders so all other employee's can view them and start preparing them seconds after it has been sent.

Order 66 has many benefits for both the employer and the employee as it can help improve efficency in the workplace which can in turn can provide greater returns for the employer. Not to mention making the employee's life that much easier as they won't have to worry about forgetting what was in each order, what order went to what table and did I tell me co-workers about the last order. 

//FINISH ANOTHER PARAGRAPH

###Glossary

*POS App* - Point Of Sale Application
*WiFi P2P* - WiFi Peer to Peer

##System Archtiecture

-Distribution of functions
-Architectual components that are reused (Data strauctures?)
-3rd party libarys highlighted here.

Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum

##High-Level Design

-System models showing relationships between components & systems
-eg DFD

Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum

##Problems and Resolution

-Major problems encountered (WiFi P2P)

### WiFi P2P

After our initial design and research we intended to use android's native WiFi P2P libary, that would allow us to be able to send data between two devices that are connected by a Local Area Network, this can also be achieved by using a mobile devices ability to create a hotspot, which would act as the Local Area Network. The issues we encounterd was that the WiFi P2P libary is a recent addition to the android framework and was previously called Android Beam meaning that only devices from API level 14 or higher would be capable of using the service. 

Another issue we came accross was that the P2P services acts similarly to a bluetooth connection as it uses WPS for security and as a result needs the user to hit accept for each file transfer.

Another issue which was the most major was the once two devices were connected, one device would become the group owner and would act as the server while the rest would act as clients. The problem was that the group owner was only able to receive files and to become the group owner, you would have to disconnect and reconnect, meaing the user would have to accept the connection again which wasn't practical as if a waitress wanted to send an order to the kitchen, she could but then to get any updates on the staus of the order, the waitress would have to accept the connection from the kitchen each time they wanted to change the order status. 

Lastly disconnecting from a group was not very consistant as the group was only destroyed after the group owner disconnected and the connection timeout was reached. This meant that users would may have tried to disconnect to an empty group while the other user may create a new group or their Status would change from available to either busy and wouldn't be able to be found by the searching devices.

Our solution to these issues was to try an alternative method, which resulted in the application requring an Internet connection to be able to function. We used the HTTP POST request to run PHP files on a server that would handle accessing and storing all our data on a MYSQL Server. 

##Installation Guide

- 1/2 page install guide, step by step process.
- detailed description of software neccessary.
- list all software, components, versions, hardware etc.

Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum

##Appendices