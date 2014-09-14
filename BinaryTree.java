import  java.util.*;

public class BinaryTree<T>  implements  BinaryTTree< T > 
{

BinaryNode< T > root;   
public  BinaryTree()
{		
 this.root=null;
}
//树是否为空
public boolean  isEmpty()
{	
return  this.root==null;
}    
//通过前序，中序序列构建二叉树
public  BinaryTree(T[]   prelist,  T[]  inlist )
{
this.root=create(prelist,inlist,0,0,prelist.length); 
}

public  BinaryNode<T>  create(T[]  prelist,T[]  inlist,int  preStart,int  inStart,  int  n)
{
	
	
if(n<=0) return  null;
     
T elem=prelist[preStart];
     
BinaryNode<T> p=new BinaryNode<T>(elem);
     
int  i=0;
  
while(i<n&&!elem.equals(inlist[inStart+i]))
    	
i++; 
    
p.leftChild=create(prelist,inlist,preStart+1,inStart,i);
    
     
p.rightChild=create(prelist,inlist,preStart+1+i,inStart+i+1,n-i-1); 
    
        
return   p; 
         
}    
//前序遍历
public void  preOrder()
{
System.out.println("前序遍历");
preOrder(root);
System.out.println();
}
//前序遍历具体实现方法
public  void preOrder(BinaryNode<T>  curr)
{
if(curr==null)  return   ; 
System.out.println(curr.data.toString());
preOrder(curr.leftChild);
preOrder(curr.rightChild); 
}
//中序遍历
public   void inOrder()
{
System.out.println("中序遍历");
inOrder(root);
System.out.println();
}
//中序遍历具体实现方法
public void inOrder(BinaryNode<T>  curr )
{
if(curr==null)return;   
inOrder(curr.leftChild);
System.out.println(curr.data.toString());
inOrder(curr.rightChild);
}
//递归后续遍历
public void postOrder()
{
System.out.println("后续遍历");
postOrder(root);
System.out.println();
}
//递归后续遍历具体实现方法
public   void  postOrder(BinaryNode<T> curr)
{
if(curr==null)  return;  
postOrder(curr.leftChild);
postOrder(curr.rightChild);
System.out.println(curr.data.toString());
}   
//层次遍历
public void  levelOrder()
{
System.out.println("层次遍历");
levelOrder(root);
System.out.println(); 
}
//层次遍历具体实现方法
public void levelOrder(BinaryNode<T> curr)
{
//未实现
}
//统计树中节点数目
public       void     count()
{
System.out.println  (count(this.root));  
}
//统计树中节点数目具体方法
public    int  count(BinaryNode<T> node)
{
if(node==null)   return   0  ; 
return  1+count(node.leftChild)+count(node.rightChild); 	
}

//树的最大深度
public  void   hight()
{
System.out.println("the  hight  of  the Binarytree");
System.out.println(hight(this.root));
}

//树的最大深度具体实现方法
public   int    hight(BinaryNode<T>    curr)
{
if(curr==null)  return  0; 
int lh=hight(curr.leftChild);  
int rh=hight(curr.rightChild);   
return      lh>=rh?(1+lh):(1+rh);
}   
//寻找树中是否含有关键字为key的节点
public  T search(T  key)
{
return   searchNode(this.root,key).data;
}

public BinaryNode< T >   searchNode(T key)
{
BinaryNode<T>  p=searchNode(this.root,key);
return  p;
} 
//寻找树中是否含有关键字为key的节点node
public BinaryNode<T>   searchNode(BinaryNode<T> node,T  key)   //未能测试
{
if(node==null||key==null)
{
return  null;
} 
if(node.data==key){
return  node;
}         
BinaryNode<T>  find=searchNode(node.leftChild,key);  
if(find==null)
{
find=searchNode(node.rightChild,key);
} 
return  find;  
} 
//插入关键字key
public  void    insertRoot(T  x)   //只是一个root节点，此时树中没有任何其他节点
{	
/*
* 
* 原理  就是将原来的根节点作为已x为值得节点的左孩子并将新节点作为根节点
* 
*/
this.root=new  BinaryNode<T>(x,  this.root , null);
}

//插入孩子节点
public  BinaryNode<T>  insertChild(BinaryNode<T> node ,T  x,boolean  left)
{
/*
* 	 
*question why is x but nor the node
* 
*      	    
*/	
if(x==null)  return  null;
BinaryNode<T>   temp=new BinaryNode<T>(x);
if(left)
{
node.leftChild=temp;
}
else
{ 
node.rightChild=temp;
}
return  node;
}  
//移除孩子节点
public void removeChild(BinaryNode<T>  curr,    boolean  left)
{
if(curr==null)  return ;
if(left)
{
curr.leftChild=null;
}else
{
curr.rightChild=null;
}  
}
//移除所有孩子节点
public  void  removeAllChild()
{
this.root=null;      
} 
//获得节点父节点
public  BinaryNode<T>  getParent(BinaryNode<T>  curr)
{
if(root==null|| curr==null||curr==root )  //还要考虑curr为root的情况 ，思维不是很严谨
{
return   null;    
}	
return  getParent(root,curr);
}
//获得父节点具体实现
public  BinaryNode<T>   getParent(BinaryNode<T>  p  ,BinaryNode<T>   x )
{
if(p==null||x==null) {
return  null;
}
if(p.leftChild==x||p.rightChild==x)
{
return  p;
}	 
BinaryNode<T>  node=getParent(p.leftChild, x);
if(node==null) {
node=getParent(p.rightChild, x);
}
return  node; 
}
//判断节点是树是否为叶子节点
public void leaf()
{
leaf(root);
}
//判断节点是否是叶子节点
public   void  leaf(BinaryNode<T>    curr )
{
if(curr!=null)
{
if( curr.leftChild==null&&curr.leftChild==null)
{
System.out.println(curr.data.toString());
return ;
}
    	
 /*
  *    
  *this case mean p  isn't  a   leaf  BinaryNode<T>     
  //这里可能有点思路问题
	else {
	leaf(curr.leftChild);
	
	leaf(curr.rightChild);	
		
	}  
	   
   }
  
   
}  

//统计叶子节点数目
public   int  countLeaf()
{
return  countLeaf(root);
} 
//统计叶子节点具体实现方法
public    int   countLeaf(BinaryNode<T> curr )
{
if(curr==null) return  0;   	 
if(curr.leftChild==null&&curr.rightChild==null) {
return   1;	
}    
return  count(curr.leftChild)+count(curr.rightChild); 	       
}
