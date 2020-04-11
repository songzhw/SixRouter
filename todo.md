1. intent flag
2. pass arg
✔ 3. precondition (e.g.  user.type == 'vip')
        (p.s. login is actually condition 5.)
✔ 4. precondition - branch ( not vip, then where to go?)
✔ 5. (穿透跳转) [enpower] go to page2 if logged in, otherwise login first and go to page2 automatically
x 6. precondition与enpower的结合
7. precondition与enpower考虑融合成一个条件, 因为反正是类似嘛. 不知道行不行
8. 多级穿透, 如得先登录, 再充vip, 并得是id为奇数用户, 才能进入vip专属页面.
    (首页做成个list, 点击某项得是vip才能查看)
9. deep link  (e.g. notification)



=================
测试用例
1. 登录后进入item detail

2. 登录vip, 最终进入no pay

3. 登录pay, 最终进入pay
