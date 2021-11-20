create table roles(role_id INT GENERATED ALWAYS AS IDENTITY,
 role_name VARCHAR(255) NOT NULL,
                   PRIMARY KEY(role_id)
);