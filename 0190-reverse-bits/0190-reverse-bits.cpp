class Solution {
public:
    int reverseBits(int n) {
        string s="";
        while(n>0)
        {
            char c;
            int r=n%2;
            c=r+'0';
            s+=c;
            n=n/2;
        }
        while(s.length()!=32)
        {
            s=s+"0";
        }
        int k=s.length();
        // for(int i=0;i<s.length()/2;i++)
        // {
        //     swap(s[i],s[k-i-1]);
        // }
        int deci=stoi(s,nullptr,2);
        return deci;
    }
};