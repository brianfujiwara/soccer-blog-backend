
create table blog(
id int(6) unsigned auto_increment primary key,
title varchar(500) not null,
writer varchar(500) not null,
content varchar(5000) not null,
imgurl varchar(500) not null
);

SELECT * FROM restapi.blog;
insert into blog(title, writer, content, imgurl) values('Who Will Win This Year''s EPL Title Race?', 'Tom Jackson', 'jlksjflksdjflkdsjflsdjflksdjfkldsjlkfjsdlkfjsdlfslkdjflskjfl','https://media.gettyimages.com/photos/view-of-the-premier-league-winners-medals-prior-to-the-premier-league-picture-id955275702?s=2048x2048');
insert into blog(title, writer, content, imgurl) values('New European Champions', 'Dan Curry', 'lkdsjflkdsjflkdsjfkldsjflksdfjsdlkfjsdlfsldjflsdjfs','https://media.gettyimages.com/photos/players-of-bayern-munich-celebrate-at-the-end-of-the-uefa-champions-picture-id1228174934?s=2048x2048');
insert into blog(title, writer, content, imgurl) values('What is Frank Lampard''s Issue with Pulisic?', 'Samir Patel','sdfsdfdsfdsfdsfsdfuewoiruewoiur0ewoiuoiweruoiruowiuroweuroiweuoruwe','https://media.gettyimages.com/photos/august-2020-bavaria-munich-football-champions-league-knockout-rounds-picture-id1227966020?s=2048x2048');
insert into blog(title, writer, content, imgurl) values('Will USMNT Qualify for the 2022 World Cup?', 'Tom Jackson','fdsljflkjsdklfjsdklfjsdkljfkslfjklsdjflkjfkljslkfjkldsjflksdjkfljdsklfsjlkfjs','https://media.gettyimages.com/photos/gyasi-zardes-of-the-united-states-during-a-game-between-costa-rica-picture-id1206959711?s=2048x2048');
insert into blog(title, writer, content, imgurl) values('Barcelona Set to Rebuild', 'Abruey Coleman','dsfsdsfdjslkjweuroweuoriuweoruwporuopweurowurpouqporuqwporuwqeopruepooewuroewu','https://media.gettyimages.com/photos/lionel-messi-of-fc-barcelona-looks-dejected-during-the-uefa-champions-picture-id1266341683?s=2048x2048');
insert into blog(title, writer, content, imgurl) values('Sevilla and Their Europa League', 'Dan Curry','weoiruouzoicuouoizcuozixucpozucopuzoicuopzucpouaosduaopduapoudaopudoapudoaduoa','https://media.gettyimages.com/photos/julen-lopetegui-head-coach-of-sevilla-in-action-during-a-training-picture-id1267369308?s=2048x2048');


