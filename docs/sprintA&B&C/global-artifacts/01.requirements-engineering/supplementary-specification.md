# Supplementary Specification (FURPS+)

## Functionality

_Specifies functionalities that:  
&nbsp; &nbsp; (i) are common across several US/UC;  
&nbsp; &nbsp; (ii) are not related to US/UC, namely: Audit, Reporting and Security._

* Ensure that all data recording and updating operations adhere to business rules validation.
* All users must be authenticated with a password of seven alphanumeric characters, including three capital letters and two digits.

## Usability

_Evaluates the user interface. It has several subcategories,
among them: error prevention; interface aesthetics and design; help and
documentation; consistency and standards._

* The application documentation must be in English language.
* Clear and concise error messages are essential for aiding users in understanding and resolving issues efficiently.

## Reliability

_Refers to the integrity, compliance and interoperability of the software. The requirements to be considered are: frequency and severity of failure, possibility of recovery, possibility of prediction, accuracy, average time between failures._

*  Rigorous testing of all modules is imperative to minimize the occurrence of software bugs.

## Performance

_Evaluates the performance requirements of the software, namely: response time, start-up time, recovery time, memory consumption, CPU usage, load capacity and application availability._

* The application must possess the capability to efficiently manage substantial volumes of data and accommodate a large user base.
* The system needs to effectively handle multiple concurrent users without experiencing any degradation in performance.

## Supportability

_The supportability requirements gathers several characteristics, such as:
testability, adaptability, maintainability, compatibility,
configurability, installability, scalability and more._

*  The development team must implement unit tests for all methods, except for methods that implement Input/Output operations.
*  The unit tests should be implemented using the JUnit 5 framework.
*  The JaCoCo plugin should be used to generate the coverage report.
*  The class structure must be designed to allow easy maintenance and the addition of new features, following the best OO practices.


### Design Constraints

_Specifies or constraints the system design process. Examples may include: programming languages, software process, mandatory standards/patterns, use of development tools, class library, etc._

*  The application must be developed in Java language using the IntelliJ IDE or NetBeans.
*  The application’s graphical interface is to be developed in JavaFX 11.
*  During the system development, the team must adopt best practices for identifying requirements, and for OO software analysis and design.
*  The development team must adopt recognized coding standards (e.g., CamelCase).
*  The team must use Javadoc to generate useful documentation for Java code.


### Implementation Constraints

_Specifies or constraints the code or construction of a system such
such as: mandatory standards/patterns, implementation languages,
database integrity, resource limits, operating system._

*  The application must be developed in Java language.

### Interface Constraints

_Specifies or constraints the features inherent to the interaction of the
system being developed with other external systems._

* All the images/figures produced during the software development process should be recorded in SVG format.
* The application should use object serialization to ensure data persistence between two runs of the application.

### Physical Constraints

_Specifies a limitation or physical requirement regarding the hardware used to house the system, as for example: material, shape, size or weight._

* n/a