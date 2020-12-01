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
				language a choice.'),
				
				('Second Thread: Share the link
				of a project you are proud of',
				'As the title mentions, lets benefit from this forum by sharing our knowledge and most projects that we are proud of. No matter what is your programming level, please feel free to participate!  '),
				
				('Third Thread: What courses are you taking at the moment?',
				'As Programmers, we do not stop learning! It is going to be great to share the courses you are taking or planning to take in the near future.')
				;

				
INSERT INTO comment(userName, subject, commentDateTime, threadId)
VALUES('HodazZ', 'Java is my favorite programming language. Java has a rich API, and you can do a lot more with Java including graphics, sound and most likely writing small games like Tic Tac Toe, etc.',
'2020-11-28 07:55', 1);

INSERT INTO comment(userName, subject, commentDateTime, threadId)
VALUES('HodazZ', 'I have plenty of projects that I am proud of, feel free to ask for my GitHub account if you are interested ^^',
'2020-11-28 08:55', 2);

INSERT INTO comment(userName, subject, commentDateTime, threadId)
VALUES('HodazZ', 'I am currrently starting to learn Data Structure and Algorithms. The data structure and algorithm provide a set of techniques to the programmer for handling the data efficiently. The programmer should understand the core concepts of data handling as well.',
'2020-11-28 09:55', 3);

/*password is: 1234 */
INSERT INTO sec_user(email, encryptedPassword, enabled)
VALUES ('abokhadr@sheridancollege.ca', '$2a$10$1ltibqiyyBJMJQ4hqM7f0OusP6np/IHshkYc4TjedwHnwwNChQZCy', 1 );


/*password is: 123 */
INSERT INTO sec_user(email, encryptedPassword, enabled)
VALUES ('student@sheridancollege.ca', '$2a$10$PrI5Gk9L.tSZiw9FXhTS8O8Mz9E97k2FZbFvGFFa5siTUIl.TCrFu', 1 );

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
