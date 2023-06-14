# leetcode刷题代码
## 代码目录
  
- 数据结构相关代码： `lmz.algorithm.data_structure`
    - 链表代码：`data_structure.linked_list`
    - 二叉树代码：`data_structure.binary_tree`
- 查找相关代码：`lmz.algorithm.find`
    - 二分查找 `lmz.algorithm.find.binary_search`
- 字符串计算 `math.string_calculate`
  - 字符串加法
  - 字符串乘法
  - 字符串表达式
- 数学
  - 位运算 `lmz.algorithm.math.bit_operation`
- 状态压缩 `lmz.algorithm.status_compression`
- 图 `lmz.algorithm.graph`
  - 单源无权图最短路`lmz.algorithm.graph.short_path_no_weight`
    - 多源无权图最短路`lmz.algorithm.graph.short_path_no_weight.multi_source`
## 通用leetcode类结构
建议都使用一个类就行了，**便于自己生成测试用例**，也能减少重复类
- 二叉树结点结点类`TreeNode`

```java
//Definition for a binary tree node.


```
- 链表结点结点类`ListNode`

```java
//Definition for a binary tree node.

```
### 刷题模板和工具类
包含一些常用的刷题代码类和刷题工具类在`lmz.my`包下
- 刷题模板`lmz.my.solution_template`
- 刷题工具类`lmz.my.util`
- 常用模板代码：
  - 字典树Trie: `lmz.my.solution_template.data_structure.trie.Trie.java`
