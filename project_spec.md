# **Carbonator**


## Table of Contents

1. [App Overview](#App-Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
1. [Build Notes](#Build-Notes)

## App Overview

### Description 

** Did you know the average American drives about 14,263* miles per year? This app helps users learn more about the quantity of carbon emissions from certain cars. The first page shows a view with the top 10 selling cars in the United States, if these cars were driven 15,000 miles annually. The second page allows users to calculate how much CO2e the user would emit if they were to personally drive one of those cars, by inputting how many miles they travel annually**

### App Evaluation

<!-- Evaluation of your app across the following attributes -->

- **Mobile:** The mobile format allows users to access the data of a API on the go. They can reference the emissions of the top selling cars in America. They can also calculate the amount of emissions of those cars, if they were to drive themselves. A stretch feature would allow the user to access data relevant to their own car. 
- **Story:** In terms of clarity, the number of CO2e emissions may be abstract to the average user. It is possible that we need to break down CO2e score so the average user can understand the impact of their actions on a greater scale. People who use this app will be conscious of their impact on the enviroment, so it will be important to help users understand. For example, "Your activities used a total of ___ CO2e. That's the equivalent of a computer running all day!"
- **Market:** While it does not provide a service (like Uber) or alleviate an inconvenience (like Amazon), it addresses a niche but growing audience. Potential user base would depend on the amount of people who are interested in preventing climate change. As more people are interested in going green (like how many are switching to electric vehicles) we predict that more and more people will use it. 
- **Habit:**Could be very habit forming depending on individual interest in climate change. Especially with teams/social feature, but otherwise may only be an app used every so often. 
- **Scope:** The challenging part would be to generate information for the user regarding their own car. We would need to know how to make the drop down menu and call the API with the drop down menu. 

## Product Spec

### 1. User Features (Required and Optional)

**Required Features:**

**Page 1:**
- Users scroll through the top selling cars in America to learn about the amount of CO2 that each car would release, if driven 15,000 that year. 

**Page 2:**
- Users can calculate emissions of the top selling cars, by inputting the amount of miles they would normally travel in a year. This lets users know how much they would emit if they drove that car. 

**Custom Styling**
- Custom styling for "activity_calculations.xml" and "car_items.xml"

Stretch Features:

- A stretch feature would allow the user to input data from their own car, by looking up the make and model of the car and the amount of miles traveled. 
- Another stretch feature would be to try to find pictures of the associated cars, but it really depends on the API we find. 

### 2. Chosen API(s)

- **Carbon Interface: https://docs.carboninterface.com/#/*
  - **Allows users to look up information from the top selling cars in America**

### 3. User Interaction

Required Feature
- [X] Users can scroll through a list of the top selling cars in America
  -=> Allows users to be more informed about different cars
- [X] Users can input the amount of miles they might travel annually
  -=> Users can see how much CO2 they would emit if they drove those cars


## Wireframes

<!-- Add picture of your hand sketched wireframes in this section -->
<img src="https://i.imgur.com/k2B91hH.png" width=600>

### [BONUS] Digital Wireframes & Mockups
https://www.figma.com/file/attvc6XtKLwPz5KbrpTIsN/Prototyping-Example-(Copy)?node-id=0-1

### [BONUS] Interactive Prototype

## Build Notes

*Miles per year from: https://www.thezebra.com/resources/driving/average-miles-driven-per-year/#states-where-americans-drive-the-least
Here's a place for any other notes on the app, it's creation 
process, or what you learned this unit!  

For Milestone 2, include **2+ GIFs** of the build process here!

## License

Copyright **2023** **Kenneth Ramos, Tasneem Iqbal, Tedman Nguyen**



Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
