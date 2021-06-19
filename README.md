# Harry-Kart
## Description
Harry-Kart in a special kind of horse racing.

The horses participating have a base speed, they can run with that speed indefinitely.
The track is a 1000 meters loop and is divided in lanes, each horse runs on a lane and every lane has the same length.   
The horses run the first loop at their base speed but at the end of each loop they find a power-up or power-down.

The power-ups/downs are numbers, negative or positive, representing how much the horse speeds up or slows down.

This project is to compute the top 3 rankings.

## Example 1

### Input

**Number of loops:** 3

**Start List:**

| Lane | Horse name     | Base speed |
|------|----------------|------------|
| 1    | TIMETOBELUCKY  | 10         |
| 2    | CARGO DOOR     | 10         |
| 3    | HERCULES BOKO  | 10         |
| 4    | WAIKIKI SILVIO | 10         |

**Power-Ups/Downs:**

| Loop | Lane 1 | Lane 2 | Lane 3 | Lane 4 |
|------|--------|--------|--------|--------|
| 1    | 1      | 1      | 0      | -2     |
| 2    | 1      | -1     | 2      | -2     |

### Result

```json
{
   "ranking": [
      {"position": 1, "horse": "TIMETOBELUCKY"},
      {"position": 2, "horse": "HERCULES BOKO"},
      {"position": 3, "horse": "CARGO DOOR"}
   ]
}
```

## Architechure

 ![High level architechure](https://github.com/wkk91193/harry-kart/blob/master/images/SolutionArchitechure.jpeg) 
 
 The API gateway will recieve requests from the any client facing Application and direct them to their respective API endpoint where it will processed.
 

 ## Considerations
 
 1. Code Quality : Ensured that the code is readable and obeys the SOLID, KISS principals.
 
 2. Well tested : Using integration tests, ensured that the solution achieves it's main objective and verified how it handles bad input.
 
 3. Maintainable : I have kept the functions as generic as possible to be able to be reused, as much as possible. eg: read generic inputs and write generic output.
 
 
## Additional:

1. API Gateway: In order provide security to the API considering overuse and abuse and for more control over monitoring the usage.This also comes with a developer portal experience  so that the developer can test the APIs on the browser prior integration.

2. CI/CD pipeline: Using Github actions all the changes I pushed to repository will be build and it's binaries willl deployed to the API directly cutting any manual work of publishing APIs and identifying problems early.

3. Logging/Monitoring: I have enabled the use log streaming and application insights to monitor all incoming requests, thereby easier for investigating any failures or anomalies.

4. API documentation: For a seemless integration experience, API documentation is valuable. I have enabled Swagger API documentation for the endpoint.


## API Gateway Developer Portal

https://harry-kart-apim.developer.azure-api.net

_Note: Click on Explore API button to see the list of the APIs_


## How to run locally.

0. Please copy and replace the application.properties file provide via email at src/resources/

1. Open the solution on IntelliJ

2. Build the project 

3. Run solution.

4. See developer portal to see the API documentation to  try out locally on a rest client.





