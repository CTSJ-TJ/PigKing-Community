insert into mypost values(null,"学习新思想","# 在这里写下一篇帖子 ##
伟哥要去学习了",1001,curdate(),0,0,0)
select * from mypost where status=1 order by posttime DESC;

select * from mypost  where userid=1 order by posttime DESC;

update mypost set postlikes=postlikes+1 where postid=60
update mypost set collections=collections+1 where postid=60
update mypost set status =0 where postid=74

select * from mypost where status=0 and (posttitle like "%伟哥%" or postpassege like "%伟哥%") order by posttime DESC;

insert into myuser values(null,"鹏哥","123456",null,null,curdate(),1)

select * from myuser;

select * from myuser where username like "%哥%" or userid="ge"

insert into  admin values(null,"朱王","123456",null,null,1)

select * from admin;

insert into friends values(null,2,"猪王",4,"刘总",1)
select * from friends ;
select * from friends where friendxid=1002 or friendyid=1002;

select * from friends where (friendxid=1 and friendyid=2) or (friendxid=2 and friendyid=1);


insert into messages values(null,"你在吗",1002,"猪王",1001,"伟哥",now(),1)
insert into messages values(null,"我不在！",1001,"伟哥",1002,"猪王",now(),1)
insert into messages values(null,"不会在骂伟哥吧",1001,"伟哥",1002,"猪王",now(),1)
insert into messages values(null,"你在吗",1002,"猪王",1003,"小胖子",now(),1)
insert into messages values(null,"我在吃饭！",1003,"小胖子",1002,"猪王",now(),1)
select * from messages where (senderid=1002 and receiverid=1001) or (senderid=1001 and receiverid=1002) order by createtime ;
select * from messages order by createtime ;
insert into messages values(null,"向着伟哥学习！！！",1002,"猪王",1001,null,now(),1)

insert into clickcollect values(null,1,69,1,0,curdate(),null)
select * from clickcollect;

select * from clickcollect where userid=1 and postid=69

update clickcollect set clickstatus= clickstatus+1 ,clicktime=curdate() where userid=1 and postid=76
update clickcollect set collectstatus=collectstatus+1 ,collecttime=curdate() where userid=1 and postid=76