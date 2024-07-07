# ATA Backend assignment

### Prerequisite
- Install Java 17
- Install Maven 3
- Install IDE (IntelliJ)

### How to run application
1. Open Project on IntelliJ `File > Open > Select ./ata-it-backend directory`
2. Resolve module by `File > New > Module from existing sources > Select pom.xml`
3. It should resolve dependencies automatically by check bottom right progress bar, 
   - if it does not then you click Maven icon on right side menu bar and click reload icon under Maven title
4. Right click on `AtaItBackendApplication.java` and choose `Run AtaItBackendApplication.main()`
5. After application start successfully, should display `Started AtaItBackendApplication` in console
6. You can try to access by http://localhost:8080/job_data?salary[e]=125000&gender=male&sort=job_title&sort_type=DESC&fields=job_title,gender,salary

### Swagger
- After Start application, you can access http://localhost:8080/swagger-ui.html
- Documentation [springdoc-openapi](https://springdoc.org/) 

### Available Test data
list job data via API GET request
1. Filter by one or more fields/attributes 
   - e.g. /job_data?salary[gte]=120000
   - Filter able column: job_title, salary, gender
   - Available salary values: salary[e], salary[gte], salary[gt], salary[lt], salary[lte]
2. Filter by a sparse fields/attributes 
   - e.g. /job_data?fields=job_title,gender,salary
   - Available fields values: id, job_title, salary, employer, location, gender
3. Sort by one or more fields/attributes 
   - e.g. /job_data?sort=job_title&sort_type=DESC
   - Available sort_type values: DESC, ASC

