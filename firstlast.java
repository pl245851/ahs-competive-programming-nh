import java.util.Arrays;
import java.util.Scanner;

public class firstlast {

	static int[] nums;
	static int[] memo;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numbers = scanner.nextInt();
		nums = new int[numbers];
		memo = new int[numbers];
		Arrays.fill(memo, -1);
		for(int i = 0; i< numbers; i++) {
			nums[i] = scanner.nextInt();
		}
		int best = 0;
		for (int i = 0; i < nums.length; i++) {
			best = Math.max(best, solve(i));
		}
		System.out.printf("%d",numbers - best);
		
	}
	
	public static int solve(int index) {
		if (index == nums.length - 1) {
			return 1;
		}
		
		if (memo[index] != -1) 
			return memo[index];
		
		int max = 0;
		for (int i = index + 1; i < nums.length; i++) {
			if (nums[i] == nums[index]+1) {
				max = Math.max(max, 1 + solve(i));
			}
		}
		
		memo[index] = max;
		return max;
	}

}
/*
8
8
3
6
7
4
1
5
2

5
1
2
5
3
4

105
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32
33
34
35
36
37
38
39
40
41
42
43
44
45
46
47
48
49
50
51
52
53
54
55
56
57
58
59
60
61
62
63
64
65
66
67
68
69
70
71
72
73
74
75
76
77
78
79
80
81
82
83
84
85
86
87
88
89
90
91
92
93
94
95
96
97
98
99
100
101
102
103
104
105

105
62 
113
44 
73 
5 
36 
18 
51 
112 
104 
49 
60 
29 
13 
23 
38 
37 
2 
8 
35 
103 
4 
53 
17 
92 
28 
11 
47 
15 
21 
67 
96 
32
82
10 
64 
111 
46 
102 
90 
27 
58 
99 
1 
31 
105 
40 
81 
68 
87 
100
65 
34 
25 
108
80 
30 
54 
78 
76 
7 
107 
41 
94 
77 
6 
14 
55 
79 
109 
3 
89 
85 
66
45 
84 
24 
48 
63
19
115 
69 
9 
74 
88 
59 
114 
72 
98 
95 
50 
61 
75 
106 
22 
16 
56 
71 
91 
42 
97
101 
33 
43 
26 
20
70
86 
110 
12 
83 
93 
39 
57 
52

105
39
30
102
64
40
28
54
49
104
92
10
12
34
2
58
105
63
18
67
38
6
62
85
26
109
98
70
35
52
1
56
50
3
9
71
44
17
81
45
7
66
114
32
111
65
86
73
72
68
91
37
101
57
96
11
107
106
99
4
33
79
100
59
78
95
19
47
76
23
8
82
80
60
27
21
29
103
42
53
88
22
46
97
55
108
77
15
74
51
93
69
87
14
113
94
89
31
112
110
43
16
20
41
48
13
84
24
25
90
5
61
115
83
75
36
*/