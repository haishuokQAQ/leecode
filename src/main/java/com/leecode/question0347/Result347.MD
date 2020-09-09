前 K 个高频元素
=== 
题目
----
给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

 

示例 1:

输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
示例 2:

输入: nums = [1], k = 1
输出: [1]
 

提示：

你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
你可以按任意顺序返回答案。

---
题解
----
####个人思路：
#####数据结构   
空间换时间，排序链表+哈希表。     
哈希表为Map<Integer,Node>指向具体的节点，链表为降序链表。   
链表节点中有一个Counter值用于计数，并存在向父级别的指针   
#####流程
遍历整个数字数组，在Map中查找是否存在该数字，如果存在则把Node里的counter增加1，
如果不存在则新建一个Node，counter为1，并插到链表最后。   
操作完毕后对比当前Node和其上一个Node的counter值大小，若当前Node counter值大于上一节点，
则将该节点和上一节点替换位置，直到其为头节点或上层节点的counter值大于当前节点
#####性能优化

---
经验
----
本题的经验是双向链表的插入：  
双向链表调整位置需要动6个指针，假设为A-B-C-D四个连续节点，如果B和C需要交换，则要动A的next指针、D的previous指针、B的前后指针，C的前后指针。  
个人觉得最好的方法是先保存B和C的引用，先把A、D相关的指针修改完成。伪代码如下：(已知C的情况下)   
```
previous = C.previous
if previous.previous != null 
  previous.previous.next = C
if C.next != null
  C.next.previous = previous
C.previous = previous.previous
previous.next = C.next

C.next = previous
previous.previous = C

```
