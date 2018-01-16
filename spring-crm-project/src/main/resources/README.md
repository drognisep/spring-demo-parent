## Important note

I include my connection information as a separate dependency (locally available only) so I don't expose my home DB server
credentials to the wider githubberverse. This could be overridden by removing the dependency in the pom and directly including
a `hibernate.cfg.xml` file here.

My hibernate config (sans connection credentials). Replace host, username, and password with your own:

```
<!DOCTYPE hibernate-configuration PUBLIC
	"-//Hibernate/Hibernate Configuration DTD 3.0//EN"
	"http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">

<hibernate-configuration>
	<session-factory>
		<property name="connection.driver_class">com.mysql.jdbc.Driver</property>
		<property name="connection.url">jdbc:mysql://YOUR DB HOST:3306/crm_project?useSSL=false</property>
		<property name="connection.username">YOUR USERNAME HERE</property>
		<property name="connection.password">YOUR PASSWORD HERE</property>

		<!-- I upped the connection pool size for scalability's sake, this could be `1` for local testing -->
		<property name="connection.pool_size">5</property>
		<property name="dialect">org.hibernate.dialect.MySQLDialect</property>
		<property name="show_sql">true</property>
		<property name="current_session_context_class">thread</property>
	</session-factory>
</hibernate-configuration>
```
