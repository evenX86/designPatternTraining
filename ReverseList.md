- 坚持、刻意练习
- 练习弱点、缺陷
-  会感到不舒服，不爽，枯燥

链表是我的缺陷的地方，字节面试手撕代码的时候竟然会连最基础的链表反转都写了那么久还写的不对。

反转链表原题:
https://leetcode.com/problems/reverse-linked-list/

这道题咋一看可能会纠结于怎么反转通过变量转换，类似(a,b) 交换，有这种思路就进入了死胡同
因为永远会有丢失指针的问题存在
```
    tmp = head.next;
    head.next = head;    
    head =tmp;
```
这样的代码进行到下一步next的时候会把前面的关系给丢掉，就算是使用head.next.next来也一样的会有这样的问题
进入到死胡同之后，时间太久，特别是简单题一定要及时转换思路。考虑下既然在原链表里转换不行那要不要试试新生成一个链表或者是多用两个临时变量。
如以下解法
```
res = null
while(head != null) {
    tmp = new Node(head.val);
    tmp.next = res;
    res= tmp;
    head = head.next
}
```
写出来之后会发现非常简单., 其实就是这样，优美的解法都很简单，问题变得复杂在于思路不对

