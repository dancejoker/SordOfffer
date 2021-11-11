package Algorithm.FlashBack;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子
 */
public class MatrixFindPath {
    public boolean hasPath (char[][] matrix, String word) {
        //循环多次找到首个字母的初始位置
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==word.charAt(0)){
                    //找到初始位置，设置访问标记数组，可能不是一个，所有每次都创建新数组
                    boolean vis[][]=new boolean[matrix.length][matrix[0].length];
                    //dfs传入初始位置，访问数组，矩阵，寻找的字符位置，字符串
                    if(dfs(i,j,vis,matrix,0,word) == true)
                        return true;
                }
            }
        }
        return false;
    }
    boolean dfs(int m,int n,boolean[][] vis,char[][] matrix,int k,String word){
        //如果m，n位置在矩阵外返回false，如果这一节点走过返回false
        if(m < 0|| n < 0||m >= matrix.length || n >= matrix[0].length || vis[m][n] == true)
            return false;
        //如果这个位置字母和字符串尾字母一样，且字符串序号就是最后一个，代表遍历完了，返回true，不在遍历
        if(word.charAt(word.length()-1) == matrix[m][n] && (k == word.length()-1))
            return true;
        //字符串字母是序号对应字母
        if(word.charAt(k)==matrix[m][n]){
            //访问过了
            vis[m][n]=true;
            //如果上下左右有下一个字母（k+1）则继续遍历，否则访问设置为未访问
            //（每个字母这能经过一次，没有找到下一个字母，所以其实没有访问过）
            if(dfs(m+1,n,vis,matrix,k+1,word) ||
                    dfs(m,n+1,vis,matrix,k+1,word)||
                    dfs(m,n-1,vis,matrix,k+1,word)||
                    dfs(m-1,n,vis,matrix,k+1,word)){
                return true;
            }else{
                vis[m][n]=false;
                return false;
            }
        }else{
            //当前不是对应字母，返回false
            vis[m][n]=false;
            return false;
        }
    }
}
