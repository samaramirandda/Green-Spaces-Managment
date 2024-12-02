# EcoData - Green Space Management Application 
## User Manual

* Version: 1.0
* Release Date: June 2024
* Developed by: Daniel Silva, Igor Coutinho, Rafael Barbosa e Samara Miranda

## Table of Contents
1. [Introduction](#introduction)
2. [System Overview](#system-overview)
    - [Product Description](#product-description)
    - [Main Features](#main-features)
        - [Main Functionalities](#main-functionalities)
        - [Benefits](#benefits)
3. [Features](#features)
    - [Register Skills of a Collaborator](#1-register-skills-of-a-collaborator--human-resources-manager)
    - [Register a Job](#2-register-a-job--human-resources-manager)
    - [Register collaborator with job and fundamental characteristics](#3-register-collaborator-with-job-and-fundamental-characteristics--human-resources-manager)
    - [Assign Skills](#4-assign-skills--human-resources-manager)
    - [Generate a team proposal automatically](#5-generate-a-team-proposal-automatically--human-resources-manager)
    - [Register a vehicle](#6-register-a-vehicle--vehicle-and-equipment-fleet-manager)
    - [Register Vehicle's Check-up](#7-register-vehicles-check-up--vehicle-and-equipment-fleet-manager)
    - [List the vehicles needing the check-up](#8-list-the-vehicles-needing-the-check-up--vehicle-and-equipment-fleet-manager)
    - [Know the exact costs referring to water consumption](#9-know-the-exact-costs-referring-to-water-consumption--green-spaces-manager)
    - [Know in a pie chart which pieces of equipment are used in each day](#10-know-in-a-pie-chart-which-pieces-of-equipment-are-used-in-each-day--green-spaces-manager)
    - [Collect data from the user portal](#11-collect-data-from-the-user-portal--green-spaces-manager)
    - [Import a .csv file containing routes for pipe installation](#12-import-a-csv-file-containing-routes-for-pipe-installation--green-spaces-manager)
    - [Know the routes to be opened, with minimum cost](#13-know-the-routes-to-be-opened-with-minimum-cost--green-spaces-manager)
    - [Tests to observe asymptotic runtime behavior](#14-tests-to-observe-asymptotic-runtime-behavior--software-quality-assessment-team-manager)
    - [Forecast of water consumption costs in the park](#15-forecast-of-water-consumption-costs-in-the-park--green-spaces-manager)
    - [The best line that fits the data](#16-the-best-line-that-fits-the-data--green-spaces-manager)
    - [Faster routes from the signage to the Assembly Point](#17-faster-routes-from-the-signage-to-the-assembly-point--green-spaces-manager)
    - [Fastest routes from signage to one of the Assembly Points](#18-fastest-routes-from-signage-to-one-of-the-assembly-points--green-spaces-manager)
    - [Register a Green Space](#20-register-a-green-space--green-spaces-manager)
    - [Add a new entry to the To-Do List](#21-add-a-new-entry-to-the-to-do-list--green-spaces-manager)
    - [Add a entry in the Agenda](#22-add-a-entry-in-the-agenda--green-spaces-manager)
    - [Assign a Team to an entry in the Agenda](#23-assign-a-team-to-an-entry-in-the-agenda--green-spaces-manager)
    - [Postpone an entry in the Agenda](#24-postpone-an-entry-in-the-agenda--green-spaces-manager)
    - [Cancel an entry in the Agenda](#25-cancel-an-entry-in-the-agenda--green-spaces-manager)
    - [Assign Vehicles to an entry in the Agenda](#26-assign-vehicles-to-an-entry-in-the-agenda--green-spaces-manager)
    - [List of green spaces managed by me](#27-list-of-green-spaces-managed-by-me--green-spaces-manager)
    - [Consult the Task Between Two Dates](#28-consult-the-task-between-two-dates--collaborator)
    - [Record the completion of a task](#29-record-the-completion-of-a-task--collaborator)
4. [Troubleshooting](#troubleshooting)
5. [Frequently Asked Questions (FAQ)](#frequently-asked-questions-faq)

### Glossary

**Terms, Expressions and Acronyms (TEA) must be organized alphabetically.**

| **_TEA_** (EN)                          | **_Description_** (EN)                                                                                                                                                                                                                             |                                       
|:----------------------------------------|:---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Absolute Frequency Tables**                | A statistical table that presents the counts or frequencies of individual values or categories within a dataset. It shows the number of occurrences of each value or category without considering their relative proportions.                                                                                                                                                                                                                                                                                                                                                                                                                 |
| **Agenda**                                   | Planning system that assigns specific tasks to teams within set time frames on certain dates, aiding in workload assessment and team productivity evaluation.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 |
| **Assembly Points**                          | Are locations previously determined and known by all employees, where people must meet in the event of an evacuation or emergency.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            |
| **Barplot**                                  | A bar chart used to represent categorical data, where the height or length of each bar is proportional to the value it represents.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            |
| **Boxplot**                                  | A graphical representation of the distribution of a dataset through five summary statistics: minimum, first quartile (Q1), median (Q2), third quartile (Q3), and maximum. It visually depicts the central tendency, variability, and skewness of the data, as well as the presence of outliers. The boxplot consists of a rectangular "box" spanning the interquartile range (Q3-Q1), with a line representing the median. Whiskers extend from the box to the minimum and maximum values within a certain range or to the data points that are not considered outliers. Outliers, if presents, are plotted individually beyond the whiskers. |
| **Check-Up**                                 | Examination or complete check with the aim of detecting problems.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             |
| **Coefficient of Skewness**                  | A statistical measure that quantifies the asymmetry or lack of symmetry in a distribution of data. It indicates whether the data distribution is symmetric, positively skewed (long tail on the right), or negatively skewed (lon tail on the left). Positive skewness mean tha the distribution has a longer tail on the right side, while negative skewness indicates a longer tail on the left side.                                                                                                                                                                                                                                       |
| **Collaborator**                             | Person who is an employee of the organization and carries out design, construction and/or maintenance tasks for green areas, depending on their skills.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       |
| **Equipment**                                | The equipment can be greatly diverse, such as sprayers, lifting platforms, chainsaws, brush cutters, blowers, ladders, cisterns and the various elements that can be attached to tractors, such as disc harrows, weeders, aerators and scarifiers.                                                                                                                                                                                                                                                                                                                                                                                            |
| **Employee**                                 | Same as _Collaborator_.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       |
| **Entry**                                    | Given that stores tasks that make up the agenda.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              |
| **Evacuation Routes**                        | Indicate the path that users must follow from multiple locations in the park to a Assembly Point from which an organized evacuation of the park will take place.                                                                                                                                                                                                                                                                                                                                                                                                                                                                              |
| **Execution Time**                           | The time required for a program or algorithm to complete, usually measured in units of time such as seconds, milliseconds, or processor cycles. Runtime can vary depending on various factors, including input size, algorithm complexity, code efficiency, and hardware characteristics where the program is being executed.                                                                                                                                                                                                                                                                                                                 |
| **Fleet Manager**                            | Same as _Vehicle and Equipment Fleet Manager_.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                |
| **FM**                                       | Acronym for _Fleet Manager_.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  |
| **Garden**                                   | Garden space with or without trees with little or no equipment (may have a basic irrigation system or sitting benches);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       |
| **Graph**                                    | A collection of nodes (vertices) and edges (connections) that link pairs of nodes. Graphs are used to represent relationships or connections between objects, where nodes typically represent entities (such as people, places, or items) and edges represent the relationships between them. Graphs can be directed (edges have a specific direction) or undirected (edges have no specific direction).                                                                                                                                                                                                                                      |
| **Green Spaces**                             | Vary in size and amenities, from small gardens to medium-sized parks with amenities, to large parks with extensive facilities.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                |
| **Green Spaces Manager**                     | Person responsible for managing the green spaces in charge of the organization.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               |
| **Green Spaces User**                        | Person who uses the green spaces managed by the organization and who can through the Portal, make comments or report faults in parks and gardens on the Portal.                                                                                                                                                                                                                                                                                                                                                                                                                                                                               |
| **Gross Weight**                             | Total weight of the goods carried, including all packaging but excluding the tare weight of the transport unit.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               |
| **GSM**                                      | Acronym for _Green Spaces Manager_.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| **GS**                                       | Acronym for _Green Spaces_.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   |
| **GSU**                                      | Acronym for _Green Spaces User_.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              |
| **Histograms**                               | A graphical representation of the distribution of numerical data. It consists of a series of contiguous bars where the height of each bar represents the frequency or relative frequency of data within a certain range or interval.                                                                                                                                                                                                                                                                                                                                                                                                          |
| **HRM**                                      | Acronym for _Human Resources Manager_.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        |
| **Human Resources Manager**                  | Person who manages human resources and defines teams based on the needs of ongoing projects and the skills of the employees.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  |
| **Independent Variable**                     | A variable that is manipulated or controlled by the researcher. It is the variable that is hypothesized to have an effect on the dependent variable(s). In an experiment, the independent variable is intentionally changed or varied to observe its effect on the dependent variable(s). In observational studies, the independent variable is often observed and measured to determine its relationship with the dependent variable(s).                                                                                                                                                                                                     |
| **Input Size**                               | Refers to the measure of the amount of data or the complexity of the problem being processed by an algorithm. It typically represents the number of elements or variables that are provided as input to the algorithm.                                                                                                                                                                                                                                                                                                                                                                                                                        |
| **Irrigation Systems**                       | A set of devices, techniques, and methods used to supply water to plants in a controlled manner, aiming to meet their water needs and optimize the growth and development of crops.                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| **Job**                                      | An employee's main occupation.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                |
| **Key Performance Indicator**                | Metric used to assess the effectiveness and progress of an organization, team, or process towards strategic goals. KPIs are specific, measurable, relevant, and time-bound, aiding in decision-making and identifying areas that need improvement.                                                                                                                                                                                                                                                                                                                                                                                            |
| **Kms**                                      | Acronym for _Kilometers_.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     |
| **KPI**                                      | Acronym for _Key Performance Indicator_.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      |
| **Large-sized park**                         | Multi-function space with diverse garden spaces, and woods, including varied equipment and services.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          |
| **Linear Regression**                        | A statistical method used to model the relationship between a dependent variable and one or more independent variables by fitting a linear equation to the observed data. In simple linear regression, there is only one independent variable, while in multiple linear regression, there are multiple independent variables. The goal of linear regression is to find the best-fitting line that minimizes the difference between the observed values and the values predicted by the linear model.                                                                                                                                          |
| **Mean**                                     | Statistical measure that represents the central value of data set, calculated by summing all the values and diving the total by the number of values.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         |
| **Median**                                   | Statistical measure that indicates the central value of an ordered data set. The median divides the set into two equal parts, with half of the values being lower and the other half being higher.                                                                                                                                                                                                                                                                                                                                                                                                                                            |
| **Medium-sized park**                        | Green space with a few hundred or thousands of square meters with a wooded garden area, it includes some infrastructures such as toilets, drinking fountains, irrigation system, lighting, children’s playground.                                                                                                                                                                                                                                                                                                                                                                                                                             |
| **Monthly Cost**                             | The total expenditure incurred by an individual, organization, or entity over the course of one month. This cost encompasses various expenses such as rent, utilities, groceries, transportation, entertainment, and other recurring payments.                                                                                                                                                                                                                                                                                                                                                                                                |
| **MS**                                       | Acronym for _MusgoSublime_.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   |
| **Multi-disciplinary Team**                  | Groups of individuals with different skills, knowledge, and experiences, usually from different areas of expertise, who collaborate in an integrated manner to achieve common goals. Working in multidisciplinary teams promotes the exchange of ideas, innovation, comprehensive problem-solving, and the completion of projects that require interdisciplinary knowledge.                                                                                                                                                                                                                                                                   |
| **MusgoSublime**                             | An organization dedicated to the planning, construction and maintenance of green spaces.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      |
| **Occasional Tasks**                         | Non-routine activities or assignments that are performed infrequently or as needed. These tasks typically arise sporadically in response to specific situations, events, or requirements.                                                                                                                                                                                                                                                                                                                                                                                                                                                     |
| **Outliers**                                 | Observations in a dataset that deviate significantly from the overall pattern or observed trend. These observations are considered unusual, anomalous, or exceptional compared to the rest of the data and can distort statistical analyses if nor properly addressed.                                                                                                                                                                                                                                                                                                                                                                        |
| **Pie Chart**                                | A graphical representation of data that displays categories as slices of a circular "pie". The size of each slice is proportional to the quantity it represents in relation to the whole.                                                                                                                                                                                                                                                                                                                                                                                                                                                     |
| **Polynomial Regression**                    | A type of regression analysis used to model the relationship between a dependent variable and one or more independent variables by fitting a polynomial equation to the observed data. Unlike linear regression, which fits a straight line to the data, polynomial regression can capture more complex relationships by using higher-degree polynomial equations.                                                                                                                                                                                                                                                                            |
| **QAM**                                      | Acronym for _Software Quality Assessment Team Manager_.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       |
| **Regular Tasks**                            | Routine activities or assignments that are performed on a recurring basis as part of a schedule or established procedure. These tasks are typically predictable and occur regularly, such as daily, weekly, monthly, or annually.                                                                                                                                                                                                                                                                                                                                                                                                             |
| **Relative Frequency Tables**                | A statistical table that displays the proportion of observations falling into various categories or intervals within a dataset. It is constructed by diving the frequency of each category by the total number of observations, expressing the result as a fraction or percentage.                                                                                                                                                                                                                                                                                                                                                            |
| **Response Variable**                        | The outcome or variable of interest that is measured or observed in a study. It is the variable that researchers are trying to understand, explain, or predict based on the values of other variables, particularly the independent variable(s).                                                                                                                                                                                                                                                                                                                                                                                              |
| **Skill**                                    | A natural facility or something learned before that helps someone to take on certain tasks or responsibilities.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               |
| **Software Quality Assessment Team Manager** | A person who manage the Software Quality Assessment Team and its process.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     |
| **Standard Deviation**                       | A statistical measure that quantifies the dispersion or variability of values in a data set. Calculated as the square root of the variance, the standard deviation indicates how far the values are from the mean, being an important tool for evaluating data consistency.                                                                                                                                                                                                                                                                                                                                                                   |
| **Subgraph**                                 | In graph theory, a subgraph is a graph that consists of a subset of the vertices and edges of a larger graph. Essentially, it is a graph that is derived from another graph by removing some vertices and/or edges. A subgraph retains the same structure as the original graph but may contain fewer vertices and edges.                                                                                                                                                                                                                                                                                                                     |
| **System User**                              | Multiple users that use the system.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| **Tare**                                     | The weight of a transport unit before any cargo is loaded.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    |
| **Task**                                     | Instructions given to carry out occasionally or regularly.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    |
| **Team**                                     | Temporary associations of employees who will carry out a set of tasks in one or more green spaces.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            |
| **To-Do List**                               | Comprises all pending tasks for all parks. The entries in this list describe the required task, the degree of urgency (High, Medium, and Low), and the approximate expected duration.                                                                                                                                                                                                                                                                                                                                                                                                                                                         |
| **User Portal**                              | Location where users of parks and gardens can post comments and report faults and malfunctions of equipment.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  |
| **Vehicle and Equipment Fleet Manager**      | Person who manages the fleet park, the machines, equipment and vehicles, ensuring their good condition and assigning them to the tasks to be carried out.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     |
| **VFM**                                      | Acronym for _Vehicle and Equipment Fleet Manager_.                                                                                                                                                                                               |


---

## Introduction
This manual aims to provide comprehensive guidance on how to effectively use the software solution developed to support the planning and maintenance of communal green spaces, with the aim of helping any user to use this product efficiently. Therefore, it contains guidance on how anyone can understand and operate this application used to maintain green spaces through its features and functions.

This manual contains specifications for using the tools that the application makes available, through, but not limited to, diagrams and images designed to assist the user, managers and administrators of green spaces.

Therefore, the manual is aimed at the Human Resources Manager, Vehicle and Equipment Fleet Manager, Green Space Manager, Green Space User, among others responsible for maintaining green spaces.

---
# System Overview

## Product Description
The application is a comprehensive digital solution developed to support the effective management of collective green spaces in urban contexts. This software aims to simplify and optimize the planning and maintenance activities of gardens and parks, meeting the growing demands of the population for quality green spaces.

## Main Features
### Main Functionalities
It is intended for the responsible administrators and managers who handle everything from resource allocation to task management. However, there is also a user portal aimed at receiving feedback. It also provides functionalities for data analysis.

- #### Registration and maintenance of collaborators, jobs and skills
Users can enter and update comprehensive details about collaborators such as skills and job. By consolidating this data, it facilitates effective assignment of tasks and allocation of roles based on collaborator skills, maximizing the utilization of the team's skills and talents.

- #### Multidisciplinary Team Management
This application provides tools for the formation and management of multidisciplinary teams, considering technical skills, knowledge in botany, landscaping, and resource management. Using advanced algorithms, the software facilitates efficient allocation of teams, considering variables such as size, complexity, and specific needs of each area.

- #### Vehicle registration and maintenance
An integrated feature allows for the management of the fleet of vehicles and equipment, ensuring proper maintenance, availability, and efficient utilization. Like this, users can effortlessly register and manage vehicles vital to green space operations. This feature allows you to track vehicle details such as model, registration information, and maintenance schedules. Additionally, it organizes maintenance checks and manages vehicle-related tasks, ensuring vehicles are well maintained and minimizing downtime.

- #### Production of Statistical Indicators
The solution generates relevant statistical indicators to measure the performance of green space management activities, providing valuable insights for strategic decision-making.
Therefore, it provides tools for analyzing the costs of water consumption in specific green spaces, this functionality being fundamental as it helps green space managers to identify areas of high consumption and possible inefficiencies and therefore reduce costs.
In addition to also predicting the expenses and needs that new green spaces would involve and thus evaluating whether it becomes viable.
It also provides an analysis of equipment use by observing factors such as maintenance and usage rates, which are essential for optimizing usage strategies or even replacing certain equipment.
Finally, it also collects data through the user portal on the use of the parks, providing information on the age, frequency and recommendation of visitors, essential for customizing strategies to better attract visitors to the park.

- #### Efficient Route Selection
It employs advanced algorithms to calculate the most efficient routes for installing pipes in green spaces. This feature considers factors such as terrain, distance and water supply needs, ensuring optimal distribution of water resources. Through efficient route planning, it supports the development of efficient irrigation systems, adapted to the needs of green spaces, reducing waste of resources.
It also places signs to evacuate in case of emergency to meeting points providing the quickest routes from any area of the park.

- #### Task management
From essential tools such as the Agenda and the To-Do List we have functionalities such as adding tasks, each of which is associated with its respective green space and its manager, to which the assignment of teams and vehicles is allowed, also the possibility of postponing, canceling and terminating each one of these, and also for each user to consult those for which they are responsible.

### Benefits
* Improvement in urban quality of life through efficient maintenance of green spaces.
Optimization of resources and reduction of operational costs.
* Contribution to environmental sustainability through intelligent management of natural resources.
* Facilitation of compliance with legal requirements related to the management of green spaces in urban contexts.
* Efficient task management that allows for better organization of everything that needs to be done, thus saving time.


**The application is an essential tool for organizations responsible for managing green spaces, providing an integrated and effective approach to addressing the challenges of urban growth and ensuring the preservation and enhancement of these important natural resources.**

---
# Features

**1. Register Skills of a Collaborator | Human Resources Manager**

> The feature allows the HRM to register the skills that a collaborator may have.
>
> **Instructions** :
> 
> - Enable the HRM role.
> - View/add/remove/edit skills in the Skill Registation Section.
> - Confirm the entered data.
> - After confirmation, the system provides a success message.

**2. Register a Job | Human Resources Manager**

> The feature allows the HRM to register a job that a collaborator may have.
> 
> **Instructions** : 
>
> - Enable the HRM role.
> - Choose the option to add a new job
> - Enter the name of the job.
> - Verify the entered information.
> - After submission, the system will confirm the successful addition of the job.

**3. Register collaborator with job and fundamental characteristics | Human Resources Manager**

> The feature allows the HRM to register a collaborator with essential details and assign them a specific job.
> 
> **Instructions** :
> 
> - Enable the HRM role.
> - Initiate a request for new collaborator registration.
> - Input the necessary information, including name, birthday, admission date, address, phone number, email, ID doc type and ID number.
> - Choose the suitable job for the collaborator from the provided list.
> - Verify the entered data and job selection.
> - Upon confirmation, the system will display a success message.

**4. Assign Skills | Human Resources Manager**

> The feature allows the HRM to assign one or more skills to a collaborator.
> 
> **Instructions** :
> 
> - Enable the HRM role.
> - Navigate to the Skills Assignment page within the application.
> - Pick the collaborator you wish to assign skill(s) to.
> - Select the appropriate skill(s) from the available list.
> - Confirm your selection to save the assignment.
> - After confirmation, the system provides a success message.

**5. Generate a team proposal automatically | Human Resources Manager**

> The feature allows the HRM to automatically generate a proposal for a team based on specific criteria.
> 
> **Instructions** :
> 
> - Enable the HRM role.
> - Access the Team Proposal Generator tool within the application.
> - Define the team size, along with the necessary set of skills.
> - Click the button to generate a team proposal.
> - Edit or confirm the team generated.
> - After confirmation, the system provides a success message.

**6. Register a vehicle | Vehicle and Equipment Fleet Manager**

> The feature allows the FM to register a new vehicle along with its details.
> 
> **Instructions** :
> 
> - Enable the VFM role.
> - Access the Vehicle Registration section.
> - Input the necessary vehicle details, including brand, model, tare, gross weight, current km, register date, acquisition date, maintenance check up frequency, plate number.
> - Select the available types from the types list.
> - Verify the entered data and type selection.
> - After confirmation, the system provides a success message.

**7. Register Vehicle's Check-up | Vehicle and Equipment Fleet Manager**

> The feature allows the FM to register a check-up for a vehicle.
> 
> **Instructions** :
> 
> - Enable the VFM role.
> - Navigate to the Vehicle Check-Up Registration page.
> - Choose the vehicle for which you wish to register a check-up.
> - Input the details of the check-up, including current kms, ID and check-up date.
> - Verify the entered data.
> - After confirmation, the system provides a success message.

**8. List the vehicles needing the check-up | Vehicle and Equipment Fleet Manager**

> The feature allows the FM to view a list of vehicles that require a check-up.
> 
> **Instructions** :
> 
> - Enable the VFM role.
> - Access the Check-Up Status page.
> - Review the list of vehicles scheduled for a check-up, along with their respective details.
> - The system provides a success message.

**9. Know the exact costs referring to water consumption | Green Spaces Manager**

> This feature allows the GSM to request a statistical analysis of water consumption costs.
>
> **Instructions** :
>
> - Enable the GSM role.
> - Access the statistical analysis of water consumption costs page.
> - Input the necessary information
> - Verify the entered information.
> - After submission, the system will display the analysis outcome, that include a bar plot, average costs, and statistical indicators..

**10. Know in a pie chart which pieceS of equipment are used in each day | Green Spaces Manager**

> The feature allows the GSM to analyze equipment usage.
>
> **Instructions** :
>
> - Enable the GSM role.
> - Access the analysing equipment usage page.
> - Upload the file "EquipmentUsed.csv"
> - After upload, the system will display the analysis result in the form of a pie chart.

**11. Collect data from the user portal | Green Spaces Manager**

> The feature allows the GSM to collect data from the user portal regarding the use of the park.
>
> **Instructions** :
>
> - Enable the GSM role.
> - Access the user portal page.
> - Upload the file "Inquiry.csv"
> - After upload, the system will display the analysis result about the use of the park.

**12. Import a .csv file containing routes for pipe installation | Green Spaces Manager**

> The feature allows the GSM to to import a .csv file containing data about possible routes for laying pipes between water points.
>
> **Instructions** :
>
> - Enable the GSM role.
> - Access the pipe installation routes page.
> - Upload the csv file.
> - After upload, the system will process a graph representing the imported route data.

**13. Know the routes to be opened, with minimum cost | Green Spaces Manager**

> The feature allows the GSM to apply an algorithm that determines the graph with minimum accumulated cost.
>
> **Instructions** :
>
> - Enable the GSM role.
> - Access the pipe installation routes page. 
> - The system will display a graph representing the imported route data.
> - The system will display a graph with routes with minimum cost.

**14. Tests to observe asymptotic runtime behavior | Software Quality Assessment Team Manager**

> The feature allows the QAM to run tests for inputs of variable size, to observe the asymptotic behavior of the execution time
>
> **Instructions** :
>
> - Enable the QAM role.
> - Access the runtime tests page.
> - The system will display a graph representing the execution time as a function of the input time.

**15. Forecast of water consumption costs in the park | Green Spaces Manager**

> The feature allows GSM to predict the water consumption costs of new parks based on hectares.
>
> **Instructions**:
>
> - Enable the GSM function.
> - Access the water cost forecast page.
> - Upload the "Area.csv" file
> - After uploading, the system will display the result of the analysis on the park's possible costs.

**16. The best line that fits the data | Green Spaces Manager**

> The feature allows GSM to determine the best line that fits the algorithms' runtime data.
>
> **Instructions**:
>
> - Enable the GSM function.
> - Access the runtime analysis page.
> - Upload the file "solution us14.csv"
> - After uploading, the system will display the best line that fits the data.

**17. Faster routes from the signage to the Assembly Point | Green Spaces Manager**

> The feature allows GSM to place signs at various points in the park and provide the shortest route to the assembly point for each one.
>
> **Instructions**:
>
> - Enable the GSM function.
> - Access the evacuation paths page for an exit.
> - Upload the file with the signs and the file with the distances between the signs.
> - After uploading, the system will display the shortest paths to each signage point.

**18. Fastest routes from signage to one of the Assembly Points | Green Spaces Manager**

> The feature allows GSM to show the shortest route from various points in the park to one of the assembly points.
>
> **Instructions**:
>
> - Enable the GSM function.
> - Access the evacuation paths page for an exit.
> - Upload the file with the signs and the file with the distances between the signs.
> - After uploading, the system will display the shortest paths for each signaling point to the nearest Assembly point.

**20. Register a Green Space | Green Spaces Manager**

> The feature allows GSM to register a new green space along with its data.
>
> **Instructions**:
>
> - Enable the GSM function.
> - Access the Register Green Spaces section.
> - Enter the necessary data for the green space, including name, address, type and area.
> - Select the available types from the types list.
> - Check the entered data and select the type.
> - After confirmation, the system provides a success message.

**21. Add a new entry to the To-Do List | Green Spaces Manager**

> The feature allows GSM to add a new entry to the To-Do List.
>
> **Instructions**:
>
> - Enable the GSM function.
> - Access the Add Entries section in the To-Do List.
> - Enter the necessary data such as title, description, degree of urgency, expected duration and type.
> - Select the green space to be associated with the task from the list of green spaces.
> - Check the entered data and the selected green space.
> - After confirmation, the system provides a success message.

**22. Add a entry in the Agenda | Green Spaces Manager**

> The feature allows GSM to add a new entry to the Agenda.
>
> **Instructions**:
>
> - Enable the GSM function.
> - Access the Add Agenda Entries section.
> - Enter the start date of the task.
> - Select the task to be associated with the to-do list entry.
> - Check the date entered and the task selected.
> - After confirmation, the system provides a success message.

**23. Assign a Team to an entry in the Agenda | Green Spaces Manager**

> The feature allows GSM to assign a team to entries in the Agenda.
>
> **Instructions**:
>
> - Enable the GSM function.
> - Access the Assign Team section.
> - Select the Agenda entry.
> - Select the team from the team list
> - Check selected data.
> - After confirmation, the system provides a success message.

**24. Postpone an entry in the Agenda | Green Spaces Manager**

> The feature allows GSM to postpone an entry in the Agenda.
>
> **Instructions**:
>
> - Enable the GSM function.
> - Access the Postpone Entries section.
> - Select the Agenda entry.
> - Enter the new start date for the task.
> - Check the date and selected item.
> - After confirmation, the system provides a success message.

**25. Cancel an entry in the Agenda | Green Spaces Manager**

> The feature allows GSM to cancel an entry in the Agenda.
>
> **Instructions**:
>
> - Enable the GSM function.
> - Access the Cancel Entries section.
> - Select the Agenda entry.
> - Check the selected entry.
> - After confirmation, the system provides a success message.

**26. Assign Vehicles to an entry in the Agenda | Green Spaces Manager**

> The feature allows GSM to assign vehicles to entries in the Agenda.
>
> **Instructions**:
>
> - Enable the GSM function.
> - Access the Assign Vehicles section.
> - Select the Agenda entry.
> - Select vehicles from the vehicle list
> - Check selected data.
> - After confirmation, the system provides a success message.

**27. List of green spaces managed by me | Green Spaces Manager**

> The feature allows GSM to consult the list of green spaces it manages.
>
> **Instructions**:
>
> - Enable the GSM function.
> - Access the Consult managed green spaces section.
> - The system shows the list of green spaces that the user manages.

**28. Consult the Task Between Two Dates | Collaborator**

> The functionality allows the Collaborator to consult the entries assigned to it over a period of time.
>
> **Instructions**:
>
> - Enable the Collaborator function.
> - Access the section Consult assigned entries.
>- Enter the start date and end date
> - Check the date and selected item.
> - The system shows the list of green spaces that have been allocated to the user.

**29. Record the completion of a task | Collaborator**

> The functionality allows the Collaborator to report it as completed.
>
> **Instructions**:
>
> - Enable the Collaborator function.
> - Access the Mark as completed section.
> - Select the Agenda entry.
> - Check the selected entry.
> - After confirmation, the system provides a success message.

## Troubleshooting

### Problem: Application Not Starting
**Possible Causes:**
- Missing dependencies
- Incorrect installation

**Solution:**
- Verify that all required dependencies are installed.
- Check the installation guide to ensure all steps were followed correctly.
- Restart your computer and try to launch the application again.

### Problem: Unable to Register a Collaborator
**Possible Causes:**
- Insufficient permissions
- Missing required fields

**Solution:**
- Ensure you are logged in with the HRM role.
- Verify that all required fields are filled out.
- Check your internet connection if you are working on a networked environment.

### Problem: Data Not Displaying in Graphs
**Possible Causes:**
- Incorrect file format
- Data file not uploaded properly

**Solution:**
- Verify the file format is correct (.csv).
- Ensure the data is structured as required.
- Re-upload the data file and try again.

### Problem: Vehicle Maintenance Data Not Saving
**Possible Causes:**
- Database connection issues
- Incorrect input data

**Solution:**
- Check the database connection and ensure it is active.
- Verify that all input data is correct and try saving again.

### Problem: Inaccurate Statistical Analysis
**Possible Causes:**
- Outdated data
- Incorrect parameters set

**Solution:**
- Update the data to the latest available.
- Review the parameters set for the analysis and correct them as needed.

---

## Frequently Asked Questions (FAQ)

### Q1: How do I reset my password?
**A1:** Go to the login page, click on "Forgot Password," and follow the instructions to reset your password.

### Q2: How can I add a new green space?
**A2:** Ensure you have the GSM role enabled, then navigate to the "Register Green Spaces" section, fill in the necessary details, and confirm the registration.

### Q3: Can I assign multiple tasks to a single collaborator?
**A3:** Yes, you can assign multiple tasks to a collaborator through the task management section.

### Q4: How do I generate a team proposal automatically?
**A4:** Enable the HRM role, access the Team Proposal Generator tool, define the criteria, and click the button to generate a proposal.

### Q5: What should I do if the system crashes?
**A5:** Restart the application and check for any updates. If the problem persists, contact technical support.

### Q6: How can I view the vehicles that need maintenance?
**A6:** Enable the VFM role and navigate to the Check-Up Status page to view the list of vehicles requiring maintenance.

### Q7: How do I collect data from the user portal?
**A7:** Enable the GSM role, access the user portal page, upload the "Inquiry.csv" file, and view the analysis results.

### Q8: How can I find the most efficient route for pipe installation?
**A8:** Enable the GSM role, access the pipe installation routes page, upload the .csv file with route data, and let the system calculate the optimal routes.

### Q9: How do I postpone a task?
**A9:** Enable the GSM role, navigate to the Postpone Entries section, select the task, enter the new start date, and confirm.

---


