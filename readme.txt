SPEC 1
SPEC 2

BV = Bean Validation

BV is an old but good standard.
BV is an API set of interfaces, default implementation is provided by Hibernate.

BV uses the same concepts as JPA, Hibernate, JDBC in terms of :
- Validator Factory vs SessionFactory vs EntityManagerFactory vs DataSource
- Validator vs Session vs Entity Manager vs Connection
- usage of interfaces instead of actual classes

BV can be :
- used in standalone applications or web based applications
- integrated in various bean containers
- used for data model validation in context of constructor or method invocations

In standalone applications the developer is responsible to manage API objects directly or through specific bean containers mechanisms
Java Enterprise Edition standard clarifies how BV integrates with other technologies such as EJB / JPA / REST

BV offers :
- out of the box annotations for defining certain well defined validation rules.
- a mechanism for defining custom annotations targeted at defining custom validation rules.
- support for linking a validation rule with a specific text message ( see Expression Language dependency ).
- a mechanism that allows validation of a certain data model annotated with validation annotations

This mechanism ( Validator ) will report all violated constraints over a to be validated data model.
In standalone applications the developer is responsible of addressing the violated validation rules.

In case of REST / JPA / EJB methods with @Valid marked arguments JEE specs clarify that BV will be automatically used
by the JEE container.