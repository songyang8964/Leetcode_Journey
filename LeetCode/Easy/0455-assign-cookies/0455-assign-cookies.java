class Solution {
    int Count = 0;
    int ChildIndex = 0;
    int CookieIndex = 0;

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        while (CookieIndex < s.length && ChildIndex < g.length) {
            if (s[CookieIndex] >= g[ChildIndex]) {
                Count++;
                CookieIndex++;
                ChildIndex++;
            }else{
                CookieIndex++;
            }
            

        }
        return Count;
    }
}