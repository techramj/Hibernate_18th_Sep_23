# step 1: download maven
    https://dlcdn.apache.org/maven/maven-3/3.9.4/binaries/apache-maven-3.9.4-bin.zip
    unzip in c drive



# step 2: set the path in the enviroment variable 
	go to edit system environment variable .

	create new system variable => M2_HOME
	and value will be the path of Maven repo/folder (parent of bin)


	M2_HOME = C:\apache-maven-3.8.4
	JAVA_HOME = path of parent of bin folder of java


	Test setup is correct: execute below command in cmd
	mvn -version



# step 3: create the maven project and modify the pom.xml file
	<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
			<modelVersion>4.0.0</modelVersion>
			<groupId>com.seed</groupId>
			<artifactId>demo1</artifactId>
			<version>0.0.1-SNAPSHOT</version>
			<name>first-demo</name>

			<dependencies>
				<!-- https://mvnrepository.com/artifact/org.hibernate/hibernate-core -->
				<dependency>
					<groupId>org.hibernate</groupId>
					<artifactId>hibernate-core</artifactId>
					<version>5.6.15.Final</version>
				</dependency>

				<!-- https://mvnrepository.com/artifact/com.oracle/ojdbc14 -->
				<dependency>
					<groupId>com.oracle.database.jdbc</groupId>
					<artifactId>ojdbc8</artifactId>
					<version>21.1.0.0</version>
				</dependency>

				<dependency>
					<groupId>mysql</groupId>
					<artifactId>mysql-connector-java</artifactId>
					<version>8.0.27</version>
				</dependency>

			</dependencies>

			<build>
				<sourceDirectory>src/main/java</sourceDirectory>
				<plugins>
					<plugin>
						<artifactId>maven-compiler-plugin</artifactId>
						<version>3.5.1</version>
						<configuration>
							<source>1.8</source>
							<target>1.8</target>
						</configuration>
					</plugin>
				</plugins>
			</build>

		</project>

# step 3.5
	right click to the pom.xml
	select maven
	then click on update project

# step 4: 
 ## xml: hibernate.cfg.xml
	<!DOCTYPE hibernate-configuration PUBLIC
			"-//Hibernate/Hibernate Configuration DTD 3.0//EN"
			"http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
	<hibernate-configuration>
		<session-factory>
			<!-- JDBC Database connection settings -->
			<property name="connection.driver_class">oracle.jdbc.driver.OracleDriver</property>
			<property name="connection.url">jdbc:oracle:thin:@localhost:1521/ORCLPDB</property>
			<property name="connection.username">*****</property>
			<property name="connection.password">******</property>
			<property name="dialect">org.hibernate.dialect.OracleDialect</property>
			<property name="show_sql">true</property>
			<property name="hbm2ddl.auto">update</property>
			
			<mapping class="com.easylearning.entity.Employee"/>
		</session-factory>
	</hibernate-configuration>

  ## annotation: hibernate.properties	
	hibernate.connection.url=jdbc:oracle:thin:@localhost:1521/ORCLPDB
	hibernate.connection.username=hr
	hibernate.connection.password=hr
	hibernate.connection.dialect=org.hibernate.dialect.OracleDialect
	hibernate.show_sql=true
	hibernate.hbm2ddl.auto=update
	hibernate.format_sql=true


# step 5: create the entity class
	@Entity
	@Table(name = "emp_01")
	public class Employee {

		@Id
		private Integer id;
		
		@Column(name="first_name")
		private String name;
		
		private Double salary;
		
	}



# step 6: create the session factory object
 ## xml
	   Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		sessionFactory = cfg.buildSessionFactory();

 ## Annotation
       Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Employee.class);
		sessionFactory = cfg.buildSessionFactory();


ORM:

	Java							SQL
	object							table: emp
	Employee e = new Employee()		id	first_name	salary
	 id
	 name
	 salary

	 .save(e);  => insert into emp (id,name,salary) values (?,?,?)
	               
				
	 	
	

client                      db
     service ->  dao -->



# Properties of session factory
 ## property name="hbm2ddl.auto"
 ### validate: 
 	validate that the schema matches, make no changes to the schema of the database, you probably want this for production.

 ### update: 
 	update the schema to reflect the entities being persisted

 ### create: 
	creates the schema necessary for your entities, destroying any previous data.
 ### create-drop: 
	create the schema as in create above, but also drop the schema at the end of the session. This is great in early development or for testing.




#

#

#

#

#

#

#

#

#

#

#

# git command   
	git branch -M main
	git remote add origin https://github.com/techramj/Hibernate_18th_Sep_23.git
	git push -u origin main


Hibernate

   JPA
     TOPLINK
	 HIbernate