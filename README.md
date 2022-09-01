# leetcode刷题代码
## 代码目录
  
- 数据结构相关代码： `codeofli.leetcode.data_structure`
    - 链表代码：`data_structure.linked_list`
    - 二叉树代码：`data_structure.binary_tree`
- 字符串计算 `math.string_calculate`
  - 字符串加法
  - 字符串乘法
  - 字符串表达式
- 数学
  - 位运算 `codeofli.leetcode.math.bit_operation`
- 状态压缩 `codeofli.leetcode.status_compression`
- 图 `codeofli.leetcode.graph_theory`
  - 单源无权图最短路`codeofli.leetcode.graph_theory.short_path_no_weight`
    - 多源无权图最短路`codeofli.leetcode.graph_theory.short_path_no_weight.multi_source`
## 通用leetcode类结构
建议都使用一个类就行了，**便于自己生成测试用例**，也能减少重复类
- 二叉树结点结点类`TreeNode`

```java
//Definition for a binary tree node.


```
- 链表结点结点类`TreeNode`
```java
//Definition for a binary tree node.
import codeofli.leetcode.data_structure.linked_list.ListNode;
```
### 刷题模板和工具类
包含一些常用的刷题代码类和刷题工具类在`codeofli.my`包下
- 刷题模板`codeofli.my.solution_template`
- 刷题工具类`codeofli.my.util`