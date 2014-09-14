public   interface   BinaryTTree<T>
{
//是否为空树
boolean   isEmpty();
//统计树中节点数目
void  count();
//前序遍历 
void    preOrder();
//中序遍历
void   inOrder();    
//后续遍历
void postOrder();
//层次遍历
void   levelOrder();
//树的高度
void   hight();
//查找关键字key
T search(T key);   
//查找关键字key的节点
BinaryNode<T> searchNode(T  key);
//获得父节点
BinaryNode<T>  getParent(BinaryNode<T> node);
//插入根节点
void  insertRoot(T x); 
//插入孩子节点
BinaryNode<T>   insertChild(BinaryNode<T> node,T x,boolean leftChild);   
//移除孩子节点       
void  removeChild(BinaryNode<T> node,  boolean leftChild);
//移除所有节点
void  removeAllChild();
}
