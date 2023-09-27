


# on delete of address, address id will set as null
	  CREATE TABLE address(id NUMBER PRIMARY KEY,
	                     city VARCHAR2(20),
	                     pincode VARCHAR2(20)
	                     );
	                     
	                     
	 CREATE TABLE employee(ID NUMBER PRIMARY KEY,
	                      NAME VARCHAR2(20),
	                      salary NUMBER,
	                      address_id NUMBER 
	                      REFERENCES address(ID) ON DELETE SET NULL
	                      ); //manually
	                      
# on delete of address, employee row with address id should be delete

    CREATE TABLE address(id NUMBER PRIMARY KEY,
	                     city VARCHAR2(20),
	                     pincode VARCHAR2(20)
	                     );
	                     
	                     
	 CREATE TABLE employee(ID NUMBER PRIMARY KEY,
	                      NAME VARCHAR2(20),
	                      salary NUMBER,
	                      address_id NUMBER 
	                      REFERENCES address
	                      ); //hibernate
	                      
	  or               
	                     
	 CREATE TABLE employee(ID NUMBER PRIMARY KEY,
	                      NAME VARCHAR2(20),
	                      salary NUMBER,
	                      address_id NUMBER 
	                      REFERENCES address(ID) ON DELETE CASCADE
	                      );  // manually table should be create on db

# before deleting the address, must remove the entries from Employee table then create table manually
    
	 CREATE TABLE address(id NUMBER PRIMARY KEY,
	                     city VARCHAR2(20),
	                     pincode VARCHAR2(20)
	                     );                    
	 CREATE TABLE employee(ID NUMBER PRIMARY KEY,
	                      NAME VARCHAR2(20),
	                      salary NUMBER,
	                      address_id NUMBER 
	                      REFERENCES address(ID)
	                      ); 