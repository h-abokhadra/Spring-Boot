
INSERT INTO thread(title, body)
VALUES ('First Thread: What is your favorite programming language?',
'With time old programming languages become obsolete while new programming
				languages are launched, but they never gain traction. A common
				question amongst beginners (and coders alike) is the programming
				language they should invest learning in, that is in demand, stable
				outlook, and plenty of jobs. Each programming language is designed
				for a specific purpose and has its relative merits and demerits.
				Also, the answer to the most useful programming language to learn is
				subjective and depends on your familiarity with coding.
				Irrespective, the following 3 parameters are essential to narrow a
				language a choice.');








INSERT INTO sec_user(email, encryptedPassword, enabled)
VALUES ('abokhadr@sheridancollege.ca','$2a$10$1ltibqiyyBJMJQ4hqM7f0OusP6np/IHshkYc4TjedwHnwwNChQZCy', 1 );

INSERT INTO sec_user(email, encryptedPassword, enabled)
VALUES ('student@sheridancollege.ca','$2a$10$PrI5Gk9L.tSZiw9FXhTS8O8Mz9E97k2FZbFvGFFa5siTUIl.TCrFu', 1 );

INSERT INTO sec_role (roleName)
VALUES ('ROLE_ADMIN');

INSERT INTO sec_role (roleName)
VALUES ('ROLE_USER');

INSERT INTO user_role (userId, roleId)
VALUES (1, 1);

INSERT INTO user_role (userId, roleId)
VALUES (1, 2);

INSERT INTO user_role (userId, roleId)
VALUES (2, 2);
