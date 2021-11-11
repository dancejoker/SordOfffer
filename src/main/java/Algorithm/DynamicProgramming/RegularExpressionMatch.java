package Algorithm.DynamicProgramming;

/**
 * 描述
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class RegularExpressionMatch {
    /**
     * 1.状态定义：dp[n][m] 表示原字符串长度为n，模式串长度为m时，是否能够匹配。
     * 2.初始化：当原串和模式串都为空时，显然能够匹配，dp[0][0]=truedp[0][0]=true ;
     * 当模式串为空，而原串不为空时，均为false 。
     * 3.状态转移：分模式串后一个位置是否为'*'进行讨论,为'*'时，将'*'与前一个位置合并起来进行考虑。
     * 如果后一个位置不为'*'，并且当前模式串字符和原串字符匹配，则满足
     * dp[i][j]=dp[i-1][j-1] ；如果后一个位置为'*'，
     * 无论是否匹配，均满足dp[i][j]=dp[i][j-2] (匹配0次)，
     * 如果匹配，满足dp[i][j]=dp[i-1][j]||dp[i][j-2] (匹配1到无穷次或0次)
     */
    public boolean match (String str, String pattern) {
        int n = str.length();
        int m = pattern.length();
        boolean[][] dp = new boolean[n+1][m+1];

        //初始化
        dp[0][0]=true;
        // 可以省略，初始化时就全是false
        for(int i = 1;i <= n;i++){
            dp[i][0]=false;
        }

        //分模式串的后一个位置是否为*进行讨论,为*时，将*与前一个位置合并起来进行考虑
        for(int i = 0;i <= n;i++){
            for(int j = 1;j <= m;j++){
                if(pattern.charAt(j-1) != '*'){
                    //当前模式串字符和原串字符匹配
                    if(i > 0 && (str.charAt(i-1) == pattern.charAt(j-1) || (pattern.charAt(j-1)=='.'))){
                        dp[i][j] = dp[i-1][j-1];
                    }
                }
                else{
                    if(j>=2){
                        //不管是否匹配，都可以将当前字符绑定上*匹配原串字符0次
                        dp[i][j] = dp[i][j-2];
                        //当前模式串字符和原串字符匹配
                        if(i > 0 && (str.charAt(i-1) == pattern.charAt(j-2) || (pattern.charAt(j-2) == '.'))){
                            dp[i][j]=dp[i-1][j]||dp[i][j-2];
                        }
                    }
                }
            }
        }
        for(int i= 0;i<=n;i++){
            for(int j=0;j<=m;j++){
                System.out.print(dp[i][j]+",");
            }
            System.out.println();
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        RegularExpressionMatch regularExpressionMatch = new RegularExpressionMatch();
        System.out.println(regularExpressionMatch.match("123","123"));


    }

}
