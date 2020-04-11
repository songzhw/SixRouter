1. intent flag
2. pass arg
✔ 3. precondition (e.g.  user.type == 'vip')
        (p.s. login is actually condition 5.)
✔ 4. precondition - branch ( not vip, then where to go?)
✔ 5. (穿透跳转) [enpower] go to page2 if logged in, otherwise login first and go to page2 automatically
x 6. precondition与enpower的结合
7. precondition与enpower考虑融合成一个条件, 因为反正是类似嘛. 不知道行不行
8. 多级穿透, 如得先登录, 再充vip, 并得是id为奇数用户, 才能进入vip专属页面.
    (cacheDestination可能就不是一个Station类型, 而是一个List<Station>类型了
9. deep link  (e.g. notification)

