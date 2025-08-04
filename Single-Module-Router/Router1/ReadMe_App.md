# TODO

## 1. Router Use Case
1. 普通跳转
2. 带参数跳
3. fragment跳
   3.1 FramgnetType改为FragmentMeta, 彻底融入Router体系
4. bottomSheet跳
5. deeplink跳

6. 两deeplink跳同一页
7. 同一deeplink(视参数不同)跳不同页
8. deeplink视FF(feature flag)不同而跳不同页

9. deeplink视login与否, 有些页面loggedOff也可以访问
10. deeplink视login与否, 有些页面要login后自动跳
11. deeplink除了login与否, 有了更多条件, 如country是否set了. 
需求: [c51SMRT-4406](https://nrs-it.atlassian.net/browse/C51SMRT-4406)
    * login用户
      * 已有country, 直接去目标页
      * 无country, 去home页, 设置了country再去目标页
    * guest用户
      * 已有country, 再去判断login与否, 再去目标页之类的
      * 无, guest whitelist页, -> home (set country) -> destination
        * guest blacklist页, -> home (set country) -> login -> destination

12. FF条件来自于后台(非Firebase.FF), 这时如何走要async, 不是立马能得到的, 这个就麻烦了

=> 其实9,  10, 11是指有多个precondition的时候怎么办?
而6,7,8则是多条件多结果的可能重复的一组

## 2. 需要构建的页面
Home页, 带country set
guest页可以走home或login
old detail, new detail (bottom sheet), showcase detail,
my account 
deeplink页接收uri
session相关: splash, login

[guest whitelist]: home, new/old/showcase detail
[guest blacklist]: myAccount, 

## 3. BottomSheet
1). deeplink跳到sheet页, 按back会如何?
    -> 要
2). 