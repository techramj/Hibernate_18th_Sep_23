# one to one Mapping
  Employee has an address
  Employee has an passport
  

# Tables and objects
	create sequence emp_address start with 1 increment by  1;
	create sequence emp_seq start with 1000 increment by  1;
	
	create table Address (
       id number(19,0) not null,
        city varchar2(255 char),
        pincode varchar2(255 char),
        primary key (id)
    );
    
     create table Employee (
       id number(10,0) not null,
        name varchar2(255 char),
        salary double precision,
        address_id number(19,0),
        primary key (id)
    );
	
	alter table Employee 
	       add constraint FK759vmxo1jn0ql3orqinrieynp 
	       foreign key (address_id) 
	       references Address;
	       


# Insert data

	