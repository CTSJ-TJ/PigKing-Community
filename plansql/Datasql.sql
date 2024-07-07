insert into mypost values(null,"学习新思想","# 在这里写下一篇帖子 ##
伟哥要去学习了",1001,curdate(),0,0,0)
select * from mypost order by posttime DESC;

insert into myuser values(null,"鹏哥","123456",null,null,curdate(),1)

select * from myuser;

insert into  admin values(null,"朱王","123456",null,null,1)

select * from admin;

insert into friends values(null,1,"伟哥",3,"鹏哥",1)
select * from friends ;
select * from friends where friendxid=1002 or friendyid=1002;

insert into messages values(null,"你在吗",1002,"猪王",1001,"伟哥",now(),1)
insert into messages values(null,"我不在！",1001,"伟哥",1002,"猪王",now(),1)
insert into messages values(null,"不会在骂伟哥吧",1001,"伟哥",1002,"猪王",now(),1)
insert into messages values(null,"你在吗",1002,"猪王",1003,"小胖子",now(),1)
insert into messages values(null,"我在吃饭！",1003,"小胖子",1002,"猪王",now(),1)
select * from messages where (senderid=1002 and receiverid=1001) or (senderid=1001 and receiverid=1002) order by createtime ;
select * from messages order by createtime ;
insert into messages values(null,"向着伟哥学习！！！",1002,"猪王",1001,null,now(),1)

