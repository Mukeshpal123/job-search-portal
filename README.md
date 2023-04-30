<h1 align="center"> 👤Job Search Portal🏡</h1>

>### Framework Used 
 * ![SpringBoot](https://img.shields.io/badge/SpringBoot-White?style=flat&logoColor=Blue)

>### Language Used
* ![Java](https://img.shields.io/badge/Java-White?style=flat&logoColor=Blue)
>## Data flow
```
In this project haveing four layers-
```
* **Controller** - The controller layer handles the HTTP requests, translates the JSON parameter to object, and authenticates the request and transfer it to the business (service) layer. In short, it consists of views i.e., frontend part.
* **Service** -The business layer handles all the business logic. It consists of service classes and uses services provided by data access layers.
* **Repository** - This layer mainatains the h2-database thing on which CRUD operations are performed
* **Model** - This layer consists basically the class level things- the various classes required for the project and these classes consists the attributes to be stored.

>## Data Structure used in my project
This document outlines the steps to create a Job model -

`Job Model will have`
* Id
* Title
* description
* location
* salary
* companyName
* employerName
* jobType
* appliedDate

>## Project Summary

```
The above project implements a UniversityEvent Management project in which the endpoints provided are:-
```

## Basic endpoint: 
* crud operations using inbuilt @CrudRepo methods,
* custom get methods using your own custom finders (No implementations, correct queries should be fired based on method names)
* write operations (update and delete) using Custom queries (using @Query) 

# For Querying use these:
* use Crud Repository
* Custom Finder
* Use custom Query 

```
Also we have added  spring boot validation and custom validation
```
*  JobType(datatype of variable jobType should be Enum and not string. Enum should support jobType names  IT, HR , Sales, Marketing, etc.). 
