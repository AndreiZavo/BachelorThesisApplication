# Smart Bites 🥧
## The mobile application with autmated recommendation systems in the food spectrum

## Table of Contents
* [Introduction](#introduction)
* [Tour of the app](#tour-of-the-app)
* [Conclusion](#conclusion)

## Introduction
The solution presented is a user-oriented mobile application that has a system of recommendation for recipes. The system is constructed with artificial intelligence, in order to help the users choose more easily what to eat by automatically recommending various recipes depending on what they thought to be a good fit for them.
The concept of the system is of an easy to use mobile application focused on the user. This means that there are solid concepts and heuristics regarding the user interface and user experience for the purpose of making the navigation and understanding of the app as smooth as possible. Moreover, the recommendations given by the system are tailored to each user that utilises the app, making each relation between the user and the application unique.

## Tour of the app

### Login & Register
<table style="margin-left:auto;margin-right:auto;width:98%">
  <tr>
   <td> <img src="./mockups/Log in.png" style="height:50%;width:250px"> </td>
   <td> <img src="./mockups/Log in Error.png" style="height:50%;width:250px"> </td>
   <td> <img src="./mockups/Sign Up.png" style="height:50%;width:250px"> </td>
   <td> <img src="./mockups/Sign Up_Error.png" style="height:50%;width:250px"> </td>
 </tr> 
</table>

In order for the user to utilise the application, first step is to enter a set of valid credentials. The users log with the already created account or they sign up for a new one and then they can log in. From the backend potint of view, this proccess is possible with the help of the Firebase library.

### Home page
<table style="margin-left:auto;margin-right:auto;width:98%">
  <tr>
   <td style="padding-left:250px"> <img src="./mockups/Homepage.png" style="height:50%;width:250px"> </td>
   <td> <img src="./mockups/First time on Homepage.png" style="height:50%;width:250px"> </td>
 </tr> 
</table>
Home page is where the collections of recipes, including the personalised one, can be viewed and inspected. At the top of the screen there is a banner that displays the most appreciated recipe of the week, followed by a collection of recipe recommendations tailered for each user, and than, other recipe collections that may be of help. 

### Recipe page

Recipe page is where the user can check all the details of a specific recipe and follow them in the process of cooking it


### Account page

Account page is where users can view their saved and liked recipes, as well see their given ratings and modify their profile

### Search page

Search page is where the user can search after a certain recipe

## Conclusion
