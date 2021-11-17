import java.io.*;
import java.nio.file.*;
import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;
import java.time.Instant;
import static java.lang.Math.max;

public class seniorsem
{
    //load file into list method
    public static List<String> loadFile(String filename)
    {
        List<String> input = Collections.emptyList();
        try
        {
            input = Files.readAllLines(Paths.get(filename));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return input;
    }
    //KMP preprocessing method
    public static void preProcess(String pat, int[] lps)
    {
        int i = 0, j = 1;
        lps[0] = 0;
        //fill longest prefix that is suffix array
        while (j < pat.length())
        {
            //if char at j == char at i, increment i, add i's value to the lps array at j, then increment j
            if (pat.charAt(j) == pat.charAt(i))
            {
                ++i;
                lps[j] = i;
                ++j;
            }
            else
            {
                //if i != 0, change i's value to that of lps array at i-1
                if (i != 0)
                {
                    i = lps[i-1];
                }
                else
                {
                    //else add i's value to lps array at j and increment j
                    lps[j] = i;
                    ++j;
                }
            }
        }
    }
    //Boyer-Moore preprocessing method
    public static void preProcessBM(String pat, int[] charCount)
    {
        //initialize array elements to -1
        for (int i = 0; i < charCount.length; ++i)
        {
            charCount[i] = -1;
        }
        char[] pattern = pat.toCharArray();
        //record last occurrence of each character in the pattern into charCount
        for (int i = 0; i < pat.length(); ++i)
        {
            charCount[pattern[i]] = i;
        }
    }
    //Two-way algorithm preprocessing methods listCmp, maxSuf, and maxSufTilde
    private static int listCmp(List<Character> a, int aIdx, List<Character> b, int bIdx,
                                int length) {
        int i = 0;

        for (i = 0; i < length && aIdx + i < a.size() && bIdx + i < b.size(); i++) {
            if (a.get(aIdx + i) == b.get(bIdx + i))
                ;
            else if (a.get(aIdx + i) > b.get(bIdx + i))
                return 1;
            else
                return 2;
        }

        if (i < length)
            if (a.size() - aIdx == b.size() - bIdx)
                return 0;
            else if (a.size() - aIdx > b.size() - bIdx)
                return 1;
            else
                return 2;
        else
            return 0;
    }

    /* Computing of the maximal suffix for <= */
    private static int maxSuf(List<Character> x, int[] p) {
        int ms, j, k, m = x.size();
        char a, b;

        ms = -1;
        j = 0;
        k = p[0] = 1;
        while (j + k < m) {
            a = x.get(j + k);
            b = x.get(ms + k);
            if (a < b) {
                j += k;
                k = 1;
                p[0] = j - ms;
            } else if (a == b)
                if (k != p[0])
                    ++k;
                else {
                    j += p[0];
                    k = 1;
                }
            else { /* a > b */
                ms = j;
                j = ms + 1;
                k = p[0] = 1;
            }
        }
        return (ms);
    }

    /* Computing of the maximal suffix for >= */
    private static int maxSufTilde(List<Character> x, int[] p) {
        int ms, j, k, m = x.size();
        char a, b;

        ms = -1;
        j = 0;
        k = p[0] = 1;
        while (j + k < m) {
            a = x.get(j + k);
            b = x.get(ms + k);
            if (a > b) {
                j += k;
                k = 1;
                p[0] = j - ms;
            } else if (a == b)
                if (k != p[0])
                    ++k;
                else {
                    j += p[0];
                    k = 1;
                }
            else { /* a < b */
                ms = j;
                j = ms + 1;
                k = p[0] = 1;
            }
        }
        return (ms);
    }

    //Knuth-Morris-Pratt Algorithm
    public static void KMP(String pattern, List<String> content)
    {
        int[] lps = new int[pattern.length()];
        int patIndex = 0;
        int count = 0;

        //convert pattern to character list
        List<Character> pat = pattern.chars().mapToObj(e -> (char)e).collect(Collectors.toList());

        //go through list string by string and convert to character list
        List<Character> con = content.stream().collect(Collectors.joining()).chars().mapToObj(e -> (char)e).collect(Collectors.toList());

        //preprocess pattern
        preProcess(pattern, lps);

        //check pattern against each string until a match is found
        for (int i = 0; i < con.size();)
        {
            if (pat.get(patIndex).equals(con.get(i)))
            {
                ++i;
                ++patIndex;
            }
            //If match is found
            if (patIndex == pat.size())
            {
                ++count;
                //System.out.println("Match found at: " + (i-patIndex));  //For printing the first match location
                patIndex = lps[patIndex-1];
                //break;    //For only finding first match in input
            }
            //If a mismatch is found
            else if (i < con.size() && pat.get(patIndex) != con.get(i))
            {
                //and pattern index is not 0
                if (patIndex != 0)
                    patIndex = lps[patIndex-1];
                else
                    ++i;
            }
        }
        System.out.println("Matches: " + count);
    }
    //Boyer-Moore Algorithm
    public static void BM(String pattern, List<String> content)
    {
        //convert pattern to character list
        List<Character> pat = pattern.chars().mapToObj(e -> (char)e).collect(Collectors.toList());

        //go through list string by string and convert to character list
        List<Character> con = content.stream().collect(Collectors.joining()).chars().mapToObj(e -> (char)e).collect(Collectors.toList());

        int plen = pattern.length();
        int clen = con.size();
        int index = 0;
        int count = 0;

        //preprocess pattern
        int[] charCount = new int[256];
        preProcessBM(pattern, charCount);

        //check pattern against content for matches
        while (index <= (clen-plen))
        {
            //start at the end of the pattern
            int i = plen-1;

            //Reduce index when characters in pattern and content match
            while (i >= 0 && pat.get(i) == con.get(index+i))
                --i;
            //if i < 0, then a match has been found at the current index
            if (i < 0)
            {
                ++count;
                //System.out.println("Match found at: " + index); //For printing the first match location
                //move index so that the next character of the content is
                //aligned with the last occurrence of it in the pattern
                if (index+plen < clen)      //in case the pattern is at the end of the content
                {
                    index += plen-charCount[con.get(index+plen)];
                }
                else
                {
                    index += 1;
                }
                //break; //for finding only the first match
            }
            //else shift the pattern so the mismatched character in the content
            //aligns with the last occurrence of it in the pattern
            else
            {   //max is used in case a negative index occurs
                index += max(1, i-charCount[con.get(index+i)]);
            }
        }
        System.out.println("Matches: " + count);
    }
    //Two-way algorithm
    public static void TW(String pattern, List<String> content) {
        //convert pattern to character list
        List<Character> x = pattern.chars().mapToObj(e -> (char)e).collect(Collectors.toList());

        //go through list string by string and convert to character list
        List<Character> y = content.stream().collect(Collectors.joining()).chars().mapToObj(e -> (char)e).collect(Collectors.toList());

        int count = 0;
        int i, j, ell, memory, per, m = x.size(), n = y.size();
        int[] p = new int[1], q = new int[1];
        List<Integer> result = new ArrayList<>();

        /* Preprocessing */
        i = maxSuf(x, p);
        j = maxSufTilde(x, q);
        if (i > j) {
            ell = i;
            per = p[0];
        } else {
            ell = j;
            per = q[0];
        }

        /* Searching */
        if (listCmp(x, 0, x, per, ell + 1) == 0) {
            j = 0;
            memory = -1;
            while (j <= n - m) {
                i = max(ell, memory) + 1;
                while (i < m && x.get(i) == y.get(i + j))
                    ++i;
                if (i >= m) {
                    i = ell;
                    while (i > memory && x.get(i) == y.get(i + j))
                        --i;
                    if (i <= memory) {
                        result.add(j);
                        //System.out.println("Match found at: " + j); //For printing the first match location
                        //break;    //For only finding the first match
                    }
                    j += per;
                    memory = m - per - 1;
                } else {
                    j += (i - ell);
                    memory = -1;
                }
            }
        } else {
            per = max(ell + 1, m - ell - 1) + 1;
            j = 0;
            while (j <= n - m) {
                i = ell + 1;
                while (i < m && x.get(i) == y.get(i + j))
                    ++i;
                if (i >= m) {
                    i = ell;
                    while (i >= 0 && x.get(i) == y.get(i + j))
                        --i;
                    if (i < 0) {
                        result.add(j);
                        //System.out.println("Match found at: " + j); //For printing the first match location
                        //break;    //For only finding the first match
                    }
                    j += per;
                } else
                    j += (i - ell);
            }
        }
        if (result.size() > 0)
        {
            count = result.size();
        }
        System.out.println("Matches: " + count);
    }

    //Timing method for getting the running time for each algorithm
    public static void getTimingInfo (int alg, String pattern, List<String> content)
    {
        //Get start time
        Instant startTime = Instant.now();
        //calls each algorithm depending on the input
        switch (alg)
        {
            case 1:
                KMP(pattern, content);
                break;
            case 2:
                BM(pattern, content);
                break;
            case 3:
                TW(pattern, content);
                break;
        }
        //Get stop time
        Instant stopTime = Instant.now();
        //Calculate total time
        long totalTime = Duration.between(startTime,stopTime).toNanos();
        //Convert to seconds
        double totalsec = (double) totalTime/1000000000;
        //Print out total time for each algorithm
        System.out.print("Algorithm " + alg + " Runtime: " + totalsec + " seconds\n");
    }
    //Driver
    public static void main(String[] args) throws IOException
    {
        //Declare variables
        List<String> content;
        Scanner scan = new Scanner(System.in);
        String filename, pattern;

        //get filename from user
        System.out.println("Enter file name: ");
        filename = scan.nextLine();

        //load file into string list
        content = loadFile(filename);

        //get pattern input
        System.out.println("Enter word to search: ");
        pattern = scan.nextLine();

        //run each algorithm with pattern on list
        //and output speed and accuracy for each
        for (int i = 1; i <= 3; ++i)
        {
            getTimingInfo(i, pattern, content);
        }
    }
}
