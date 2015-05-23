/*
insert into USERS(id, USERNAME, PASSWORD) values (1, 'To Kill a MockingBird', 'PW')
insert into USERS(id, USERNAME, PASSWORD) values (2, 'James Bond', 'PW')
insert into USERS(id, USERNAME, PASSWORD) values (3, 'Intro to JEE7', 'PW')
*/
delete from Quiz
delete from answer
delete from question
delete from player
insert into Quiz(id, QUIZ_TYPE, QUIZNAME) values (1, 'SCORED', 'Sample Quiz')
insert into Quiz(id, QUIZ_TYPE, QUIZNAME) values (2, 'SCORED', 'History Quiz')
insert into Player(id, PLAYER_NAME) values (1, 'Player 1')
insert into Player(id, PLAYER_NAME) values (2, 'Player 2')
insert into Player(id, PLAYER_NAME) values (3, 'Player 3')
